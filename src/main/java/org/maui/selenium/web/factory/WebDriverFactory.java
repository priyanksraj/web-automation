package org.maui.selenium.web.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverFactory {

	public enum DriverType {
		CHROME, FIREFOX, HTML_UNIT_DRIVER, IOS
	}

	/**
	 * The method prepareWebDriver initialize the WebDriver Object depending on the
	 * browser
	 *
	 * @return the web driver
	 * @throws FileNotFoundException
	 */
	public static WebDriver prepareWebDriver(String browser)  {

		DriverType browserType = DriverType.valueOf(browser.toUpperCase());
		switch (browserType) {
		case FIREFOX:
			return new FirefoxDriver();
		case CHROME:
			return new ChromeDriver();
		case HTML_UNIT_DRIVER:
			return new HtmlUnitDriver();
		default:
			return new FirefoxDriver();
		}
	}

	public static WebDriver prepareWebDriver()  {

		return new ChromeDriver();
	}


}
