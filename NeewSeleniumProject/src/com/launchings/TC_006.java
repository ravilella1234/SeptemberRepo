package com.launchings;

import javax.swing.SortingFocusTraversalPolicy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class TC_006 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		test=report.startTest("TC_006");
		
		init();
		test.log(LogStatus.INFO, "Initializing the properties files........");
		
		
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Launched the Browser : " + p.getProperty("chromebrowser"));
		
		
		navigateUrl("amazonurl");
		test.log(LogStatus.PASS, "Navigated to URL : " + p.getProperty("amazonurl"));
		
		
		
		
		String actualLink = driver.findElement(By.linkText("Amazon Pay")).getAttribute("href");
		String expectedLink="Amazon Pay";
		
		System.out.println("Actual Links is : " + actualLink);
		System.out.println("Expected Links is : " + expectedLink);
		
		//Assert.assertEquals(actualLink, expectedLink);
		//Assert.assertTrue(actualLink.equals(expectedLink), "Both Links are not equal...");
		
		SoftAssert s=new SoftAssert();
		
		s.assertEquals(actualLink, expectedLink);
		driver.findElement(By.linkText("Amazon Pay")).click();
		
		s.assertTrue(actualLink.equals(expectedLink), "Both Links are not equal...");

		s.assertTrue(true, "error1");
		
		s.assertTrue(false, "error2");
		
		
		s.assertTrue(false, "error3");
		
		
		
		s.assertAll();
		
		
		/*WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));
		loc.sendKeys("samsung");
		String txt = loc.getAttribute("value");
		System.out.println("Text you entered is :" + txt);*/
		
		
		
		/*String actualLink = driver.findElement(By.linkText("Amazon Pay")).getAttribute("href");
		String expectedLink="Amazon Pay";
		
		System.out.println("Actual Links is : " + actualLink);
		System.out.println("Expected Links is : " + expectedLink);
		
		if(actualLink.contentEquals(expectedLink))
		{
			System.out.println("Both Links are equal....");
		}
		else
		{
			System.out.println("Both Links are not equal....");
		}*/
		
		
		/*String actualTitle = driver.getTitle();
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		System.out.println("Actual Title is : " + actualTitle);
		System.out.println("Expected Title is : " + expectedTitle);
		
		//if(actualTitle.equals(expectedTitle))
		//if(actualTitle.equalsIgnoreCase(expectedTitle))
		//if(actualTitle.contains(expectedTitle))
		if(actualTitle.contentEquals(expectedTitle))
		{
			System.out.println("Both titles are equal....");
		}
		else
		{
			System.out.println("Both titles are not equal....");
		}*/
		
		
		
		report.endTest(test);
		report.flush();

	}

}
