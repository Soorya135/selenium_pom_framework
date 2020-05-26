package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	Properties prop;

	@BeforeTest
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void verifyHomePageTitle()
	{
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page Title is" + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE,"Home Page Title is not Matched");
	}
	
	@Test(priority=1)
	public void verifyHomePageHeader()
	{
		String header = homePage.getHomePageHeaderText();
		System.out.println("Home Page Header is" + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER,"Home Page Header is not present");
	}
	
	@Test(priority=2)
	public void verifyLoggedInUserTest() {
		String loggedInUser = homePage.getLoggedInUser();
		System.out.println("Logged in user is :"+loggedInUser);
		Assert.assertEquals(loggedInUser,prop.getProperty("accountname"),"Logged in User is not matched...");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	}


