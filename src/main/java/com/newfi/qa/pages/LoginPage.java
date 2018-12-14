package com.newfi.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newfi.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR

	@FindBy(id = "userId")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//input[@name='submit' and @value='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//img[@class='loginLogo']")
	WebElement loginLogo;

	// links in Login Page

	@FindBy(xpath = "//a[@href='https://www.newfi.com/privacy-policy/']")
	WebElement privacyPolicyLink;

	@FindBy(xpath = "//ul[@id='menu-main-navigation']//a[@href='https://www.newfi.com/loancenter/']")
	WebElement privacyPolicyLoginBtn;

	// Initialization of Objects

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLoginPageLogo() {
		return loginLogo.isDisplayed();

	}

	public HomePage login() {
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		return new HomePage();

	}

	public void switchingBetweenWindows() throws InterruptedException {
		String parent_window = driver.getWindowHandle();
		System.out.println("Parent window ID -->>: " + parent_window);
		privacyPolicyLink.click();
		Thread.sleep(3000);

		for (String child_window : driver.getWindowHandles()) {

			driver.switchTo().window(child_window);
			System.out.println("Child window ID -->>: " + child_window);
			Thread.sleep(5000);
			privacyPolicyLoginBtn.click();

		}
		driver.switchTo().window(parent_window);
		login();

	}

}
