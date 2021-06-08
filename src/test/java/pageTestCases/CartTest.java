package pageTestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObject.CartPage;
import pageObject.HomePage;
import resource.BaseClass;
import resource.Liberary;

@Listeners({ AllureListeners.class })
public class CartTest extends BaseClass {


	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	CartPage cartPg;
	HomePage homePg;
	Liberary lib = new Liberary();
	public static Logger log = LogManager.getLogger(CartTest.class.getName());

	@BeforeMethod
	public void intialise() throws ParseException {
		driver = intializingDriver();
		log.info("Browser open");
		driver.get(url);
		homePg = (PageFactory.initElements(driver, HomePage.class));
		cartPg = (PageFactory.initElements(driver, CartPage.class));
	}
	
//	@Test(priority = 1, description = "Verify Quantity drop down is displayed and user is able to select values")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Selected value should be displayed after selection of Quantity drop down")
	@Story("Story Name: To check user is able to select value from Quantity drop down")
	public void searchedItemsDisplayed() {
		homePg.txtSearchBox().sendKeys("echo dot");
		homePg.btnSearchBox().click();
		cartPg.btnSearchedItem().click();
		lib.windowHandlesChild();
		lib.selectValueFromDropDown(cartPg.dropDownQty(),"2");
		log.debug(cartPg.dropDownQty().getAttribute("value"));
		}
	
	
//@Test(priority = 2, description = "Verify buttons Add to Cart, Buy Now and Add to Wish List are displayed")
@Severity(SeverityLevel.NORMAL)
@Description("Test Case Description:Verify buttons Add to Cart, Buy Now and Add to Wish List are displayed")
@Story("Story Name: To check user is able to see Add to Cart, Buy Now and Add to Wish List")
public void btnAddCartBuyNowAddWishListDisplayed() {
	homePg.txtSearchBox().sendKeys("echo dot");
	homePg.btnSearchBox().click();
	cartPg.btnSearchedItem().click();
	lib.windowHandlesChild();
	boolean addCart = cartPg.btnAddCart().isDisplayed();
	softAssert.assertEquals(addCart, true);
//	log.info("Add Cart button displayed");
	boolean buyNow = cartPg.btnBuyNow().isDisplayed();
	softAssert.assertEquals(buyNow, true);
//	log.info("Buy Now button displayed");
	lib.jsExecuteScrollDown();
	boolean addWishList = cartPg.btnAddWishList().isDisplayed();
	Assert.assertEquals(addWishList, true);
	//log.info("Add to Wish List button displayed");
	
	}

@Test(priority = 3, description = "user is able to select all the checkboxes present in the box")
@Severity(SeverityLevel.NORMAL)
@Description("Test Case Description:user is able to select all the checkboxes present in the box")
@Story("Story Name: To check user is able check the checkbox")
public void checkboxCheckedVerification() {
	homePg.txtSearchBox().sendKeys("echo dot");
	homePg.btnSearchBox().click();
	cartPg.btnSearchedItem().click();
	lib.windowHandlesChild();
	lib.jsExecuteScrollDown();
	if(cartPg.msgDeliveryApplicable().isDisplayed())
	{
		log.debug(cartPg.msgDeliveryApplicable().getText());
	cartPg.btnAddWishList().click();
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	else
	{
	cartPg.chkboxGift().click();
	boolean gift = cartPg.chkboxGift().isSelected();
	softAssert.assertEquals(gift,true,"Gift checkbox selected");
	if(cartPg.chkboxGift().isSelected())
	{
	log.info("Link Device checkbox is disabled");	
	}
	else {
		boolean linkDevice = cartPg.chkboxLinkDevice().isSelected();
		softAssert.assertEquals(linkDevice,true,"Link Device checkbox selected");	
	}
	lib.jsExecuteScrollDown();
	cartPg.chkboxAckoWarranty().click();
	boolean ackoWarranty = cartPg.chkboxAckoWarranty().isSelected();
	softAssert.assertEquals(ackoWarranty,true,"Acko Warranty checkbox selected");
	cartPg.chkboxOneAssistWarranty().click();
	boolean oneAssistWarranty = cartPg.chkboxOneAssistWarranty().isSelected();
	softAssert.assertEquals(oneAssistWarranty,true,"One Assist Warranty checkbox selected");
	}
}
@AfterTest
public void tearDown() {
	softAssert.assertAll();
	driver.quit();
}
}
	



