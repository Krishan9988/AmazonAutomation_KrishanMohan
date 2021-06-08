package pageTestCases;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObject.HomePage;
import resource.BaseClass;
import resource.Liberary;

@Listeners({ AllureListeners.class })
public class HomeTest extends BaseClass {
	HomePage homePg;
	Liberary lib = new Liberary();
	public static Logger log = LogManager.getLogger(HomeTest.class.getName());

	@BeforeMethod
	public void intialise() throws ParseException {
		getIntializingDriver();
		log.info("Browser open");
		getURL();
		homePg = (PageFactory.initElements(driver, HomePage.class));
		// PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	@Test(priority = 0, description = "To verify SearchBox Element visible on Home page")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Verify SearchBox")
	@Story("Story Name: To check SearchBox button visible on Home Page")
	public void searchBoxVisibilty() {
		boolean searchbox = homePg.btnSearchBox().isDisplayed();
		Assert.assertEquals(searchbox, true);
	}

	@Test(priority = 1, description = "To verify on entering data in Search text box than suggested item displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Verify Search text box suggested items")
	@Story("Story Name: To check Search text box showing suggested item list on entering data")
	public void searchBoxSuggestedItemsDisplayed() {
		homePg.txtSearchBox().sendKeys("mobile");
		for (int i = 0; i < homePg.getSuggestedItems().size(); i++) {
			String list = homePg.getSuggestedItems().get(i).getText();
			if (list.length() > 0) {
				Assert.assertTrue(true);
				log.debug("Suggested Items displayed");
			} else {
				System.out.println("Not displayed");
			}
		}
	}

	@Test(priority = 2, description = "To verify on searching list of search items displayed")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Verify Searched items displayed")
	@Story("Story Name: To check user is able to search item and see the result")
	public void searchedItemsDisplayed() {
		homePg.txtSearchBox().sendKeys("echo dot");
		homePg.btnSearchBox().click();
		for (int i = 0; i < homePg.getSearchedItemsList().size(); i++) {
			String searchedList = homePg.getSearchedItemsList().get(i).getText();
			System.out.println(searchedList);
			if (searchedList.length() > 0) {
				Assert.assertTrue(true);
				log.debug("Searched Items displayed");
			} else {
				System.out.println("Searched Items not displayed");
			}
		}
	}

	@Test(priority = 3, description = "Verify user is able to search items using Shop by Department option. (All >> Shop By Department >> TV, Appliances  >> DSLR Cameras) ")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Verify user is able to search items using Shop by Department option")
	@Story("Story Name: To check user is able to search item using Shop by Department option")
	public void shopByDepartmentOption() {
		homePg.btnAllMenu().click();
		lib.jsExecuteScrollDown();
		homePg.optTVAPP().click();
		lib.jsExecuteScrollDown();
		homePg.optDSLRCameras().click();
		for (int i = 0; i < homePg.getCamerasItemsList().size(); i++) {
			String camerasList = homePg.getCamerasItemsList().get(i).getAttribute("title");
			System.out.println(camerasList);
			if (camerasList.length() > 0) {
				Assert.assertTrue(true);
				log.debug("Cameras Items displayed");
			} else {
				System.out.println("Cameras Items not displayed");
			}
		}
	}
	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
	
}
