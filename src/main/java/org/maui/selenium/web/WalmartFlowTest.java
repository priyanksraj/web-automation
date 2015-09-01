
package org.maui.selenium.web;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import org.maui.selenium.web.factory.WebDriverFactory;
import org.maui.selenium.web.resources.AccountConfirmationPage;
import org.maui.selenium.web.resources.CartPage;
import org.maui.selenium.web.resources.CheckOutPage;
import org.maui.selenium.web.resources.HomePage;
import org.maui.selenium.web.resources.ProductPage;
import org.maui.selenium.web.resources.SearchResultPage;
import org.maui.selenium.web.resources.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WalmartFlowTest extends BaseTest {

	@Test
	public void testFlow() {

		String productName = null;
		//Go to the home page
		String baseURL = "http://mobile.walmart.com/";
		HomePage homepage = new HomePage(driver).openPage(baseURL);
		
		//Search for Iphone and select the first product in the list
		SearchResultPage result = homepage.searchItems("iphone");
		result.waitForPageToLoad();
		ProductPage product = result.selectProduct(0);
		product.waitForPageToLoad();		
		
		//Add the product to the cart
		product.addToCart();
		productName = product.getProductName();
		
		//Goto Signin Page
		SignInPage signin_page = homepage.gotoSignInPage();
		signin_page.waitForPageToLoad();				
		
		//Signin as the test user
		AccountConfirmationPage confirmation = signin_page.signin("priyanks.raj@gmail.com", "123456");
		confirmation.waitForPageToLoad();
		
		//Go to shopping Cart and verify the shopping Cart details
		CartPage cart_page = homepage.gotoCartPage();
		cart_page.waitForPageToLoad();	
		//Assert.assertEquals(cart_page.getNoOfItemsInCart(),1);
		//Assert.assertEquals(cart_page.getCartItemName(), productName);

		//Checkout and validate that your in payment page
		CheckOutPage checkout_page = cart_page.checkOut();
		checkout_page.waitForPageToLoad();
		String url = checkout_page.goToPaymentPage();
		Assert.assertTrue(url.contains("checkout/payment"));
		
		//Go to cart and remve the item
		cart_page = homepage.gotoCartPage();
		cart_page.waitForPageToLoad();	
		cart_page.removeItemFromCart();
		cart_page.waitForPageToLoad();
		//Assert.assertEquals(cart_page.getNoOfItemsInCart(), 0);

		//signout
		homepage.SignOut();

	}

}
