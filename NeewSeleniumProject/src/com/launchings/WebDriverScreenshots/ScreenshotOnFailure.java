package com.launchings.WebDriverScreenshots;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotOnFailure 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://newtours.demoaut.com");
		//driver.get("https://try.powermapper.com/Demo/SortSite");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			List<WebElement> links=driver.findElements(By.tagName("a"));
			System.out.println(links.size());

			for(int i=0;i<links.size();i++)
			{
				if(!links.get(i).getText().isEmpty())
				{
				   String linkname=links.get(i).getText();
				   links.get(i).click();
				   
				   if(driver.getTitle().contains("Register: Mercury Tours"))
				  {
					   Date dt=new Date();
					   SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
					  
					   
					   File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					   //FileUtils.copyFile(srcFile,new File("C:\\Users\\DELL\\Desktop\\Screenshots123\\" +linkname+ "_" +dateFormat.format(dt)+".png"));
					   //FileHandler.copy(srcFile,new File("C:\\Users\\DELL\\Desktop\\Screenshots123\\" +linkname+ "_" +dateFormat.format(dt)+".png"));
					   FileHandler.copy(srcFile,new File(System.getProperty("user.dir")+"//Screenshots//" +linkname+ "_" +dateFormat.format(dt)+".png"));
				   }
				   
				   //Thread.sleep(3000);
				   //driver.navigate().back();
				  links=driver.findElements(By.tagName("a"));
			    }
			}
	}
	
	
}
