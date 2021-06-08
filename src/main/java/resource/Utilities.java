package resource;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Utilities extends BaseClass {

	public static Logger log = LogManager.getLogger(Utilities.class.getName());
	public String getScreenshotPath()
	{
	File source = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	String destinationfile = System.getProperty("user.dir")+"\\reports\\Test.jpg";
	
	
	try {
		FileUtils.copyFile(source, new File(destinationfile));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return destinationfile;
	}
	
	public String getUploadFile(String filepath) throws AWTException, InterruptedException
	{
	//	this.driver=getDriver();
		Robot robot = new Robot();
	//	getDriver().get(imageurl);
		getDriver().findElement(By.xpath("//div[@class='home-buttons']/a")).click();

		robot.setAutoDelay(1000);

		// To copy file path on window popup
	//	filepath = "C:\\Users\\ricky\\Downloads\\Console.jpg";
		StringSelection stringselection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard()
				.setContents(stringselection, null);

		//
		robot.setAutoDelay(1000);
		// For pasting text
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		// for pressing Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.setAutoDelay(1000);

		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//button[text()='Upload']")).click();

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By
				.xpath("//div[text()='Upload complete']"))));
		String successmsg = getDriver().findElement(
				By.xpath("//div[text()='Upload complete']")).getText();
		log.info(successmsg);
return filepath;
	}
}
