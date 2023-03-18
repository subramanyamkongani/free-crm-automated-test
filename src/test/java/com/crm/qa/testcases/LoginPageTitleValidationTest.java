package com.crm.qa.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.Constants;

public class LoginPageTitleValidationTest extends TestBase {

	@Test
	public void loginPageTitleVerificationTest() throws IOException {
		LoginPage loginPage = new LoginPage();
		String expectedTitle = Constants.WEBSITE_TITLE;
		loginPage.validateLoginPageTitle(expectedTitle);
	}
}
