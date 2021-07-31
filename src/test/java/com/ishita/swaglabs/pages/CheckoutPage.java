package com.ishita.swaglabs.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ishita.swaglabs.library.PropertyReader;

public class CheckoutPage {

	@FindBy(id="first-name") WebElement firstNameTextbox;
	@FindBy(id="last-name") WebElement lastNameTextbox;
	@FindBy(id="postal-code") WebElement zipCodeTextbox;
	@FindBy(id="continue") WebElement continueButton;
	
	public void enterFirstName() throws IOException {
		firstNameTextbox.sendKeys(PropertyReader.configReader("firstname"));
	}
	
	public void enterLastName() throws IOException {
		lastNameTextbox.sendKeys(PropertyReader.configReader("lastname"));
	}
	
	public void enterZipCodee() throws IOException {
		zipCodeTextbox.sendKeys(PropertyReader.configReader("zipcode"));
	}
	
	public void clickToContinueButton() {
		continueButton.click();
	}	
	
}
