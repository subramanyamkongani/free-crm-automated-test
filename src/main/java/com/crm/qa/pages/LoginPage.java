package com.crm.qa.pages;

import static org.testng.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.ScreenshotHelper;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class LoginPage extends TestBase {
	

	public Logger log = LogManager.getLogger(LoginPage.class);
	public static ScreenshotHelper scrn = new ScreenshotHelper();

	
	//Page Factory Object Repository
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
	WebElement signUpBtn;
	
//	@FindBy(xpath = "//button[@class='navbar-toggle']//following-sibling::a[@class='navbar-brand']")
//	WebElement crmLogo;
	
	@FindBy(css = "#imagetrgt")
	WebElement crmLogo;
	
	//Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public void validateLoginPageTitle(String expectedTitle) {
		String actualTitle =  driver.getTitle();
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle), "Title is not as expected");
	}
	
	public void validateCRMLogo() {
		Assert.assertTrue(crmLogo.isDisplayed(), "CRM Logo is not Displayed");
		log.info("crm logo is displayed");
	}
	
	public HomePage login(String un, String pswd) {
		username.sendKeys(un);
		password.sendKeys(pswd);
		loginBtn.click();
		return new HomePage();
		
	}
	
	public void makeImage(String name) throws IOException, InterruptedException {
		Assert.assertTrue(crmLogo.isDisplayed());
		ScreenshotHelper.makeScreenshot(crmLogo, name);
	}
	
	public void compareImages(String name, String fileName) throws IOException, InterruptedException {
		log.info("Comparing image difference");
		File path = new File(ScreenshotHelper.makeScreenshot(crmLogo, name).toString());
		BufferedImage actualImage = ImageIO.read(path);
		String expectedImagePath = System.getProperty("user.dir") + "/referenceimages/reference/" + fileName + ".png";
		try {
			BufferedImage expectedImage = ImageIO.read(new File(expectedImagePath));
			ImageDiffer imageDiff = new ImageDiffer();
			ImageDiff diff = imageDiff.makeDiff(expectedImage, actualImage);
			System.out.println(diff.hasDiff());
			Assert.assertFalse(diff.hasDiff(), "Images are not same");
			path.delete();
			log.info("compared images doesn't have any difference");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
