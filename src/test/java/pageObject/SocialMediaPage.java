package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class SocialMediaPage {

	
	WebDriver driver;
	
	public SocialMediaPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='tell-a-friend']/div/a") List<WebElement> socialMediaLink;
	
	@Step("To get title and url of social media link")
	public List<WebElement> getSocialMediaLink()
	{
		return socialMediaLink;
	}
}
