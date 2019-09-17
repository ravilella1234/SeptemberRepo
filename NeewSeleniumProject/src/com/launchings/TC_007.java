package com.launchings;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class TC_007 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		test=report.startTest("TC_007");
		
		init();
		test.log(LogStatus.INFO, "Initializing the properties files........");
		
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Launched the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.PASS, "Navigated to URL : " + p.getProperty("amazonurl"));
		

		if(!verifyTitle("amazontitlepage"))
			failureReport("Both titles are not equal...");
		else
			passReport("Both titles are  equal...");
		
		
		if(!verifyElement("amazonpay_linktext","amazonpaytext"))
			failureReport("Both Elements are not equal...");
		else
			passReport("Both Elements are  equal...");
		
		
		report.endTest(test);
		report.flush();

	}

	

	

	

}
