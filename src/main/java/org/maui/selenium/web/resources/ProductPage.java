package org.maui.selenium.web.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

	@FindBy(className = "product-name")
	private WebElement productName;
	
	@FindBy(id = "WMItemAddToCartBtn")
	private WebElement addToCartButton;
	
	@FindBy(className = "js-price-display")
	private WebElement displayPrice;
	
	
	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(addToCartButton);
	}

	@Override
	public String getPageUrl() {
		return null;
	}
	
	public String getProductName(){
		return productName.getText();
	}

	public void addToCart(){
		addToCartButton.click();
	}
}
