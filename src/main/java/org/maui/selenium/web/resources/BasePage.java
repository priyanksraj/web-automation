package org.maui.selenium.web.resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

	/**
	 * BasePage is the super class which would be extended by all other page classes
	 */
	public abstract class BasePage {

	    protected WebDriver driver;
	    private static final long LOAD_TIMEOUT = 20000;
	    private static final long REFRESH_RATE = 2000;
	    protected static final long SLEEP_TIME = 5000;

	    /**
	     * Instantiates a new base page.
	     */
	    public BasePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    /*
	    Wait for page to load
	     */
	    public void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(pageLoadCondition);

	    }

	    public void waitForPageToLoad() {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(getPageLoadCondition());

	    }


	    /**
	     * Provides condition when page can be considered as fully loaded.
	     *
	     * @return
	     */
	    protected abstract ExpectedCondition getPageLoadCondition();

	    /**
	     * Provides page relative URL/
	     *
	     * @return
	     */
	    public abstract String getPageUrl();

	    /**
	     * Provides webdriver
	     *
	     * @return
	     */
	    public WebDriver getDriver() {
	        return this.driver;
	    }


	}
