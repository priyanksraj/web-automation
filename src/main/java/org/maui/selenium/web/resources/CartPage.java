package org.maui.selenium.web.resources;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

	@FindBy(className = "cart-list-title")
	private WebElement cartTitle;
	
	private String noOfCartItems;
	
	@FindBy(xpath = "//*[@id='CartItemInfo']/span")
	private WebElement cartItemDetails;
	
	@FindBy(xpath = "//*[@id='spa-layout']/div/div/div[1]/div/h3/span")
	private WebElement cartItemCount;
	
	@FindBy(className = "js-pac-proceed-to-checkout")
	private WebElement checkOut;
	
	@FindBy(className = "js-cart-item-remove")
	private WebElement removeItem;
	
	@FindBy(id = "CartUndoDeleteBtn")
	private WebElement undoDeleteBtn;
	
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(cartTitle);
	}

	protected ExpectedCondition getRemoveItemLoadCondition() {
		return ExpectedConditions.visibilityOf(undoDeleteBtn);
	}
	
	@Override
	public String getPageUrl() {
		return "/cart";
	}
	
	public String getCartItemName(){
		return cartItemDetails.getText();
	}
	
	public int getNoOfItemsInCart(){
		System.out.println("Items in Cart "+cartItemCount.getText());
		String cc = cartItemCount.getText();
		String[] arr = cc.split(" ");
		String cart_item_count = arr[0];
		System.out.println("Items in Cart "+cart_item_count);
		int i = 0;
		try{
			i = Integer.parseInt(cart_item_count);
		}catch(NumberFormatException e){
			System.out.println("Cannot convert to integer");
		}
		return i;
	}
	
	public CheckOutPage checkOut(){
		checkOut.click();
		return new CheckOutPage(driver);
	}

	public void removeItemFromCart(){
		removeItem.click();
		waitForPageToLoad(getRemoveItemLoadCondition());
		
	}
}
