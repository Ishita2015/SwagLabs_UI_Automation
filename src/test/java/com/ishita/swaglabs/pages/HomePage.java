package com.ishita.swaglabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ishita.swaglabs.library.PageActions;

public class HomePage {
	
	public PageActions action;
	public HomePage() {
		action = new PageActions();
	}

	@FindBy(xpath="//button[@id='react-burger-menu-btn']") WebElement openMenuButton;
	@FindBy(id="about_sidebar_link") WebElement aboutButton;
	@FindBy(xpath="//select[@class='product_sort_container']") WebElement filterButton;
	@FindBy(xpath="//button[contains(text(),'Add to cart')]") WebElement addToCartButton;
	@FindBy(xpath="//a[@class='shopping_cart_link']") WebElement linkToCartTab;
	@FindBy(xpath="//button[@id='checkout']") WebElement checkoutButton;
	
	public void openMenuAndSelectAbout() {
		action.clickButton(openMenuButton); 
		action.clickButton(aboutButton);
	}
	
	public void clickAddToCart() {
		action.clickButton(addToCartButton);
	}
	
	public void clickToCheckout() {
		action.clickButton(checkoutButton);
	}
	
	public void clickToFilter(String value) {
		action.selectDataUsingVisibleText(filterButton, value);
	}
	
	public void goToCart() {
		action.clickButton(linkToCartTab);
	}
	
}
