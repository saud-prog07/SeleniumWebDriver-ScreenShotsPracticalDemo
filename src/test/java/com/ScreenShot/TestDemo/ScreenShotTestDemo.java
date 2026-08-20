package com.coforge.screenshot.testdemo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShotTestDemo {

	@Test
	public void Browser() throws Exception {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com");
		driver.manage().window().maximize();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/PracticeTestAutomationHomePage.png"));
		System.out.println("Caputred ScreenShot");
		driver.quit();
	}

}