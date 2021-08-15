package com.ishita.swaglabs.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ishita.swaglabs.base.BaseMethods;
import com.ishita.swaglabs.library.PropertyReader;

public class TC002_GoToAbout extends BaseMethods {

	private static final String PRODUCTS_TITLE = "//span[contains(text(), 'Products')]";

	@Test
	public void goToAboutClickBackAndValidate() throws InterruptedException, IOException {
		getHome().openMenuAndSelectAbout();
		Assert.assertEquals(getDriver().getCurrentUrl(), PropertyReader.configReader("about_url"));
		
		getDriver().navigate().back();
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRODUCTS_TITLE)));
		String actualTitle = getDriver().findElement(By.xpath(PRODUCTS_TITLE)).getText();
		Assert.assertEquals(actualTitle, PropertyReader.configReader("productspage_title"));
	}

}
