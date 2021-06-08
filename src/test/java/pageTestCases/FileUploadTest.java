package pageTestCases;

import java.awt.AWTException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import resource.BaseClass;

import resource.Utilities;

public class FileUploadTest extends BaseClass {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	Utilities Util;
	public static Logger log = LogManager.getLogger(HomeTest.class.getName());
	
	@BeforeMethod
	public void intialise() throws ParseException {
		driver = intializingDriver();
		log.info("Browser open");
		driver.get(imageurl);
		 Util = new Utilities();
	}
	
	@Test(priority = 0, description = "To upload a file")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Verify to upload a file")
	@Story("Story Name: To Upload a file")
	public void getFooterLinks() throws AWTException, InterruptedException {
		Util.getUploadFile("C:\\Users\\ricky\\Downloads\\Console.jpg");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
