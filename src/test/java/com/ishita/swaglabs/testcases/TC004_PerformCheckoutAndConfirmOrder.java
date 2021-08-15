package com.ishita.swaglabs.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ishita.swaglabs.base.BaseMethods;
import com.ishita.swaglabs.library.PropertyReader;

public class TC004_PerformCheckoutAndConfirmOrder extends BaseMethods {
	
	private static final String ORDER_CONFIRMATION_TEXT = "//h2[contains(text(), 'THANK YOU FOR YOUR ORDER')]";
	private static final String TOTAL_PRICE = "//div[@class='summary_total_label']";
	private static final String CHEKOUT_TEXT = "//span[@class='title']";
	
	@Test
	public void clickCheckoutAndValidate() throws InterruptedException, IOException {
		getHome().clickToCheckout();
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHEKOUT_TEXT)));
		Assert.assertEquals(getDriver().findElement(By.xpath(CHEKOUT_TEXT)).getText(),
							PropertyReader.configReader("checkout_page_info"));
	 }
	 
	@Test (dependsOnMethods ={ "clickCheckoutAndValidate" })
	public void enterDetailsAtCheckoutPage() throws InterruptedException, IOException {
		getCheckout().enterFirstName();
		getCheckout().enterLastName();
		getCheckout().enterZipCodee();
		getCheckout().clickToContinueButton();
		validateDetailsAtCheckoutPage();
	 }

	private void validateDetailsAtCheckoutPage() throws IOException {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHEKOUT_TEXT)));
		Assert.assertEquals(getDriver().findElement(By.xpath(CHEKOUT_TEXT)).getText(),
							PropertyReader.configReader("checkout_page_overview"));
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TOTAL_PRICE)));
		String totalPriceFormat = getDriver().findElement(By.xpath(TOTAL_PRICE)).getText();
		int index = totalPriceFormat.indexOf("$");
		Assert.assertEquals(totalPriceFormat.substring(0,index+1), "Total: $");
	}	 
	
	@Test (dependsOnMethods ={ "enterDetailsAtCheckoutPage" })
	public void finishOrderAndValidateOrderAtCheckoutPage() throws InterruptedException, IOException {
		getCheckout().clickToFinishButton();
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ORDER_CONFIRMATION_TEXT)));
		Assert.assertEquals(getDriver().findElement(By.xpath(ORDER_CONFIRMATION_TEXT)).getText(),
							PropertyReader.configReader("order_confirmation_text"));
	 }

}
