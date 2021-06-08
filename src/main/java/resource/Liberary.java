package resource;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Liberary extends BaseClass {
	
	public List<WebElement> explicitWaitList(List<WebElement> element)
	{
	List<WebElement> wait = new WebDriverWait(getDriver(),10).until(ExpectedConditions.visibilityOfAllElements(element));
		
	return element;
	}
	
	public WebElement explicitWait(WebElement element)
	{
	WebElement wait = new WebDriverWait(getDriver(),10).until(ExpectedConditions.visibilityOf(element));
		
	return element;
	}
	
	public WebElement explicitWaitClickable(WebElement element)
	{
	WebElement wait = new WebDriverWait(getDriver(),10).until(ExpectedConditions.elementToBeClickable(element));
		
	return element;
	}
	public void jsExecuteScrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void jsExecuteScrollBottom()
	{
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void windowHandlesChild()
	{
		Set<String> windowHandle= getDriver().getWindowHandles();
		Iterator<String> it= windowHandle.iterator();
		 String parentWindow = it.next();
		 String childWindow = it.next();
		 getDriver().switchTo().window(childWindow);
	}
	
	public void windowHandlesParent()
	{
		Set<String> windowHandle= getDriver().getWindowHandles();
		Iterator<String> it= windowHandle.iterator();
		 String parentWindow = it.next();
		 getDriver().switchTo().window(parentWindow);
	}
	
	public void selectValueFromDropDown(WebElement element,String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void mouseHover(WebElement element)
	{
		Actions a = new Actions(getDriver());
		a.moveToElement(element).build().perform();	
	}
	
	public String decodestring(String password)
	{
		byte[] decodedString = Base64.decodeBase64(password.getBytes());
		return(new String(decodedString));	
	}
}
