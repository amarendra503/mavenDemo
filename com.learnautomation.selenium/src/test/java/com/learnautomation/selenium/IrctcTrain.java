package com.learnautomation.selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Test
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
	  public void test1(){
		  
		  Actions act=new Actions(driver);
		  act.moveToElement(driver.findElement(By.xpath("//a[@id='irctc_tourism']"))).perform();
		  driver.findElement(By.xpath("//div[@id='bluemenu']/ul/li[9]/ul/li[2]/a")).click();
		  
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		  
		  Set<String> set=driver.getWindowHandles(); 
			Iterator<String> it=set.iterator(); 
			String parentId=it.next(); 
			String childId=it.next(); 
			
			driver.switchTo().window(childId); 
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
			
			driver.findElement(By.xpath(".//*[@id='mainpannelNewLook']/div/div/ul/li[1]/div/div/span/a")).click();
			
			 Set<String> set1=driver.getWindowHandles();
			Iterator<String>it1=set1.iterator(); 
			String parentID = it1.next(); 
			String childID =it1.next(); 
			String child2=it1.next();
			
			
			driver.switchTo().window(child2);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
			
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='newPack1']/span/h1")).isDisplayed(),true);
			
//          driver.findElement(By.xpath(".//*[@id='newPack1']/span/a")).click();
			
//			String Actualtext = driver.findElement(By.xpath(".//*[@id='newPack1']/span/h1")).getText();
//			
//			Assert.assertEquals("Onam Special Tourist Train Ex Trivandrum(Kochuveli)",Actualtext);
//		  System.out.print("assertion_method Part executed");
	
			
			
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
