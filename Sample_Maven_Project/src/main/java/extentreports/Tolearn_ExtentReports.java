package extentreports;


import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Tolearn_ExtentReports {

	@Test
public void createReport()
{
	String time = LocalDateTime.now().toString().replace(":", "-");//timestamp created >converted to tostring> then replacing : with - bcz report doesn't expect :
		
		//Step1: create ExtentSparkReporter object
ExtentSparkReporter spark= new ExtentSparkReporter("./HTML Reports/ExtentReports_"+time+".html");//time=added timestamp-line no18

//Step2: Create Extent Reports object
ExtentReports ereports=new ExtentReports();

// Step3: attach ExtentSparkReporter object to Extent Reports object
ereports.attachReporter(spark);

//Step4: Create Externaltest object abstract class we can't create object directly using helper method create testE creating an object
ExtentTest test = ereports.createTest("createReport");

//Step5: call log(Status,"message")
test.log(Status.PASS, "message added into report");

//call flush()
ereports.flush();
}
}
