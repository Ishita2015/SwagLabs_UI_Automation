package com.ishita.swaglabs.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ishita.swaglabs.base.BaseMethods;
import com.ishita.swaglabs.library.PropertyReader;

public class TC001_MainTestCase extends BaseMethods {
	
	private static final String TOTAL_PRICE = "//div[@class='summary_total_label']";
	private static final String CHEKOUT_TEXT = "//span[@class='title']";
	private static final String ITEM_LIST = "//div[@class='inventory_container']/div/div/div[2]/div[2]/div";
	private static final String BUTTON_ADD_TO_CART = "//button[contains(text(), 'Add to cart')]";

	
	@Test (priority=1)
	public void loginFunction() throws IOException {
		login.enterUsername();
		login.enterPassword();
		login.clickLoginButton();
	}
	
	@Test (priority=2)
	public void goToAboutClickBackAndValidate() throws InterruptedException, IOException {
		home.openMenuAndSelectAbout();
		Assert.assertEquals(driver.getCurrentUrl(), PropertyReader.configReader("about_url"));
		
		driver.navigate().back();
		wait.until(ExpectedConditions.urlMatches(driver.getCurrentUrl()));
		Assert.assertEquals(driver.getCurrentUrl(), PropertyReader.configReader("productspage_url"));
	}
	
	@Test (priority=3)
	public void selectItemWithHighestPrice() throws InterruptedException {
		ArrayList <Float> pricelist = new ArrayList<Float>(); 
		List <WebElement> itemLinks = driver.findElements(By.xpath(BUTTON_ADD_TO_CART));
		List <WebElement> items = driver.findElements(By.xpath(ITEM_LIST));
	 
		for(WebElement eachItem: items) {
			float price = Float.parseFloat(eachItem.getText().replace("$", ""));
			pricelist.add(price);
		}
		pricelist.sort(null);
		int size = pricelist.size();

		for(int i=0; i<items.size(); i++) {
			addItemWithHighestPriceToCart(pricelist, itemLinks, items, size, i);
		} 
	}

	private void addItemWithHighestPriceToCart(ArrayList<Float> pricelist, List<WebElement> itemLinks,
			List<WebElement> items, int size, int i) {
		float price = Float.parseFloat(items.get(i).getText().replace("$", ""));
		if (price == pricelist.get(size-1)) {
			itemLinks.get(i).click();
		}
	}
 
	@Test (priority=4)
	public void clickCartAndValidate() throws InterruptedException, IOException {
		home.clickToCart();
		wait.until(ExpectedConditions.urlMatches(driver.getCurrentUrl()));
		Assert.assertEquals(driver.getCurrentUrl(), PropertyReader.configReader("cartpage_url"));
    }
	
	@Test (priority=5)
	public void clickCheckoutAndValidate() throws InterruptedException, IOException {
		home.clickToCheckout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHEKOUT_TEXT)));
		Assert.assertEquals(driver.findElement(By.xpath(CHEKOUT_TEXT)).getText(), PropertyReader.configReader("checkout_page_info"));
	 }
	 
	@Test (priority=6)
	public void enterDetailsAtCheckoutPage() throws InterruptedException, IOException {
		checkout.enterFirstName();
		checkout.enterLastName();
		checkout.enterZipCodee();
		checkout.clickToContinueButton();
		validateDetailsAtCheckoutPage();
	 }

	private void validateDetailsAtCheckoutPage() throws IOException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHEKOUT_TEXT)));
		Assert.assertEquals(driver.findElement(By.xpath(CHEKOUT_TEXT)).getText(), PropertyReader.configReader("checkout_page_overview"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TOTAL_PRICE)));
		String totalPriceFormat = driver.findElement(By.xpath(TOTAL_PRICE)).getText();
		int index = totalPriceFormat.indexOf("$");
		Assert.assertEquals(totalPriceFormat.substring(0,index+1), "Total: $");
	}	 
}
