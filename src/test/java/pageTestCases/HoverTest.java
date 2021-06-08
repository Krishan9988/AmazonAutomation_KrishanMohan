package pageTestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObject.CartPage;
import pageObject.HomePage;
import pageObject.HoverPage;
import resource.BaseClass;
import resource.Liberary;

public class HoverTest extends BaseClass {

	
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	CartPage cartPg;
	HoverPage hoverPg;
	HomePage homePg;
	Liberary lib = new Liberary();
	public static Logger log = LogManager.getLogger(HoverTest.class.getName());

	@BeforeMethod
	public void intialise() throws ParseException {
		driver = intializingDriver();
		log.info("Browser open");
		driver.get(url);
		hoverPg = (PageFactory.initElements(driver, HoverPage.class));
		cartPg = (PageFactory.initElements(driver, CartPage.class));
		homePg = (PageFactory.initElements(driver, HomePage.class));
	}	
	
	@Test(description = "Verify Hover Text for the benefits available on an item")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Verify Hover Text for the Pay on Delivery, 10 days returnable, Amazon Delivered and 1 Year Warranty")
	@Story("Story Name: To check user is able to hover on Pay on Delivery, 10 days returnable, Amazon Delivered and 1 Year Warranty")
	public void hoverTextDisplayed() {
		homePg.txtSearchBox().sendKeys("echo dot");
		homePg.btnSearchBox().click();
		cartPg.btnSearchedItem().click();
		lib.windowHandlesChild();
		lib.jsExecuteScrollDown();
		Actions a = new Actions(driver);
		WebElement d = driver.findElement(By.xpath("//div[@id='PAY_ON_DELIVERY']"));
		a.moveToElement(d).build().perform();
//		for(int i=0;i<hoverPg.hoverBenefits().size();i++)
//		{
//			WebElement t = hoverPg.hoverBenefits().get(i);
//			lib.mouseHover(t);
//			System.out.println(t.getText());
//		}
		
		}
	
	//@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
