package com.learnautomation.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	FirefoxDriver wd;
	@BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void VeryfiCusttest () {
        wd.get("http://amarendra-pc/login.jsp");
        wd.findElement(By.name("username")).click();
        wd.findElement(By.name("username")).clear();
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("pwd")).click();
        wd.findElement(By.name("pwd")).clear();
        wd.findElement(By.name("pwd")).sendKeys("manager");
        wd.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        wd.findElement(By.xpath("//div[@id='container']//a[.='Projects & Customers']")).click();
        wd.findElement(By.linkText("Amar PvtLtd")).click();
        if (!wd.findElement(By.xpath("//div[@id='container']/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/span")).getText().contains("Amar PvtLtd")) {
            System.out.println("verifyTextPresent failed");
        }
        if (!wd.findElement(By.xpath("//div[@id='container']/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/span")).getText().contains("Active")) {
            System.out.println("verifyTextPresent failed");
        }
        wd.findElement(By.linkText("Users")).click();
        wd.findElement(By.linkText("Das, Kamini (kamini)")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("Kamini Das (kamini)")) {
            System.out.println("verifyTextPresent failed");
        }
        if (!wd.findElement(By.tagName("html")).getText().contains("Enabled")) {
            System.out.println("verifyTextPresent failed");
        }
        wd.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        wd.findElement(By.cssSelector("img.logoutImg")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }



}
