package com.cms.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cms.qa.base.TestBase;
import com.cms.qa.pages.HomePage;
import com.cms.qa.pages.LoginPage;
import com.cms.qa.pages.PostsPage;
import com.cms.qa.util.TestUtil;

public class PostsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	PostsPage postPage;
	
	public PostsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		TestBase.intialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		postPage = new PostsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		postPage = homePage.clickOnPostsLink();
	}

	@Test(priority = 1)
	public void verifyPostsPageLabel() {
		Assert.assertTrue(postPage.verifyPostsLabel(), "Posts Label is Missing on the page");
		;
	}

	@Test(priority = 2)
	public void selectSinglePostsTest() {
		postPage.selectPostsByName();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
