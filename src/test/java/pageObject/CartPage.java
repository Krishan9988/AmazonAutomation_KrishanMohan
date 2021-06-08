package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import resource.Liberary;

public class CartPage {

	WebDriver driver;
	Liberary lib = new Liberary();

	public CartPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	//To click on first searched item
	@FindBy(xpath="//div[@class='a-section a-spacing-none']/h2/a") WebElement firstSearchedItem;
	@FindBy(css="select[id='quantity']") WebElement qtyDropDown;
	@FindBy(id="add-to-cart-button") WebElement addCart;
	@FindBy(css="input[id='buy-now-button']") WebElement buyNow;
	@FindBy(xpath="//a[contains(@name,'wishlist')]") WebElement addWishList;
	@FindBy(xpath="//input[@id='gift-wrap']") WebElement gift;
	@FindBy(xpath="//input[@id='account-linking']") WebElement linkDevice;
	@FindBy(xpath="//input[contains(@id,'abb-option-offerId')]") WebElement ackoWarranty;
	@FindBy(xpath="(//input[contains(@id,'abb-option-offerId')])[2]") WebElement oneAssistWarranty;
	@FindBy(id="ddmDeliveryMessage") WebElement msgDeliveryMessage;
	
	@Step("Click on first searched item")
	public WebElement btnSearchedItem()
	{
		return firstSearchedItem;
	}
	@Step("Select value from drop down")
	public WebElement dropDownQty()
	{
		return qtyDropDown;
	}
	
	@Step("Method to show Delivery message i.e. Delivery applicable to area")
	public WebElement msgDeliveryApplicable()
	{
		return msgDeliveryMessage;
	}
	@Step("Method for Add to Cart")
	public WebElement btnAddCart()
	{
		return addCart;
	}
	
	@Step("Method for Buy Now")
	public WebElement btnBuyNow()
	{
		return buyNow;
	}
	
	@Step("Method for Add to Wish List")
	public WebElement btnAddWishList()
	{
		return addWishList;
	}
	
	@Step("Method to checked Gift checkbox")
	public WebElement chkboxGift()
	{
		return gift;
	}
	
	@Step("Method to checked Link Device checkbox")
	public WebElement chkboxLinkDevice()
	{
		return linkDevice;
	}
	
	@Step("Method to checked Acko Warranty checkbox")
	public WebElement chkboxAckoWarranty()
	{
		return ackoWarranty;
	}
	
	@Step("Method to checked OneAssist Warranty checkbox")
	public WebElement chkboxOneAssistWarranty()
	{
		return oneAssistWarranty;
	}
}
