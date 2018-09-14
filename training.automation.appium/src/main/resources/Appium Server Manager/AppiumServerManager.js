//required includes
var http = require('http');
var net = require('net');
var os = require('os');

const SERVER_LISTENING_PORT = '4923'; //port that this appium manager listens on
const NODE_PATH = 'C:\\Program Files\\nodejs\\'; //windows only
const APPIUM_PATH = 'C:\\Program Files\\nodejs\\node_modules\\appium\\'; //windows only
const IOS_WEBKIT_DEBUG_PROXY = 'ios_webkit_debug_proxy';  //binary name , should never need to change this
const IOS_DEBUG_PROXY_DEVICE_UDID = '6d2158b232322826f47990fb5f7f73d2617ea6d1'/*'0464173d5acf9c1c5375ddf6d447b72c111d6ff4'*/; //udid of the device to proxy   //IPAD

//program variables
var appiumInstances = [];
var debugProxyProcess = null;
var debugProxyRestarts = 0;

//spawn convienience function
const spawn = require('child_process').spawn;
const exec = require('child_process').exec;

function closeCurrentDebugProxies()
{
	//first cleanup any old ios_webkit_debug_proxies
	if (os.platform() != 'win32')
	{
		spawn("killall", [IOS_WEBKIT_DEBUG_PROXY] );
	}
}

function formatDateSegment(dateSegment)
{
	if (dateSegment.toString().length == 1)
	{
		dateSegment = "0" + dateSegment;
	}
	
	return dateSegment;
}

function logEvent(logText)
{
	console.log(getDateTime() + " : " + logText);
}

function getDateTime() 
{
    var now     = new Date(); 
    var year    = now.getFullYear();
    var month   = formatDateSegment(now.getMonth()+1); 
    var day     = formatDateSegment(now.getDate());
    var hour    = formatDateSegment(now.getHours());
    var minute  = formatDateSegment(now.getMinutes());
    var second  = formatDateSegment(now.getSeconds());   
	
	var dateTime = day + '.' + month + '.' + year + ' ' + hour + ':' + minute + ':' + second; 
	
	return dateTime;
}

function startIosDebugProxy()
{
	if (os.platform() != 'win32')
	{		
		debugProxyProcess = spawn(IOS_WEBKIT_DEBUG_PROXY, ['-c', IOS_DEBUG_PROXY_DEVICE_UDID + ':27753', '-d']);
		debugProxyProcess.stdout.on('data', function (data) {
		logEvent('ios_debug_proxy: ' + data);
		});

		debugProxyProcess.stderr.on('data', function (data) 
		{
			logEvent('ios_debug_proxy: ' + data);
			var restartMessage = false;

			if ( data.indexOf('Invalid message _rpc_applicationUpdated') != -1 ) restartMessage =true;
			if ( data.indexOf('Invalid message _rpc_applicationSentListing') != -1 ) restartMessage =true;
		
			if (restartMessage) 
			{
				debugProxyRestarts= debugProxyRestarts +1;
				debugProxyProcess.kill('SIGKILL');
				process.nextTick(startIosDebugProxy);
			}
		});

		debugProxyProcess.on('close', function (code) {
			logEvent('child process exited with code ' + code);
		});
	}
}

function stopAppium(port)
{
	for (var i=0;i<appiumInstances.length; i++)
	{
		if ( appiumInstances[i].port == port)
		{
			logEvent("stopping appium process with pid " + appiumInstances[i].process.pid + " on port "  + port);
			appiumInstances[i].process.kill('SIGKILL');
			appiumInstances.splice(i,1);
			break;
		}
	}
}

function isAppiumRunning(port)
{
	var appiumIsRunning = false;
	
	logEvent("is appium running on " + port + "?");
	
	for (var i=0;i<appiumInstances.length; i++)
	{
		if ( appiumInstances[i].port == port)
		{
			appiumIsRunning = true;
			break;
		}
	}
	
	logEvent((appiumIsRunning == true ? "yes appium is running on " : "no appium is not running on ") + port);	
	
	return appiumIsRunning;
}

function startAppium(port)
{
	if ( isAppiumRunning(port) )
	{
		stopAppium(port);
	}
	
	logEvent("launching Appium on port " + port);
	
	var childProcess = null;
	
	if (os.platform() == 'win32')
	{
		//clear app data -- adb shell pm clear [package]
		spawn("adb", ['shell','pm','clear', ANDROID_APP_PACKAGE] );

		childProcess = spawn(NODE_PATH + "node", [".", "-p", port], 
		{
			cwd: APPIUM_PATH,
		});
	}
	else //Mac
	{
		childProcess = spawn("appium", ["-p", port], 
		{
			
		});
	}
   
	childProcess.stdout.on('data', function (data) {
		logEvent('appium log : ' + data);
	});
	
	childProcess.stderr.on('data', function (data) {
		logEvent('appium error log : ' + data);
	});
	
	childProcess.on('error', function (error) {
		logEvent('appium exited with error ' + error);
	});
	
	childProcess.on('close', function (code) {
		logEvent('appium exited with code ' + code);
	});

	appiumInstances.push(  { port: port, process:childProcess } );
	logEvent("appium started on port " + port);
}

var server = http.createServer(function(req, res) 
{
	if (req.url.toLowerCase().startsWith("/startappium/"))
	{
		res.writeHead(200);
		var port = parseInt( req.url.substring(13) );
		startAppium(port);
	}	
	else if (req.url.toLowerCase().startsWith("/stopappium/"))
	{
		res.writeHead(200);
		var port = parseInt( req.url.substring(12) );
		logEvent('got request');
		// clearAppiumCache();
		
		stopAppium(port);
	}  
	else if (req.url.toLowerCase().startsWith("/status"))
	{
		logEvent('status request');
		res.writeHead(200);
		
		res.write("Appium server manager Status\n\n" );  
	  
		for (var i=0;i<appiumInstances.length; i++)
		{
			res.write( "Appium instance[" + i + "] pid " + appiumInstances[i].process.pid + " is running on port " + appiumInstances[i].port + "\n" );
		}
	
		if (os.platform() != 'win32')
		{
			res.write( 'ios_webkit_debug_proxy restarted ' + debugProxyRestarts + ' times for device ' + IOS_DEBUG_PROXY_DEVICE_UDID + '\n');
		}
	}	 
	else
	{
		res.writeHead(400);
		res.write('Unknown web request (Please check request command syntax) below \n');
	}
	
	res.end('Http ' + req.url);
});

logEvent("appium server manager is now running on port " + SERVER_LISTENING_PORT);
server.listen(SERVER_LISTENING_PORT);
closeCurrentDebugProxies();
startIosDebugProxy();
	