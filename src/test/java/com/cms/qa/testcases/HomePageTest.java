package com.cms.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cms.qa.base.TestBase;
import com.cms.qa.pages.HomePage;
import com.cms.qa.pages.LoginPage;
import com.cms.qa.pages.PostsPage;
import com.cms.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	PostsPage postPages;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		TestBase.intialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		postPages= new PostsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Dashboard ‹ opensourcecms — WordPress", "Homepage title not matched");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
     Assert.assertTrue(homePage.verifyCorrectUserName());

	}
	@Test(priority = 3)
	public void verifyPostslink(){
		postPages=homePage.clickOnPostsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
