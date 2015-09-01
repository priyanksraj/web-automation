package org.maui.selenium.web.resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage{

	@FindBy(xpath = "//div[contains(@class,'js-tile js-tile-landscape tile-landscape')]")
	private List<WebElement> products;

	@FindBy(className = "result-summary-container")
	private WebElement resultSummary;
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(resultSummary);

	}

	@Override
	public String getPageUrl() {
		return "/search";
	}

	public String productName(int i){
		WebElement first_product = products.get(i);                
		WebElement title = first_product.findElement(By.className("js-product-title"));        
		return title.getText();
	}

	public ProductPage selectProduct(int i){
		WebElement first_product = products.get(i);                
		WebElement title = first_product.findElement(By.className("js-product-title"));        
		String product_name = title.getText();
		title.click();
		ProductPage product_page = new ProductPage(driver);        
		return product_page;
	}


}
