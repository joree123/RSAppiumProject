package firstProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AppiumDriverLocalService service;
	public AppiumDriver driver;
@BeforeClass
public void configureAppium() throws MalformedURLException
{
	service=new AppiumServiceBuilder().
			withAppiumJS(new File("C:\\Users\\daivi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress("127.0.0.1").usingPort(4723).build();
	service.start();
	UiAutomator2Options options=new UiAutomator2Options();
	options.setCapability("platformName","Android");//optional
	options.setCapability("platformVersion","12");
	options.setCapability("deviceName", "Samsung");

	
	//options.setAppPackage("com.salesforce.chatter");
	//options.setAppActivity("com.salesforce.chatter.activity.S1MainFragmentActivity");
	options.setApp("C:\\Users\\daivi\\eclipse-workspace1\\firstProject\\src\\main\\resources\\ApiDemos-debug.apk");

	driver=new AppiumDriver(new URL("http://127.0.0.1:4723"),options);
	//Activity salesForce=new Activity("com.salesforce.chatter", "com.salesforce.chatter.activity.S1MainFragmentActivity");
	
	


}

@AfterClass
public void tearDown()
{
	driver.quit();
	service.stop();
}

}
