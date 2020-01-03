package com.cms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cms.qa.base.TestBase;

public class LoginPage extends TestBase {
	// Page Factory- OR:
	@FindBy(name = "log")
	WebElement username;
	@FindBy(name = "pwd")
	WebElement password;
	@FindBy(name = "wp-submit")
	WebElement loginBtn;
	@FindBy(xpath = "//a[text()='Powered by WordPress']")
	WebElement cmsLogo;

	@FindBy(xpath = "//*[@id='backtoblog']")
	WebElement backToOpenSource;

	// Initializing a Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();

	}

	public boolean validateCMSImage() {
		return cmsLogo.isDisplayed();

	}

	public SourcePage clickOnBackToOpenSourceLink() {
		backToOpenSource.click();
		return new SourcePage();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
}
