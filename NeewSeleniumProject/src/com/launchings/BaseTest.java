package com.launchings;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
	public static Properties or;
	
	
	
	public static void init() throws Exception
	{
		FileInputStream fis1=new FileInputStream(projectPath+"//data.properties");
		p=new Properties();
		p.load(fis1);
		
		FileInputStream fis2=new FileInputStream(projectPath+"//OR.properties");
		or=new Properties();
		or.load(fis2);
		
		PropertyConfigurator.configure(projectPath+"//log4j.properties");
	}
	
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"//Drivers//chromedriver.exe");
			
			ChromeOptions option=new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 7");
			
			option.addArguments("--disable-notifications");
			option.addArguments("--disable-infobars");
			option.addArguments("--start-maximized");
			
			//Proxy IP Configuration
			//option.addArguments("--proxy-server=http://192.168.90.84:1234");
			
			driver=new ChromeDriver(option);
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
		driver.get(p.getProperty(url));
		//driver.navigate().to(p.getProperty(url));
		driver.manage().window().maximize();
	}
	
	
	private static WebElement getElement(String locatorKey) 
	{
		WebElement element=null;
		
		if(locatorKey.endsWith("_id")) {
			element=driver.findElement(By.id(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element=driver.findElement(By.name(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element=driver.findElement(By.className(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("css")) {
			element=driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element=driver.findElement(By.linkText(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element=driver.findElement(By.partialLinkText(or.getProperty(locatorKey)));
		}
		return element;
		
	}
	
	public static void selectItem(String locatorKey, String itemToSelect) 
	{
		getElement(locatorKey).sendKeys(itemToSelect);
		//driver.findElement(By.name(or.getProperty(locatorKey))).sendKeys(itemToSelect);
	}


	public static void type(String locatorKey, String value) 
	{
		getElement(locatorKey).sendKeys(value);
		//driver.findElement(By.id(or.getProperty(locatorKey))).sendKeys(value);
	}
	
	
	public static void click(String locatorKey) 
	{
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(or.getProperty(locatorKey))).click();
		
	}
	
}
