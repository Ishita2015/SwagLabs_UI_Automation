package com.ishita.swaglabs.testcases;

import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ishita.swaglabs.base.BaseMethods;
import com.ishita.swaglabs.library.PropertyReader;

/**
 * This test case applies filters, adds items into the cart and validates if you are taken to the CART page.
 *
 */

public class TC003_ApplyFilterAndAddItemToCart extends BaseMethods {
	
	private static final String HIGH_TO_LOW = "Price (high to low)";
	private static final String LOW_TO_HIGH = "Price (low to high)";	
	
	@Test
	public void applyFilterAndAddToCart() throws IOException, InterruptedException {
		getHome().clickToFilter(HIGH_TO_LOW);
		getHome().clickAddToCart();
		
		getHome().clickToFilter(LOW_TO_HIGH);
		getHome().clickAddToCart();
		
		getHome().goToCart();
		Thread.sleep(3000);
		getWait().until(ExpectedConditions.urlMatches(getDriver().getCurrentUrl()));
		Assert.assertEquals(getDriver().getCurrentUrl(), PropertyReader.configReader("cartpage_url"));
	}

}
