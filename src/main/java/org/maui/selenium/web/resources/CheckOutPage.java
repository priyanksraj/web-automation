package org.maui.selenium.web.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends BasePage{

	@FindBy(className = "checkout-heading")
	private WebElement checkoutHeading;
	
	@FindBy(id = "COAC1ShpOptContBtn")
	private WebElement shippingOptContBtn;

	@FindBy(id = "COAC2ShpAddrContBtn")
	private WebElement shippingAddrContBtn;

	@FindBy(className = "js-review-order")
	private WebElement reviewOrderBtn;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(checkoutHeading);
	}
	
	protected ExpectedCondition getshippingOptCondition() {
		return ExpectedConditions.elementToBeClickable(shippingOptContBtn);
	}
	
	protected ExpectedCondition getShippingAddrCondition() {
		return ExpectedConditions.elementToBeClickable(shippingAddrContBtn);
	}
	
	protected ExpectedCondition getreviewOrderCondition() {
		return ExpectedConditions.elementToBeClickable(reviewOrderBtn);
	}

	@Override
	public String getPageUrl() {
		return "/checkout";
	}
	
	public String goToPaymentPage(){
		waitForPageToLoad(getshippingOptCondition());
		shippingOptContBtn.click();
		waitForPageToLoad(getShippingAddrCondition());
		shippingAddrContBtn.click();
		waitForPageToLoad(getreviewOrderCondition());
		System.out.println("In goToPaymentPage function");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		return driver.getCurrentUrl();
	}

}
