package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import resource.Liberary;

public class FooterLinksPage {

	
	WebDriver driver;
	Liberary li = new Liberary();
	public FooterLinksPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'navFooterVerticalRow')]") WebElement footerlinks;
	@FindBy(xpath="(//div[contains(@class,'navFooterLine navFooterLinkLine')])[2]") WebElement footerCountries;
	@Step("To get all links of footer")
	public WebElement getFooterlinks()
	{
		return footerlinks;
	}
	
	@Step("To get Name of Countries present in footer")
	public List<WebElement> getCountriesName()
	{
		return footerCountries.findElements(By.tagName("a"));
		
	}
 }
