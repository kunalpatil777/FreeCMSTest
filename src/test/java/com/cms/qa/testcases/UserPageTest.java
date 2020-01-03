package com.cms.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cms.qa.base.TestBase;
import com.cms.qa.pages.HomePage;
import com.cms.qa.pages.LoginPage;
import com.cms.qa.pages.PostsPage;
import com.cms.qa.pages.UserPage;
import com.cms.qa.util.TestUtil;

public class UserPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	PostsPage postPage;
	UserPage userPage;
	String sheetName = "users";

	public UserPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		TestBase.intialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		postPage = new PostsPage();
		userPage = new UserPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		userPage = homePage.clickOnUserLink();
	}

	@DataProvider
	public Object[][] getCMSTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getCMSTestData")
	public void validateCreateNewUser(String username, String email, String firstname, String lastname) {
		homePage.clickOnNewUserLink();
		// userPage.createNewUser("kunalpatil7", "kunal7@gmail.com",
		// "Kunal","Patil");
		userPage.createNewUser(username, email, firstname, lastname);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
