package com.ishita.swaglabs.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ishita.swaglabs.base.BaseMethods;
import com.ishita.swaglabs.library.PropertyReader;

/**
 * This test case performs and validates the login functionality.
 *
 */

public class TC001_PerformLogin extends BaseMethods {

	private static final String PRODUCTS_TITLE = "//span[contains(text(), 'Products')]";

	@Test
	public void performLoginAndValidate() throws IOException {
		getLogin().enterUsername();
		getLogin().enterPassword();
		getLogin().clickLoginButton();
		
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRODUCTS_TITLE)));
		String actualTitle = getDriver().findElement(By.xpath(PRODUCTS_TITLE)).getText();
		Assert.assertEquals(actualTitle, PropertyReader.configReader("productspage_title"));
	}

}
