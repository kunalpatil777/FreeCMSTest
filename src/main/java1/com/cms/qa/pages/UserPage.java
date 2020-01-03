package com.cms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cms.qa.base.TestBase;

public class UserPage extends TestBase {

	@FindBy(id = "user_login")
	WebElement userName;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(xpath = "//input[@type='submit' and @value='Add New User']")
	WebElement addNewUserBtn;

	public UserPage() {
		PageFactory.initElements(driver, this);

	}

	public void createNewUser(String uname, String mail, String ftName, String ltName) {
		userName.sendKeys(uname);
		email.sendKeys(mail);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		addNewUserBtn.click();
	}
}
