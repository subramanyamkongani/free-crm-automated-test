package com.crm.qa.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class ScreenshotHelper extends TestBase {
	

	public static void takeScreenshotAtEndOfTest(ITestResult result) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/finalresult/screenshots/" + result.getMethod().getMethodName() + "_" + System.currentTimeMillis() + ".png"));
	}
	
	public static File makeScreenshot(WebElement element,  String name) throws IOException, InterruptedException {
//		Screenshot screenshot = new AShot().takeScreenshot(driver, element);
		String currentDir = System.getProperty("user.dir");
		File destination = new File(currentDir + "/referenceimages/target/" + name + "_" + System.currentTimeMillis() + ".png");
		//ImageIO.write(screenshot.getImage(), "PNG", new File(System.getProperty("user.dir") + "/screenshots/reference/" + name + ".png"));
//		Screenshot screenshot = new AShot().takeScreenshot(driver, element);
//	       ImageIO.write(screenshot.getImage(),"PNG",new File(destination.toString()));
		File scrnshot = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, destination);
	  
		Thread.sleep(3000);
		return destination;
		
	}
}
