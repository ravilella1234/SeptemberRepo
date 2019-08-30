package com.launchings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static Properties p;
	
	public static void init() throws Exception
	{
		FileInputStream fis=new FileInputStream(projectPath+"//data.properties");
		p=new Properties();
		p.load(fis);
	}
	
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"//Drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath+"//Drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(p.getProperty(browser).equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", projectPath+"//Drivers//MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
		}
		  			
	}
	
	
	public static void navigateUrl(String url) 
	{
		driver.get(p.getProperty(url));
	}
	

}
