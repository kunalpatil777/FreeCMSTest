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
import com.cms.qa.pages.SourcePage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	SourcePage soucePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		TestBase.intialization();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Log In ‹ opensourcecms — WordPress");
	}

	@Test(priority = 2)
	public void cmsLogoImageTest() {
		boolean flag = loginPage.validateCMSImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 4)
	public void backToSoucePage() {
		soucePage = loginPage.clickOnBackToOpenSourceLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
