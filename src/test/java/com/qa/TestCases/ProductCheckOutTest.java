package com.qa.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Pages.CheckOutPage;
import com.qa.Pages.HomePage;
import com.qa.Pages.ProductInfoPage;
import com.qa.Pages.ProductPage;
import com.qa.Pages.ShoppingCartPage;

public class ProductCheckOutTest {
	public WebDriver driver;
	public HomePage homepage;
	public ProductPage product_page;
	public ShoppingCartPage shoppingcart_page;
	public CheckOutPage checkout_page;
	public ProductInfoPage productinfopage;

	
	
	@BeforeMethod
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
	    homepage = new HomePage(driver);
		homepage.laptopDropdown();
		product_page  = homepage.alllaptopsoption();
	
	}
	@Test
	public void checkoutProduct() throws Exception {
		productinfopage = new ProductInfoPage(driver);
		shoppingcart_page = new  ShoppingCartPage(driver);
	    product_page.SelectProductOption();
	    productinfopage.clickOnAddToCart();
		shoppingcart_page.continueToShoppingCart();
		checkout_page = shoppingcart_page.checkoutOption();
		checkout_page.clickOnCheckout();
		checkout_page.emailfield();
		checkout_page.passwordField();
		checkout_page.loginButton();
		checkout_page.newAddressRadioButton();
		checkout_page.firstNamefield();
		checkout_page.lastNameField();
		checkout_page.addressfield();
		checkout_page.cityField();
		checkout_page.postcodeField();
		Select select = new Select(driver.findElement(By.id("input-payment-country")));
    	select.selectByVisibleText("United States");
    	
    	Select select1 = new Select(driver.findElement(By.xpath("//select[@id='input-payment-zone']")));
    	select1.selectByVisibleText("New Jersey");
        checkout_page.continueButtonAddress();
    	checkout_page.continueButtonShipping();
    	checkout_page.continueButtonShippingmethod();
    	checkout_page.termsAndConditionButton();
    	checkout_page.continueButtonPaymentMethod();
    	checkout_page.confirmOrder();
    	Assert.assertTrue(checkout_page.orderSucessMessage());
    	
    
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
		}
}