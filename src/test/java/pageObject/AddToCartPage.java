package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import resource.Liberary;

public class AddToCartPage {

	WebDriver driver;
	Liberary li = new Liberary();
	public AddToCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="button[class=' a-button-close a-declarative']") WebElement popup;
	@FindBy(css=".a-size-medium.a-text-bold") WebElement addedCart;
	@FindBy(xpath="//span[@id='nav-cart-count']") WebElement cartCount; 
	@FindBy(xpath="//input[contains(@name,'submit.delete')]") WebElement removeItemFromCart;
	@FindBy(xpath="//span[@id='priceblock_ourprice']") WebElement itemPrice;
	@FindBy(css="#sc-subtotal-amount-activecart") WebElement itemPriceCart;
	@FindBy(xpath="//span[contains(@class,'a-size-medium a-color-base')]") WebElement subtotalPrice;
	@FindBy(xpath="//select[@name='quantity']") WebElement qtyDropdown;
	@FindBy(css="a[id='nav-cart']") WebElement cart;
	@Step("To click on popup")
	public WebElement btnPopup()
	{
		return popup;
	}
	@Step("To fetch on Added to Cart text")
	public String txtAddedCart()
	{
		return addedCart.getText();
	}
	@Step("To click on Cart")
	public WebElement btnCart()
	{
		return cart;
	}
	@Step("Method to know Cart Count/Click")
	public WebElement cartCount()
	{
		return cartCount;
	}
	
	@Step("Method to remove item from Cart")
	public WebElement btnRemoveItemCart()
	{
		return removeItemFromCart;
	}
	
	@Step("Method to know item price before adding to Cart")
	public WebElement getItemPriceBeforeCart()
	{
		return itemPrice;
	}
	
	@Step("Method to know item price after adding to Cart")
	public WebElement getItemPriceAfterCart()
	{
		return itemPriceCart;
	}
	
	@Step("Method to know item price after adding to Cart")
	public WebElement getItemPriceBeforeIncreasingQty()
	{
		return subtotalPrice;
	}
	
	@Step("Method to select Qty in Cart")
	public WebElement selectQtyInCart()
	{
		return qtyDropdown;
	}
}
