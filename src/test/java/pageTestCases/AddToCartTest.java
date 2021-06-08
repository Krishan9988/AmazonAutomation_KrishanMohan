package pageTestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObject.AddToCartPage;
import pageObject.CartPage;
import pageObject.HomePage;
import resource.BaseClass;
import resource.Liberary;
@Listeners({ AllureListeners.class })
public class AddToCartTest extends BaseClass {
	
	HomePage homePg;
	CartPage cartPg;
	AddToCartPage addCartPg;
	Liberary lib = new Liberary();
	public static Logger log = LogManager.getLogger(AddToCartTest.class.getName());

	@BeforeMethod
	public void intialise() throws ParseException {
		getIntializingDriver();
		log.info("Browser open");
		getURL();
		homePg = (PageFactory.initElements(driver, HomePage.class));
		cartPg = (PageFactory.initElements(driver, CartPage.class));
		addCartPg = (PageFactory.initElements(driver, AddToCartPage.class));
	}

//	@Test(priority = 1, description = "Verify Added to Cart text displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Verify Added to Cart text displayed")
	@Story("Story Name: To check user is able to see Add item into Cart than see Added to Cart text")
	public void txtAddedToCartCapture() {
		homePg.txtSearchBox().sendKeys("echo dot");
		homePg.btnSearchBox().click();
		cartPg.btnSearchedItem().click();
		lib.windowHandlesChild();
		cartPg.btnAddCart().click();
		addCartPg.btnPopup().click();
		log.debug(addCartPg.txtAddedCart());
	}

	@Test(priority = 2, description = "Verify Cart Count displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Verify Cart Count displayed")
	@Story("Story Name: To check user is able to see Cart count 1 or more than 1")
	public void cartCountCapture() {
		homePg.txtSearchBox().sendKeys("echo dot");
		homePg.btnSearchBox().click();
		cartPg.btnSearchedItem().click();
		lib.windowHandlesChild();
		cartPg.btnAddCart().click();
		addCartPg.btnPopup().click();
		Assert.assertEquals(addCartPg.txtAddedCart(), "Added to Cart");
		if (addCartPg.cartCount().getText().length() <= 1) {
			log.debug("Count displayed for Cart " + addCartPg.cartCount().getText());
		} else {
			log.debug("Count Not appear in Cart");
		}
	}

//	@Test(priority = 3, description = "Verify user is able to delete items from cart")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Verify user is able to delete items from cart")
	@Story("Story Name: To check user is able to see remove the item from Cart")
	public void removeItemFromCart() {
		homePg.txtSearchBox().sendKeys("echo dot");
		homePg.btnSearchBox().click();
		cartPg.btnSearchedItem().click();
		lib.windowHandlesChild();
		cartPg.btnAddCart().click();
		addCartPg.btnPopup().click();
		addCartPg.cartCount().click();
		addCartPg.btnRemoveItemCart().click();
		if (addCartPg.cartCount().getText().length() <= 1) {
			log.debug("Count displayed for Cart " + addCartPg.cartCount().getText());
		} else {
			log.debug("Count Not appear in Cart " + addCartPg.cartCount().getText());
		}
	}

//	@Test(priority = 4, description = "Verify Item price is same after adding to cart")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Verify Item price is same after adding to cart")
	@Story("Story Name: To check Item price is same after adding to cart")
	public void itemPriceVerification() throws InterruptedException {
		homePg.txtSearchBox().sendKeys("echo dot");
		homePg.btnSearchBox().click();
		cartPg.btnSearchedItem().click();
		lib.windowHandlesChild();
		String price = addCartPg.getItemPriceBeforeCart().getText();
		System.out.println(price);
		String[] priceSplit = price.split(" ");
		 String priceRupee = priceSplit[0];
		String actualPrice = priceSplit[1];
		System.out.println("Before Cart Price "+actualPrice);
	lib.explicitWaitClickable(cartPg.btnAddCart()).click();
	//if(driver.findElements(By.xpath("//h4[contains(@id,'a-popover-header')]")).size()>0)
		//if(addCartPg.btnPopup().)
		{
			addCartPg.btnPopup().click();
			//
		//	lib.explicitWaitClickable(driver.findElement(By.xpath("(//div[@id='addToCart_feature_div'])[2]"))).click();
		}
	Thread.sleep(5000);
		lib.explicitWaitClickable(addCartPg.btnCart()).click();
		String priceCart = addCartPg.getItemPriceAfterCart().getText();
		//String pc = priceCart.trim();
	//	System.out.println("PC"+pc);
		String[] priceCartSplit = priceCart.split("   ");
		 String priceCartRupee = priceCartSplit[0];
		String actualPriceCart = priceCartSplit[1];
		System.out.println("After Cart Price "+actualPriceCart);
		Assert.assertEquals(actualPrice, actualPriceCart,
				"Checking the price before and after cart for selected item");

	}

//	@Test(priority = 5, description = "Verify price getting increased accordingly in cart when user increasing the quantity")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Verify Item price increased in cart on increasing quantity")
	@Story("Story Name: To check Item price getting increase on increasing quantity")
	public void itemPriceIncreasedOnIncreasingQty() throws InterruptedException {
		homePg.txtSearchBox().sendKeys("AmazonBasics Adjustable Cell");
		homePg.btnSearchBox().click();
		cartPg.btnSearchedItem().click();
		lib.windowHandlesChild();
		cartPg.btnAddCart().click();
		addCartPg.cartCount().click();
		String subTotalPrice = addCartPg.getItemPriceBeforeIncreasingQty().getText().trim();
		lib.selectValueFromDropDown(addCartPg.selectQtyInCart(), "2");
		Thread.sleep(2000);
		String increasedSubTotalPrice = addCartPg.getItemPriceBeforeIncreasingQty().getText().trim();
		Assert.assertNotEquals(subTotalPrice, increasedSubTotalPrice, "Checking the both prices are different");

	}

	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
}
