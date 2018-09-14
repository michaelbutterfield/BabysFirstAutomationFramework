package application;

import application.appleclock.pages.AddWorldClockModal;
import application.appleclock.pages.Alarm;
import application.appleclock.pages.Stopwatch;
import application.appleclock.pages.Timer;
import application.appleclock.pages.WorldClock;
import application.appleclock.sections.BottomNavigationBar;

public class Clock
{
	public static BottomNavigationBar bottomNavigationBar;
	public static WorldClock worldClock;
	public static Alarm alarm;
	public static Stopwatch stopwatch;
	public static Timer timer;
	public static AddWorldClockModal addWorldClockModal;
	
	static
	{
		buildPages();
		buildSections();
	}
	
	public static void buildPages()
	{
		worldClock = new WorldClock();
		addWorldClockModal = new AddWorldClockModal();
		alarm = new Alarm();
		stopwatch = new Stopwatch();
		timer = new Timer();
	}
	
	private static void buildSections()
	{
		bottomNavigationBar = new BottomNavigationBar();
	}
}
