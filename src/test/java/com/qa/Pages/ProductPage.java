package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public WebDriver driver;
	
	@FindBy(linkText= "MacBook Air")
	private WebElement SelectProduct;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
		
	}
	public ProductInfoPage SelectProductOption() {
		SelectProduct.click();
		return new ProductInfoPage(driver);
	}
	

}
