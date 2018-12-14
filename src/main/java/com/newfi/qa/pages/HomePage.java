package com.newfi.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newfi.qa.base.TestBase;

public class HomePage extends TestBase {

	// Page Factory - OR

	@FindBy(xpath = "//a[@href='#/quickQuote']")
	WebElement quickQuoteOption;

	@FindBy(xpath = "//a[@href='#/quickApp']")
	public WebElement quickAppOption;

	@FindBy(xpath = "//ul/li[contains(text(),'leads')]")
	WebElement leadsTab;

	@FindBy(xpath = "//input[@ng-model='formData.searchText']")
	WebElement searchBox;

	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchBtn;

	@FindBy(xpath = "//button[text()='Reset']")
	WebElement resetBtn;

	// Create Leads popup elements

	@FindBy(xpath = "//header-directive/nav/div[2]/ul[2]//a[@href='']")
	WebElement createLeadOption;

	@FindBy(xpath = "//input[@id='crmFirstName']")
	public WebElement crmFirstName;

	@FindBy(xpath = "//input[@id='crmLastName']")
	public WebElement crmLastName;

	@FindBy(xpath = "//input[@id='crmEmailId']")
	public WebElement crmEmailID;

	@FindBy(xpath = "//input[@id='crmPhoneNumber']")
	public WebElement crmPhoneNumber;

	@FindBy(xpath = "//div[@class='modal-content']//button[@class='btn btn-default searchBtn']")
	WebElement createBtn;

	// Initializing Objects

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	// Actions

	// Verify Home page title

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	// Click on Quickapp option in HomePage

	public QuickAppPage clickOnQuickAppOption() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", quickAppOption);
		return new QuickAppPage();

	}

	// Enter text in Search box and click on Search Button

	public void searchFunction() throws InterruptedException {

		searchBox.sendKeys("SandeepTest");
		searchBtn.click();
		Thread.sleep(3000);

	}

	// Create Direct lead function in TOOLBOX

	public void createDirectLeadInToolBox(String fName, String lName, String emailID, String phoneNum) {

		createLeadOption.click();
		crmFirstName.sendKeys(fName);
		crmLastName.sendKeys(lName);
		crmEmailID.sendKeys(emailID);
		crmPhoneNumber.sendKeys(phoneNum);
		createBtn.click();

	}

}
