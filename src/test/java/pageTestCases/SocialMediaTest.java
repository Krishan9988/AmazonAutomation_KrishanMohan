package pageTestCases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObject.AddToCartPage;
import pageObject.CartPage;
import pageObject.HomePage;
import pageObject.SocialMediaPage;
import resource.BaseClass;
import resource.Liberary;

public class SocialMediaTest extends BaseClass {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	HomePage homePg;
	CartPage cartPg;
	AddToCartPage addCartPg;
	SocialMediaPage socialPg;
	Liberary lib = new Liberary();
	public static Logger log = LogManager.getLogger(AddToCartTest.class.getName());
	
	@BeforeMethod
	public void intialise() throws ParseException {
		driver = intializingDriver();
		log.info("Browser open");
		driver.get(url);
		homePg = (PageFactory.initElements(driver, HomePage.class));
		cartPg = (PageFactory.initElements(driver, CartPage.class));
		addCartPg = (PageFactory.initElements(driver, AddToCartPage.class));
		socialPg = (PageFactory.initElements(driver, SocialMediaPage.class));
	}

	@Test(priority = 1, description = "Verify user is navigated to respective pages when clicked on social media links like Facebook, Twitter and Pinterest")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Verify user is navigated to respective pages when clicked on social media links like Facebook, Twitter and Pinterest")
	@Story("Story Name: To check user is able navigate to social media link")
	public void chkSocialMediaLink() {
		homePg.txtSearchBox().sendKeys("echo dot");
		homePg.btnSearchBox().click();
		cartPg.btnSearchedItem().click();
		lib.windowHandlesChild();
		socialPg.getSocialMediaLink();
		for(int i=0;i<socialPg.getSocialMediaLink().size();i++)
		{
			if(!socialPg.getSocialMediaLink().get(i).getAttribute("title").equalsIgnoreCase("Share via e-mail"))
			{
				socialPg.getSocialMediaLink().get(i).click();
			}
		}
				Set<String> windowHandle= driver.getWindowHandles();
				Iterator<String> it= windowHandle.iterator();
				 while(it.hasNext())
				 {
					 driver.switchTo().window(it.next());
					 log.debug(driver.getTitle());
					 log.debug(driver.getCurrentUrl());
				 }
				 
			}
		
		
	
	
	@AfterMethod
	public void teardown() {
		softAssert.assertAll();
		driver.quit();
	}
	
}
