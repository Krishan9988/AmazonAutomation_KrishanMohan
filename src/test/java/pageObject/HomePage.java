package pageObject;

import java.util.List;

import org.apache.commons.io.FileSystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import resource.BaseClass;
import resource.Liberary;

public class HomePage {

	WebDriver driver;
	Liberary li = new Liberary();
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="nav-search-submit-button") private WebElement searchBox;
	@FindBy(id="twotabsearchtextbox") WebElement searchTextBox;
	@FindBy(xpath="//div[contains(@id,'issDiv')]") List<WebElement> suggestedItems;
	@FindBy(xpath="//span[contains(text(),'Echo')]") List<WebElement> searchedItemsResult;
	@FindBy(id="nav-hamburger-menu") WebElement allMenu;
	@FindBy(xpath="//div[text()='TV, Appliances, Electronics']") WebElement optionTVApp;
	@FindBy(xpath="//a[text()='DSLR Cameras']") WebElement optionDSLRCameras;
	@FindBy(xpath="//a[@class='a-link-normal octopus-pc-item-link']") List<WebElement> camerasResult;
	
	@Step("Click on Search Button")
	public WebElement btnSearchBox()
	{
		return searchBox;
	}
	
	@Step("Method for Entering data in Search Text Box")
	public WebElement txtSearchBox()
	{
		return searchTextBox;
	}
	
	
	
	@Step("Method for getting Suggested Items")
	public List<WebElement> getSuggestedItems()
	{
		List<WebElement> suggestedList = suggestedItems;
//		for(int i=0;i<suggestedList.size();i++)
//		{
//		suggestedList.get(i).getText();
//		}
		return suggestedList;	
	}
	
	@Step("To see searched items list")
	public List<WebElement> getSearchedItemsList()
	{
		List<WebElement> searchedList = searchedItemsResult;
//		for(int i=0;i<suggestedList.size();i++)
//		{
//		suggestedList.get(i).getText();
//		}
		return searchedList;	
	}
	
	@Step("Method to click on All menu button")
	public WebElement btnAllMenu()
	{
		return allMenu;
	}
	
	@Step("Method to click on TV Application option")
	public WebElement optTVAPP()
	{
		return li.explicitWait(optionTVApp);
	}
	
	@Step("Method to click on DSLR Cameras Option")
	public WebElement optDSLRCameras()
	{
		return li.explicitWait(optionDSLRCameras);
	}
	
	@Step("To see searched items list of Cameras")
	public List<WebElement> getCamerasItemsList()
	{
		List<WebElement> camerasList = camerasResult;
//		for(int i=0;i<suggestedList.size();i++)
//		{
//		suggestedList.get(i).getText();
//		}
		return camerasList;	
	}
}
