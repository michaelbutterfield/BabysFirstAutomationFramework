package application;

import application.applecalendar.pages.MainCalendarPage;
import application.applecalendar.pages.NewCalendarEventPage;
import application.applecalendar.sections.BottomCalendarNavigationBar;
import application.applecalendar.sections.TopCalendarNavigationBar;
import application.appleclock.pages.AddWorldClockModal;
import application.appleclock.pages.Alarm;
import application.appleclock.pages.Stopwatch;
import application.appleclock.pages.Timer;
import application.appleclock.pages.WorldClock;
import application.appleclock.sections.BottomClockNavigationBar;
import application.applecontacts.pages.ContactsPage;
import application.applecontacts.pages.NewContactPage;

public class MobileApp
{
	public static AddWorldClockModal addWorldClockModal;
	public static Alarm alarm;
	public static BottomCalendarNavigationBar bottomCalendarNavigationBar;
	public static BottomClockNavigationBar bottomClockNavigationBar;
	public static ContactsPage contactsPage;
	public static MainCalendarPage mainCalendarPage;
	public static NewContactPage newContactPage;
	public static NewCalendarEventPage newCalendarEventPage;
	public static Stopwatch stopwatch;
	public static Timer timer;
	public static TopCalendarNavigationBar topCalendarNavigationBar;
	public static WorldClock worldClock;
	
	static
	{
		buildPages();
		buildSections();
	}
	
	private static void buildPages()
	{
		addWorldClockModal = new AddWorldClockModal();
		alarm = new Alarm();
		contactsPage = new ContactsPage();
		mainCalendarPage = new MainCalendarPage();
		newContactPage = new NewContactPage();
		newCalendarEventPage = new NewCalendarEventPage();
		stopwatch = new Stopwatch();
		timer = new Timer();
		worldClock = new WorldClock();
	}
	
	private static void buildSections()
	{
		bottomCalendarNavigationBar = new BottomCalendarNavigationBar();
		bottomClockNavigationBar = new BottomClockNavigationBar();
		topCalendarNavigationBar = new TopCalendarNavigationBar();
	}
}
