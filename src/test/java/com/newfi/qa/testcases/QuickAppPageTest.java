package com.newfi.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newfi.qa.base.TestBase;
import com.newfi.qa.pages.HomePage;
import com.newfi.qa.pages.LoginPage;
import com.newfi.qa.pages.QuickAppPage;
import com.newfi.qa.util.TestUtil;

public class QuickAppPageTest extends TestBase {

	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	QuickAppPage quickAppPage;

	String sheetName = "QuickAppPage";

	public QuickAppPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = new HomePage();
		quickAppPage = new QuickAppPage();
		loginPage.login();
	}

	@SuppressWarnings("static-access")
	@DataProvider
	public Object[][] getQuickAppLoanTestData() throws IOException {
		Object[][] data = testUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 1, dataProvider = "getQuickAppLoanTestData")
	public void createQuickAppLoanTest(String firstName, String lastName, String email, String homePhone, String ssn,
			String loanPurpose, String loanAmount, String amortizationTerm, String mtgAppliedFor, String fico,
			String zip, String streetAddress, String purchasePrice) {
		homePage.clickOnQuickAppOption();
		quickAppPage.createQuickAppLoan(firstName, lastName, email, homePhone, ssn, loanPurpose, loanAmount,
				amortizationTerm, mtgAppliedFor, fico, zip, streetAddress, purchasePrice);

		quickAppPage.clickOnGoToActivePipelineOption();

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
