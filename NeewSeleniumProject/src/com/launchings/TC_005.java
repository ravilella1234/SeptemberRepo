package com.launchings;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.LogStatus;

public class TC_005 extends BaseTest
{
	
	private static final Logger log=Logger.getLogger(TC_005.class.getName());
	
	public static void main(String[] args) throws Exception 
	{
		test=report.startTest("TC_005");
		
		init();
		test.log(LogStatus.INFO, "Initializing the properties files........");
		log.info("Initializing the properties files........");
		
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Launched the Browser : " + p.getProperty("chromebrowser"));
		log.info("Launched the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.PASS, "Navigated to URL : " + p.getProperty("amazonurl"));
		
		selectItem("amazondropbox_id","Books");	
		test.log(LogStatus.PASS, "Selected the item Books by using the locator : " + or.getProperty("amazondropbox_id"));
		
		type("amazonsearchtextbox_id","Harry Potter");
		test.log(LogStatus.PASS, "Entered the text Harry Potter by using the locator : " + or.getProperty("amazonsearchtextbox_id"));
			
		click("amazonsearchbutton_xpath");
		test.log(LogStatus.PASS, "Clicked on Amazon Search Button by using locator : " + or.getProperty("amazonsearchbutton_xpath"));
		
		report.endTest(test);
		report.flush();
	
	}
}
