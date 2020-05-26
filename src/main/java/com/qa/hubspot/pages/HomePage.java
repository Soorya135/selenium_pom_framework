package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {

	private WebDriver driver;

	By header = By.cssSelector("h1.private-page__title");
	By accountname = By.cssSelector("span.account-name ");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getHomePageHeaderText() {
		if (driver.findElement(header).isDisplayed()) {
			return driver.findElement(header).getText();
		} else {
			return null;
		}
	}
	
	public String getLoggedInUser() {
		if(driver.findElement(accountname).isDisplayed()){
			return driver.findElement(accountname).getText();
		}
		else
		{
		return null;
		}
			
		}
	}


