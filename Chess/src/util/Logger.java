package util;

public class Logger {
	public static LoggerLevel publicLevel = LoggerLevel.WARNING;
	private static String defaultTag = "Static Logger";
	
	
	//Log
	public static void log(String tag, String message) {
		if(publicLevel.shouldPrint(LoggerLevel.LOG)){
			System.out.println("LOG " + tag + ": " + message);
		}
	}
	public static void log(String message) {
		log(defaultTag, message);
	}
	
	//Debug
	public static void debug(String tag, String message) {
		if(publicLevel.shouldPrint(LoggerLevel.DEBUG)){
			System.out.println("DEBUG " + tag + ": " + message);
		}
	}
	public static void debug(String message) {
		debug(defaultTag, message);
	}
	
	//Warning
	public static void warning(String tag, String message) {
		if(publicLevel.shouldPrint(LoggerLevel.WARNING)){
			System.out.println("WARNING " + tag + ": " + message);
		}
	}
	public static void warning(String message) {
		warning(defaultTag, message);
	}
	
	//Error
	public static void error(String tag, String message) {
		if(publicLevel.shouldPrint(LoggerLevel.ERROR)){
			System.out.println("ERROR " + tag + ": " + message);
		}
	}
	public static void error(String message) {
		error(defaultTag, message);
	}
	
	
	
	public static void setLoggerLevel(LoggerLevel newLevel){
		publicLevel = newLevel;
	}
}
