package com.newfi.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newfi.qa.base.TestBase;
import com.newfi.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("***Starting Browser and URL***");

		initialization();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void validateLoginPageTitleTest() {
		log.info("Starting Test Execution");
		log.info("validateNewfiLoginTest");
		Assert.assertEquals(loginPage.validateLoginPageTitle(), "Newfi");
		log.info("Ending Test Execution");
	}

	@Test
	public void verifymultipleWindowsHandleTest() throws InterruptedException {
		loginPage.switchingBetweenWindows();

	}

	@Test(priority = 2)
	public void validateNewfiLoginTest() {
		log.info("Starting Test Execution");
		log.info("validateNewfiLoginTest");
		loginPage.login();

		log.info("Ending Test Execution");
	}

	@AfterMethod
	public void tearDown() {
		log.info("Closing Browser");
		driver.quit();

	}

}
