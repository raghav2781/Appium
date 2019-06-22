package Runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;

import com.cucumber.listener.Reporter;

import ProjectUtility.BaseClass;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/FeatureFiles", glue = { "stepDefination" }, tags = { "@tag2" }, plugin = {

		"com.cucumber.listener.ExtentCucumberFormatter:Results/ExtentReports/Report.html" })
public class TestRunner {

	@AfterClass
	public static void AfterClass() {
		Reporter.loadXMLConfig("C:\\Users\\sudeeprana\\workspace\\Assignment\\config\\extentConfig.xml");
		  Reporter.setSystemInfo("User Name", System.getProperty("user.name"));

	        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));

	        Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");

	        Reporter.setSystemInfo("Selenium", "3.141.59");

	        Reporter.setSystemInfo("Maven", "3.3.9");

	        Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}

}
