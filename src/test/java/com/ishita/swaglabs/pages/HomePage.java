package com.ishita.swaglabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath="//button[@id='react-burger-menu-btn']") WebElement openMenuButton;
	@FindBy(id="about_sidebar_link") WebElement aboutButton;
	@FindBy(xpath="//a[@class='shopping_cart_link']") WebElement cartButton;
	@FindBy(id="checkout") WebElement checkoutButton;
	
	public void openMenuAndSelectAbout() {
		openMenuButton.click();
		aboutButton.click();
	}
	
	public void clickToCart() {
		cartButton.click();
	}
	
	public void clickToCheckout() {
		checkoutButton.click();
	}
	
}
