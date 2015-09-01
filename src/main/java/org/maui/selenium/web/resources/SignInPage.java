package org.maui.selenium.web.resources;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BasePage{

	@FindBy(id = "login-username")
	private WebElement loginField;
	
	@FindBy(id = "login-password")
	private WebElement passwordField;
	
	@FindBy(className = "login-sign-in-btn")
	private WebElement signinButton;
	
	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {		
		return ExpectedConditions.visibilityOf(loginField);
	}

	@Override
	public String getPageUrl() {
		return "/account";
	}
	
	public AccountConfirmationPage signin(String email,String password) {
		this.loginField.clear();
		this.loginField.sendKeys(email);
		this.passwordField.clear();
		this.passwordField.sendKeys(password);
		this.signinButton.click();
		return new AccountConfirmationPage(driver);
	}

}
