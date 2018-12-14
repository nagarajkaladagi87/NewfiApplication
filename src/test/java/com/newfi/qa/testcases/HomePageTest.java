package com.newfi.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newfi.qa.base.TestBase;
import com.newfi.qa.pages.HomePage;
import com.newfi.qa.pages.LoginPage;
import com.newfi.qa.pages.QuickAppPage;
import com.newfi.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	Logger log = Logger.getLogger(HomePageTest.class);
	QuickAppPage quickAppPage;

	String sheetName = "CreateDirectLeadPopup";

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("Starting Browser and URL");
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = new HomePage();
		quickAppPage = new QuickAppPage();

	}

	@Test(priority = 2)
	public void validateHomePageTitleTest() {

		log.info("Starting Test Execution - validateHomePageTitleTest");
		loginPage.login();
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Newfi", "Home page title is not matched");
		log.info("Ending Test Execution");
	}

	@Test(priority = 3)
	public void validateClickOnQuickAppOptionTest() throws InterruptedException {
		log.info("Starting Test Execution - validateClickOnQuickAppOptionTest");
		loginPage.login();
		Thread.sleep(3000);
		homePage.clickOnQuickAppOption();
		boolean flag = quickAppPage.validateBorrowerInfoTextInQuickAppPage();
		Assert.assertTrue(flag);
		log.info("Ending Test Execution");
	}

	/*
	 * @Test(priority = 3) public void clickOnQuickAppTest() {
	 * 
	 * // Starting - clickOnQuickAppTest
	 * 
	 * loginPage.login(); homePage.clickOnQuickAppOption();
	 * Assert.assertTrue(quickAppPage.validateBorrowerInfoTextInQuickAppPage());
	 * 
	 * // Ending - clickOnQuickAppTest
	 * 
	 * }
	 */

	@SuppressWarnings("static-access")
	@DataProvider
	public Object[][] getCreateDirectLeadTestData() throws IOException {
		Object[][] data = testUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 0, dataProvider = "getCreateDirectLeadTestData")

	public void ValidateCreateDirectLeadInToolBox(String fName, String lName, String emailID, String phoneNum)
			throws InterruptedException {

		log.info("Starting Test Execution - validateHomePageTitleTest");
		loginPage.login();
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Newfi", "Home page title is not matched");
		Thread.sleep(5000);
		homePage.createDirectLeadInToolBox(fName, lName, emailID, phoneNum);

	}

	@AfterMethod
	public void tearDown() {

		log.info("Closing the browser");
		driver.quit();
	}

}
