package vidhyaPrakashAutomation.ExtentResort;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTestNG {

	public static ExtentReports getReportObjest() {
		// String reportPath = System.getProperty("user.dir")+"\\reports\\index.html";
		String reportPath = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Amazon Test Report");
		reporter.config().setDocumentTitle("Test Results");
		ExtentReports extent;
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "vidhya Prakash B");
//		extent.createTest(reportPath);
		return extent;
	}
}
