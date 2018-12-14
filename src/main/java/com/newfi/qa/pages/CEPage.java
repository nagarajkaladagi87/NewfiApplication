package com.newfi.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.newfi.qa.base.TestBase;

public class CEPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Home Purchase')]")
	WebElement homePurchaseOption;

	@FindBy(id = "zipcode")
	WebElement zipCode;

	@FindBy(id = "purchaseprice")
	WebElement purchasePrice;

	@FindBy(xpath = "//input[@value='View Loan Options']")
	WebElement viewLoanOptionsBtn;

	// Initialization of Objects

	public CEPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public void clickOnPurchaseHomeOption() {

		homePurchaseOption.click();

	}

	public void EnterInputData(String zip, String residencyTypeValue, String propertyUse, String loanAmount)
			throws InterruptedException {

		zipCode.sendKeys(zip);
		zipCode.sendKeys(Keys.TAB);
		Select selResidencyType = new Select(
				driver.findElement(By.xpath("//select[@id='residencetype' and @name='residencetype']")));
		selResidencyType.selectByIndex(1);
		Thread.sleep(3000);

		Select selPropUse = new Select(driver.findElement(By.id("propertyuse")));
		selPropUse.selectByIndex(1);
		purchasePrice.sendKeys(loanAmount);

	}

	public void clickOnViewLoanOptionBtn() {

		viewLoanOptionsBtn.click();

	}

}
