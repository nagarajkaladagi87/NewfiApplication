package com.newfi.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.newfi.qa.base.TestBase;

public class QuickAppPage extends TestBase {

	// Page Factory - OR

	@FindBy(xpath = "//h1[contains(text(),'Borrower Information ')]")
	WebElement borrowerInfoHeader;

	@FindBy(xpath = "//input[@id='name' and @ng-model='formData.firstName' ]")
	WebElement borrowerFirstName;

	@FindBy(xpath = "//input[@id='name' and @ng-model='formData.lastName' ]")
	WebElement borrowerLastName;

	@FindBy(xpath = "//input[@id='email' and @ng-model='formData.email' ]")
	WebElement borrowerEmail;

	@FindBy(xpath = "//input[@id='phone' and @ng-model='formData.phoneNumber' ]")
	WebElement borrowerPhoneNumber;

	@FindBy(xpath = "//input[@id='ssn' and @ng-model='formData.ssn' ]")
	WebElement borrowerSSN;

	/*
	 * @FindBy(xpath = "//select[@id='loanPurpose']") WebElement loanPurpose;
	 * 
	 * @FindBy(xpath = "//select[@id='term']") WebElement term;
	 * 
	 * @FindBy(xpath = "//select[@id='mortgage']") WebElement mortgageApplied;
	 */

	@FindBy(xpath = "//input[@id='loanAmount' and @ng-model='formData.loanAmount' ]")
	WebElement loanAmount;

	@FindBy(xpath = "//input[@id='FICO' and @ng-model='formData.creditScore' ]")
	WebElement borrwerCreditScore;

	@FindBy(xpath = "//input[@id='zip' and @ng-model='formData.zipcode' ]")
	WebElement subjectPropZip;

	@FindBy(xpath = "//input[@id='Address' and @ng-model='formData.address']")
	WebElement propStreetAddress;

	@FindBy(xpath = "//input[@id='purchasePrice' and @ng-model='formData.estimatedValue']")
	WebElement purchasePrice;

	@FindBy(xpath = "//div[@ng-hide='isShowCoBorrower']//descendant::button[@id='saveLoanData']")
	WebElement saveLoanDataBtn;

	@FindBy(xpath = "//button[contains(text(),'Complete Loan Profile')]")
	WebElement completeLoanProfileBtn;

	@FindBy(xpath = "//button[contains(text(),'Go to Active Pipeline')]")
	WebElement goToActivePipelineBtn;

	// Initializing Objects

	public QuickAppPage() {

		PageFactory.initElements(driver, this);
	}

	// Actions

	// Verify Borrower info header text in Quick App PAge

	public boolean validateBorrowerInfoTextInQuickAppPage() {
		return borrowerInfoHeader.isDisplayed();

	}

	// Create a new loan using QuickApp option

	public void createQuickAppLoan(String fName, String lName, String emailId, String homePhone, String ssn,
			String loanPurpose, String lnAmount, String amortization, String mtgApplied, String fico, String zip,
			String strtAddress, String estHomeValue) {

		borrowerFirstName.sendKeys(fName);
		borrowerLastName.sendKeys(lName);
		borrowerEmail.sendKeys(emailId);
		borrowerPhoneNumber.sendKeys(homePhone);
		borrowerSSN.sendKeys(ssn);
		Select selLoanPurpose = new Select(driver.findElement(By.xpath("//select[@id='loanPurpose']")));
		selLoanPurpose.selectByValue(loanPurpose);

		loanAmount.sendKeys(lnAmount);

		Select selAmortizationTerm = new Select(driver.findElement(By.xpath("//select[@id='term']")));
		selAmortizationTerm.selectByVisibleText(amortization);

		Select selMtgApplied = new Select(driver.findElement(By.xpath("//select[@id='mortgage']")));
		selMtgApplied.selectByValue(mtgApplied);

		borrwerCreditScore.sendKeys(fico);
		subjectPropZip.sendKeys(zip);
		subjectPropZip.sendKeys(Keys.TAB);
		propStreetAddress.sendKeys(strtAddress);
		purchasePrice.sendKeys(estHomeValue);
		saveLoanDataBtn.click();

	}

	// Click on Go to Active Pipeline option in QuickApp modal - dialog box

	public void clickOnGoToActivePipelineOption() {
		// Wait for pop up to be visible
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(goToActivePipelineBtn));

		// Click on Go to Active Pipeline option
		goToActivePipelineBtn.click();

	}

	public void clickOnCompleteLoanProfileOption() {
		// Wait for pop up to be visible
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(completeLoanProfileBtn));

		// Click on Complete Loan Profile option
		completeLoanProfileBtn.click();

	}

}
