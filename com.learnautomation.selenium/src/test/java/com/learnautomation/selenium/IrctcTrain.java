package com.learnautomation.selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IrctcTrain {
	 
	WebDriver driver;
	
	@BeforeClass
	   public void beforeClass() {
	      System.out.println("in beforeClass");
	   }
	  @BeforeMethod
	     public void beforeMethod() throws Exception {
		  driver=new FirefoxDriver();
	     driver.get("https://www.irctc.co.in");
	    }
	  @Test
	  public void test1(){
		  
		  Actions act=new Actions(driver);
		  act.moveToElement(driver.findElement(By.xpath("//a[@id='irctc_tourism']"))).perform();
		  driver.findElement(By.xpath("//div[@id='bluemenu']/ul/li[9]/ul/li[2]/a")).click();
		  
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		  
		  Set<String> set=driver.getWindowHandles(); 
			System.out.println(set.size()); 
			
			Iterator<String> it=set.iterator(); 
			String parentId=it.next(); 
			String childId=it.next(); 
			
			driver.switchTo().window(childId); 
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
			
			driver.findElement(By.xpath("//section[@id='mainpannelNewLook']/div/div/ul/li[2]/div/div/span/a")).click();
			
			}
		  
		  
		  
	  
	  @AfterMethod
	   public void afterMethod() {
	      System.out.println("in afterMethod");
	   }

	   

	   @AfterClass
	   public void afterClass() {
	      System.out.println("in afterClass");
	   }


}
