package com.sears.logger;

import org.testng.Reporter;

public class Logger {
	
	public static void log(String message){
		Reporter.log(message+"<br>");
	}

}
