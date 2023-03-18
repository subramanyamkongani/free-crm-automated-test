package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageCRMLogoVerificationTest extends TestBase {

	@Test
	public void loginPageLogoValidationTest() throws IOException, InterruptedException {
		LoginPage login = new LoginPage();
		login.validateCRMLogo();
		login.compareImages("crmLogo", "LoginPageLogoValidationTest_1679144833262");
	}
}
