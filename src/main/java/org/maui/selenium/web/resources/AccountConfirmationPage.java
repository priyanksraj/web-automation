package org.maui.selenium.web.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AccountConfirmationPage extends BasePage {


	@FindBy(className = "recent-orders-heading")
	private WebElement pageHeading;

	public AccountConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.textToBePresentInElement(pageHeading, "Welcome to your Walmart account!");
	}

	@Override
	public String getPageUrl() {
		return null;
	}

}
