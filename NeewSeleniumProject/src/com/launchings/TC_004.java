package com.launchings;

import org.apache.log4j.Logger;

public class TC_004 extends BaseTest
{
	private static final Logger log=Logger.getLogger(TC_004.class.getName());
	
	
	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("Initializing the properties files........");
		
		launch("chromebrowser");
		log.info("Launched the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to URL : " + p.getProperty("amazonurl"));
		
		selectItem("amazondropbox_id","Books");	
		log.info("Selected the item Books by using the locator : " + or.getProperty("amazondropbox_id"));
		
		type("amazonsearchtextbox_id","Harry Potter");
		log.info("Entered the text Harry Potter by using the locator : " + or.getProperty("amazonsearchtextbox_id"));
		
		click("amazonsearchbutton_xpath");
		log.info("Clicked on Amazon Search Button by using locator : " + or.getProperty("amazonsearchbutton_xpath"));
		
		
		
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
	}
}
