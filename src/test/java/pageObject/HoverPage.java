package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resource.Liberary;

public class HoverPage {

WebDriver driver;
Liberary li = new Liberary();
	
public HoverPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//div[@id='icon-farm-container']/div/div//div[2]/a") List<WebElement> benefits;

public List<WebElement> hoverBenefits()
{
	return benefits;
}

}
