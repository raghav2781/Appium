package ProjectUtility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseClass {
	public static WebDriverWait wait;

	public static AppiumDriver<MobileElement> driver;

	public static DesiredCapabilities setcap() throws FileNotFoundException, IOException {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("platformName", ReadProperties.getValue("platformName"));

		cap.setCapability("platformVersion", ReadProperties.getValue("platformVersion"));

		cap.setCapability("deviceName", ReadProperties.getValue("deviceName"));

		cap.setCapability("udid", ReadProperties.getValue("udid"));

		cap.setCapability("appPackage", ReadProperties.getValue("appPackage"));

		cap.setCapability("appActivity", ReadProperties.getValue("appActivity"));

		cap.setCapability("noReset",Boolean.valueOf( ReadProperties.getValue("noReset")));

		cap.setCapability("clearSystemFiles", Boolean.valueOf( ReadProperties.getValue("clearSystemFiles")));
		

		return cap;
	}

	public static void openApplication() throws FileNotFoundException, IOException {
		try {
			driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), setcap());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		wait = new WebDriverWait(driver, 10);
		
	}
	
	public static void closeDriver(){
		driver.quit();
	}
	
}
