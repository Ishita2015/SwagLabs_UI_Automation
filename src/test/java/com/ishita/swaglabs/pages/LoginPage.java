package com.ishita.swaglabs.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ishita.swaglabs.base.BaseMethods;
import com.ishita.swaglabs.library.PropertyReader;

public class LoginPage extends BaseMethods {

	@FindBy(id="user-name") WebElement usernameTextbox;
	@FindBy(id="password") WebElement passwordTextbox;
	@FindBy(id="login-button") WebElement loginButton;
	
	public void enterUsername() throws IOException {
		usernameTextbox.sendKeys(PropertyReader.configReader("username"));
		
		// use below line of code when don't want to disclose sensitive information on code/properties file
		// usernameTextbox.sendKeys(System.getenv("swaglabs_username"));
	}
	
	public void enterPassword() throws IOException {
		passwordTextbox.sendKeys(PropertyReader.configReader("password"));
		
		// use below line of code when don't want to disclose sensitive information on code/properties file
		// passwordTextbox.sendKeys(System.getenv("swaglabs_password"));
	}
	
	public void clickLoginButton() throws IOException {
		loginButton.click();
	}
		
}
