package org.maui.selenium.web.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage{

	@FindBy(name = "query")
	private WebElement searchBar;
	
	@FindBy(className = "header-account-signin")
	private WebElement signInLink;
	
	@FindBy(className = "wmicon-cart")
	private WebElement cartLink;
	
	@FindBy(className = "dropdown-link")
	private WebElement dropDown;
	
	@FindBy(className = "js-sign-out")
	private WebElement signOut;

	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(searchBar);
	}
	
	protected ExpectedCondition getSignOutCondition() {
		return ExpectedConditions.visibilityOf(signOut);
	}

	@Override
	public String getPageUrl() {
		return "";
	}

	public SignInPage gotoSignInPage() {
		this.signInLink.click();
		return new SignInPage(driver);
	}
	
	public CartPage gotoCartPage() {
		this.cartLink.click();
		return new CartPage(driver);
	}
	
	public SearchResultPage searchItems(String query){
		searchBar.clear();
		searchBar.sendKeys(query);
		searchBar.submit();
		return new SearchResultPage(driver);
	}

	public void SignOut(){
        Actions builder = new Actions(driver); 
        Actions hover = builder.moveToElement(dropDown);
        hover.build().perform();
        
        waitForPageToLoad(getSignOutCondition());
        signOut.click();

	}
	public HomePage openPage(String baseURL) {
		HomePage page = PageFactory.initElements(getDriver(), HomePage.class);
        getDriver().get(baseURL + getPageUrl());
        getDriver().manage().window().maximize();
        ExpectedCondition pageLoadCondition = ((BasePage) page)
                .getPageLoadCondition();
        waitForPageToLoad(pageLoadCondition);
        return page;
	}
}
