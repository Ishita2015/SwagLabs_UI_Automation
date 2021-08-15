package com.ishita.swaglabs.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ishita.swaglabs.library.PageActions;

public class LoginPage {
	
	public PageActions action;
	public LoginPage() {
		action = new PageActions();
	}

	@FindBy(id="user-name") WebElement usernameTextbox;
	@FindBy(id="password") WebElement passwordTextbox;
	@FindBy(id="login-button") WebElement loginButton;
	
	public void enterUsername() throws IOException {
		action.enterDataIntoTextBox(usernameTextbox, System.getenv("swaglabs_username"));
	}
	
	public void enterPassword() throws IOException {
		action.enterDataIntoTextBox(passwordTextbox, System.getenv("swaglabs_password"));
	}
	
	public void clickLoginButton() throws IOException {
		action.clickButton(loginButton);
	}
		
}
