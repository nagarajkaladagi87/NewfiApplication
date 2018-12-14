package com.newfi.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newfi.qa.base.TestBase;
import com.newfi.qa.pages.CEPage;
import com.newfi.qa.util.TestUtil;

public class MortgageRatesTodayTest extends TestBase {

	TestUtil testUtil;
	CEPage cePage;
	String sheetName = "CEPage";

	public MortgageRatesTodayTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		cePage = new CEPage();

	}

	@SuppressWarnings("static-access")
	@DataProvider
	public Object[][] getCETestData() throws IOException {
		Object[][] data = testUtil.getTestData(sheetName);
		return data;

	}

	@Test(dataProvider = "getCETestData")
	public void hitShowRatesTest(String zipCode, String resType, String pType, String loanAmnt)
			throws InterruptedException {

		cePage.clickOnPurchaseHomeOption();
		cePage.EnterInputData(zipCode, resType, pType, loanAmnt);
		cePage.clickOnViewLoanOptionBtn();
		Thread.sleep(3000);

	}

	@AfterMethod
	public void tearDown() {

	driver.quit();
	}

}
