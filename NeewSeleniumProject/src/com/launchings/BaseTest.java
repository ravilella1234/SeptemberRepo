package com.launchings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

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
		if(p.getProperty(browser).equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"//Drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			//FirefoxDriver setup
			System.setProperty("webdriver.gecko.driver", projectPath+"//Drivers//geckodriver.exe");
			
			//clearing execution logs
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "E:\\exelogs.txt");
			
			FirefoxOptions option=new FirefoxOptions();
			
			//Creating the New Profile Object
			ProfilesIni p=new ProfilesIni();
			FirefoxProfile profile = p.getProfile("default");
			
			//notifications
			profile.setPreference("dom.webnotifications.enabled", false);
			
			//proxy servers
			/*profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.socks", "192.168.90.54");
			profile.setPreference("network.proxy.socks_port", 1744);*/
			
			
			option.setProfile(profile);
			
			driver=new FirefoxDriver(option);
		}
		else if(p.getProperty(browser).equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", projectPath+"//Drivers//MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
		}
		  			
	}
	
	
	public static void navigateUrl(String url) 
	{
		//driver.get(p.getProperty(url));
		driver.navigate().to(p.getProperty(url));
	}
	
}
