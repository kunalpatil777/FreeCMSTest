package com.cms.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cms.qa.base.TestBase;

public class PostsPage extends TestBase {
	@FindBy(xpath="//*[@class='wp-heading-inline']")
	WebElement postsLabel;
	

	public PostsPage(){
		PageFactory.initElements(driver, this);
	}
	public boolean verifyPostsLabel(){
		 return postsLabel.isDisplayed();
	}
	public void selectPostsByName(){
		 driver.findElement(By.xpath("//input[@id='cb-select-1']")).click();
	}
	
}
