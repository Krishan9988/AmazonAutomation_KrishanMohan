package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;
public ExtentReports getExtendReport()
{
	String extentPath = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter extentReport = new ExtentSparkReporter(extentPath);
	extentReport.config().setReportName("Automation Report");
	extentReport.config().setDocumentTitle("Training");
	
	extent = new ExtentReports();
	extent.attachReporter(extentReport);
	extent.setSystemInfo("Tester", "Ricky");
	return extent;
}
}
