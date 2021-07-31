package com.ishita.swaglabs.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ishita.swaglabs.library.PropertyReader;
import com.ishita.swaglabs.pages.CheckoutPage;
import com.ishita.swaglabs.pages.HomePage;
import com.ishita.swaglabs.pages.LoginPage;

public class BaseMethods {

	public WebDriver driver;
	public CheckoutPage checkout;
	public HomePage home;
	public LoginPage login;
	public WebDriverWait wait;
	
	@BeforeClass
	public void startBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(PropertyReader.configReader("url"));
		driver.manage().window().maximize();
		
		login = PageFactory.initElements(driver, LoginPage.class);
		home = PageFactory.initElements(driver, HomePage.class);
		checkout = PageFactory.initElements(driver, CheckoutPage.class);
		
		wait = new WebDriverWait(driver, 10);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
}
