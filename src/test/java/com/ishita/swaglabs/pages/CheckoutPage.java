package com.ishita.swaglabs.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ishita.swaglabs.library.PageActions;
import com.ishita.swaglabs.library.PropertyReader;

public class CheckoutPage {

	public PageActions action;
	public CheckoutPage() {
		action = new PageActions();
	}
	
	@FindBy(id="first-name") WebElement firstNameTextbox;
	@FindBy(id="last-name") WebElement lastNameTextbox;
	@FindBy(id="postal-code") WebElement zipCodeTextbox;
	@FindBy(id="continue") WebElement continueButton;
	@FindBy(id="finish") WebElement finishButton;
	
	
	public void enterFirstName() throws IOException {
		action.enterDataIntoTextBox(firstNameTextbox, PropertyReader.configReader("firstname"));
	}
	
	public void enterLastName() throws IOException {
		action.enterDataIntoTextBox(lastNameTextbox, PropertyReader.configReader("lastname"));
	}
	
	public void enterZipCodee() throws IOException {
		action.enterDataIntoTextBox(zipCodeTextbox, PropertyReader.configReader("zipcode"));
	}
	
	public void clickToContinueButton() {
		action.clickButton(continueButton);
	}	
	
	public void clickToFinishButton() {
		action.clickButton(finishButton);
	}
	
}
