package com.cms.qa.pages;

import java.util.Map;

import javax.swing.plaf.ActionMapUIResource;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cms.qa.base.TestBase;

//User:opensourcecms
public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(@class,'display-name')]//parent::a[@href='https://s1.demo.opensourcecms.com/wordpress/wp-admin/profile.php'][text()='Howdy, ']")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//*[@id='menu-posts']/a/div[3]")
	WebElement postsLink;

	@FindBy(xpath = "//*[@id='menu-media']/a/div[3]")
	WebElement mediaLink;

	@FindBy(xpath = "//*[@id='menu-pages']/a/div[3]")
	WebElement pagesLink;

	@FindBy(xpath = "//*[@id='menu-users']/a/div[3]")
	WebElement userLink;

	@FindBy(xpath = "//*[@id='menu-users']/ul/li[3]/a")
	WebElement newUserLink;

	// Initializing the Homepage Objects
	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public String verifyHomePageTitle() {
		return driver.getTitle();

	}

	public boolean verifyCorrectUserName() {
		userNameLabel.click();
		return userNameLabel.isDisplayed();

	}

	public PostsPage clickOnPostsLink() {
		postsLink.click();
		return new PostsPage();
	}

	public MediaPage clickOnMediaLink() {
		mediaLink.click();
		return new MediaPage();
	}

	public PagesPage clickOnPagesLink() {
		pagesLink.click();
		return new PagesPage();
	}

	public UserPage clickOnUserLink() {
		userLink.click();
		return new UserPage();
	}

	public void clickOnNewUserLink() {
		Actions action = new Actions(driver);
		action.moveToElement(userLink).build().perform();
		newUserLink.click();
	}

}
