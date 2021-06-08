package pageTestCases;

import java.util.List;

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
import pageObject.FooterLinksPage;
import resource.BaseClass;
import resource.Liberary;

@Listeners({ AllureListeners.class })
public class FooterLinksTest extends BaseClass {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	FooterLinksPage FooterPg;
	Liberary lib = new Liberary();
	public static Logger log = LogManager.getLogger(HomeTest.class.getName());

	@BeforeMethod
	public void intialise() throws ParseException {
		driver = intializingDriver();
		log.info("Browser open");
		driver.get(url);
		FooterPg = (PageFactory.initElements(driver, FooterLinksPage.class));
	}
	
//	@Test(priority = 0, description = "To get all the links of footer")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Verify to get text of all links in footer")
	@Story("Story Name: To know the text of footer")
	public void getFooterLinks() {
		lib.jsExecuteScrollBottom();
		log.debug(FooterPg.getFooterlinks().getText());			
	}
	
	@Test(priority = 1, description = "To get all the Countries Name of footer")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Verify to get all the Countries Name of footer")
	@Story("Story Name: To get all the Countries Name of footer")
	public void getFooterCountries() {
		lib.jsExecuteScrollBottom();
		for(int i=0;i<FooterPg.getCountriesName().size();i++)
		{
			log.debug(FooterPg.getCountriesName().get(i).getText());
		}
	
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
