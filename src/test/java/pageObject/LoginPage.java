package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import resource.Liberary;

public class LoginPage {

	WebDriver driver;
	Liberary li = new Liberary();
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[contains(@id,'nav-link-accountList')]") WebElement helloSignIn;
	@FindBy(css="input[name='email']") WebElement email;
	@FindBy(css="input[id='continue']") WebElement Continue;
	@FindBy(css="input[id='ap_password']") WebElement password;
	@FindBy(css="input[id='signInSubmit']") WebElement signIn;
	@FindBy(css="span[id='nav-link-accountList-nav-line-1']") WebElement signInUserText;
	@FindBy(xpath="//span[text()='Sign Out']") WebElement signOut;
	@FindBy(id="auth-error-message-box") WebElement invalidEmail;
	
	@Step("Method to open Signin form")
	public WebElement openSignIn()
	{
		return helloSignIn;
	}
	
	@Step("Method to enter email or mobile no")
	public WebElement email()
	{
		return email;
	}
	
	@Step("Method to click on Continue")
	public WebElement Continue()
	{
		return Continue;
	}
	@Step("Method to enter password")
	public WebElement password()
	{
		return password;
	}
	
	@Step("Method to click on SignIn")
	public WebElement btnSignIn()
	{
		return signIn;
	}
	
	@Step("Method to get login user text")
	public WebElement getSignInUserName()
	{
		return signInUserText;
	}
	
	@Step("Method to Signout")
	public WebElement btnSignOut()
	{
		return signOut;
	}
	@Step("Method to show invalid email response")
	public WebElement getInvalidEmailResponse()
	{
		return invalidEmail;
	}
}
