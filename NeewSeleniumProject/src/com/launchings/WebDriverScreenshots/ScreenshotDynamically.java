package com.launchings.WebDriverScreenshots;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotDynamically 
{

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com");
		//driver.get("http://google.com");
		
		Date dt=new Date();
		String d = dt.toString().replace(':', '_');
		
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile,new File("C:\\Users\\DELL\\Desktop\\Screenshots\\"+d+".jpeg"));
	}

}
