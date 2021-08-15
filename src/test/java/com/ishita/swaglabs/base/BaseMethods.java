package com.ishita.swaglabs.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.ishita.swaglabs.library.PropertyReader;
import com.ishita.swaglabs.pages.CheckoutPage;
import com.ishita.swaglabs.pages.HomePage;
import com.ishita.swaglabs.pages.LoginPage;

public class BaseMethods {

	private static WebDriver driver;
	private static CheckoutPage checkout;
	private static HomePage home;
	private static LoginPage login;
	private static WebDriverWait wait;
	
	@BeforeTest
	public void startBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(PropertyReader.configReader("url"));
		driver.manage().window().maximize();
		
		setLogin(PageFactory.initElements(driver, LoginPage.class));
		setHome(PageFactory.initElements(driver, HomePage.class));
		setCheckout(PageFactory.initElements(driver, CheckoutPage.class));
		
		setWait(new WebDriverWait(driver, 10));
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		BaseMethods.driver = driver;
	}

	public CheckoutPage getCheckout() {
		return checkout;
	}

	public void setCheckout(CheckoutPage checkout) {
		BaseMethods.checkout = checkout;
	}

	public HomePage getHome() {
		return home;
	}

	public void setHome(HomePage home) {
		BaseMethods.home = home;
	}

	public LoginPage getLogin() {
		return login;
	}

	public void setLogin(LoginPage login) {
		BaseMethods.login = login;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		BaseMethods.wait = wait;
	}
	
}
