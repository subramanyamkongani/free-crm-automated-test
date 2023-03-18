package com.crm.qa.testcases;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class ElementScreenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/com/crm/qa/drivrers/chromedriver");
		WebDriver driver = new ChromeDriver(option);
	  
	       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	       Thread.sleep(2000);
//	       driver.manage().window().maximize();
	  
	       //By webElement = (By) driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[1]/img"));
	       File scrnshot = driver.findElement(By.xpath("html/body/div/div[1]/div/div[1]/div/div[1]/img")).getScreenshotAs(OutputType.FILE);
	       FileUtils.copyFile(scrnshot, new File(System.getProperty("user.dir") +"/finalresult/"+System.currentTimeMillis()+"_"+"googleimage.png"));
	       
//	       File base64 = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[1]/img")).getScreenshotAs(OutputType.FILE);
//	       FileUtils.copyDirectory(base64, new File(System.getProperty("user.dir") +"/finalresult/"+System.currentTimeMillis()+"googleimage.png"));
	       
//	       Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, webElement);
//	       ImageIO.write(screenshot.getImage(),"png",new File(System.getProperty("user.dir") +"/finalresult/googleimage.png"));
//	  
	       Thread.sleep(2000);
	       driver.quit();

	}

}
