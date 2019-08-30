package com.launchings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch 
{
	
	
	
	public static void main(String[] args) 
	{
		WebDriver driver;
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\Driver\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.bestbuy.com");
		
		
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\DELL\\Desktop\\Driver\\MicrosoftWebDriver.exe");
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//Drivers//MicrosoftWebDriver.exe");
		driver=new EdgeDriver();
		driver.get("https://www.ebay.com");
		
		
	}

}
