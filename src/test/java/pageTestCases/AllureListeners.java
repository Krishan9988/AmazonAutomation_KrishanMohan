package pageTestCases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Attachment;
import resource.BaseClass;

public class AllureListeners implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	//For taking screenshot
	@Attachment(value = "Page Screenshot", type = "image/png")
	public byte[] saveFailureScreenShot(WebDriver driver)
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	// Text Attachment for Allure
	@Attachment(value = "{0}", type= "text/plain")
public static String saveTextLog(String message)
{
		return message;
}

	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in onStart Method " + iTestContext.getName());
		 iTestContext.setAttribute("WebDriver", BaseClass.getDriver());

	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish Method " + iTestContext.getName());

	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in onTestStart Method " + getTestMethodName(iTestResult) + "start");

	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess Method " + getTestMethodName(iTestResult) + "succeed");

	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure Method " + getTestMethodName(iTestResult) + "failed");
Object testClass = iTestResult.getInstance();
WebDriver driver = BaseClass.getDriver();
if(driver instanceof WebDriver)
{
	System.out.println("Screenshot captured for Test Case :" +  getTestMethodName(iTestResult));
	saveFailureScreenShot(driver);
}

saveTextLog(getTestMethodName(iTestResult) + "Failed and screenshot Taken!");
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped Method " + getTestMethodName(iTestResult) + "skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("I am in onTestFailedButWithinSuccessPercentage Method " + getTestMethodName(iTestResult)
				+ "Failed with in Success Percentage");

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult iTestResult) {
		System.out.println(
				"I am in onTestFailedWithTimeout Method " + getTestMethodName(iTestResult) + "falied with timeout");

	}

}
