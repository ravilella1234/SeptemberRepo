package com.launchings;

import org.openqa.selenium.By;

public class TC_001 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("hdfcurl");
		
		driver.manage().window().maximize();
				
		driver.findElement(By.xpath("//img[@class='popupCloseButton']")).click();
		
		/*String title = driver.getTitle();
		System.out.println(title);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		String src = driver.getPageSource();
		System.out.println(src);
		
		driver.manage().deleteAllCookies();
		
		driver.navigate().back();
		
		Thread.sleep(5000);
		
		driver.navigate().forward();
		
		Thread.sleep(5000);
		
		driver.navigate().refresh();*/
		
		driver.findElement(By.id("loginsubmit")).click();
		
		//driver.close();
		
		driver.quit();
	}

	

}
