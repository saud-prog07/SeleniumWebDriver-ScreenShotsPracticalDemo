package com.coforge.screenshot.testdemo;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShotOverlapDemo {
	WebDriver driver;
	
	@BeforeTest
	public void Browser() throws Exception {
		 driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com");
		driver.manage().window().maximize();
	}
	
	@Test
	public void case6() throws InterruptedException, IOException {
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println("Title : " + title);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Application_" + getCurrentDateTime() + ".png"));
		System.out.println("Caputred ScreenShot");
	}
	
	public String getCurrentDateTime() {
		DateFormat customFormate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate = new Date();
		return customFormate.format(currentdate);
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}