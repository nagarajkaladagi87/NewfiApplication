package com.newfi.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newfi.qa.base.TestBase;
import com.newfi.qa.pages.HomePage;
import com.newfi.qa.pages.LoginPage;

public class LeadsTabTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LeadsTabTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		

	}

	@Test
	public void searchLeadsTest() throws InterruptedException {

		homePage.searchFunction();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
