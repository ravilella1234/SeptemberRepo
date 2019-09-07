package com.launchings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_003 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		/*driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sony");
		
		Thread.sleep(3000);
		
		WebElement loc = driver.findElement(By.name("field-keywords"));
		
		loc.clear();
		
		loc.sendKeys("philips");
		
		//driver.findElement(By.className("nav-input")).clear();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Samsung");*/
		
		//driver.findElement(By.partialLinkText("Today's Deals")).click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++)
		{
			if(!links.get(i).getText().isEmpty())
			{
				System.out.println(links.get(i).getText());
			}	
		}
	}

}
