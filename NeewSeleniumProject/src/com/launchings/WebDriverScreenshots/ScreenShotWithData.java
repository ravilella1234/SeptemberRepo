package com.launchings.WebDriverScreenshots;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class ScreenShotWithData 
{

	public static void main(String[] args) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		Date dt=new Date();
		System.out.println(dt);
		//String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".jpeg";
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("C:\\Users\\DELL\\Desktop\\"+ dateFormat.format(dt)+".jpeg"));
		FileHandler.copy(scrFile, new File("C:\\Users\\DELL\\Desktop\\"+ dateFormat.format(dt)+".jpeg"));
	}

}
