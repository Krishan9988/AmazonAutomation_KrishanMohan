package pageTestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObject.HomePage;
import pageObject.LoginPage;
import resource.BaseClass;
import resource.Liberary;
import resource.Utilities;

@Listeners({AllureListeners.class})
public class LoginTest extends BaseClass {

	HomePage homePg;
	LoginPage LoginPg;
	Liberary lib = new Liberary();
	Utilities util =new Utilities();
	public static Logger log = LogManager.getLogger(LoginTest.class.getName());
	@BeforeTest
	public void setup() throws ParseException
	{
		getIntializingDriver();
		homePg = new HomePage(driver);
		LoginPg= new LoginPage(driver);
	}	
	@Test(priority=1, description = "To verify user able to SignIn successfully")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:To verify user able to SignIn successfully")
	@Story("Story Name: To check user able to SignIn")
	public void signIn() {
		log.info("Browser open");
		driver.get(url);
		LoginPg.openSignIn().click();
		LoginPg.email().sendKeys(username);
		LoginPg.Continue().click();{
		LoginPg.password().sendKeys(lib.decodestring("cmFtYWJoYWxsYQ=="));
		LoginPg.btnSignIn().click();
		log.debug("User login successfully------- " + LoginPg.getSignInUserName().getText());
	}
	
	}
	
	@Test(dependsOnMethods={"signIn"},description = "To verify user able to SignOut successfully")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:To verify user able to SignOut successfully")
	@Story("Story Name: To check user able to SignOut")
	public void signOut() {
		lib.mouseHover(LoginPg.getSignInUserName());
		LoginPg.btnSignOut().click();
		driver.navigate().back();
		driver.navigate().refresh();
		log.debug("User logout successfully------ " + LoginPg.getSignInUserName().getText());	
	}
	
	@Test(priority=2,description = "To verify user not able to SignIn with invalid credentials")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:To verify user not able to SignIn with Invalid Credentials")
	@Story("Story Name: To check user not able to SignIn with invalid credentials")
	public void invalidSignIn() {
		log.info("Browser open");
		driver.get(url);
		LoginPg.openSignIn().click();
		LoginPg.email().sendKeys(wrongname);
		LoginPg.Continue().click();
		String invalidemail = LoginPg.getInvalidEmailResponse().getText();
		if(invalidemail.contains("problem"))
		{
			Assert.assertFalse(true, "Try to login with invalid email/phonenumber");
			log.info("User try to login with invalid username");
			util.getScreenshotPath();
		}
		
	}	
	@AfterClass
	public void closeBrowser()
	{
		tearDown();
	}
}
