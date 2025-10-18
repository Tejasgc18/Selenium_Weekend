package extentreports;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Tolearn_Screenshot {
	@Test
	public void addscreenshot()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://student.qspiders.com/");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		String photo = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML Reports/screenshotreport.html");
		
		ExtentReports ereports= new ExtentReports();
		
		ereports.attachReporter(spark);
		
		ExtentTest test = ereports.createTest("addscreenshot");
		
		test.log(Status.INFO,"Adding screenshot into report");
		test.addScreenCaptureFromBase64String(photo);//to view scrrenshot in their format
		
		ereports.flush();
	}

}
