package com.newfi.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newfi.qa.base.TestBase;

public class LeadsPage extends TestBase {

	// Page Factory - OR

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

	public LeadsPage() {

		PageFactory.initElements(driver, this);
	}

}
