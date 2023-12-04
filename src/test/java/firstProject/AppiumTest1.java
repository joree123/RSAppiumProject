package firstProject;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
public class AppiumTest1 extends BaseTest {

	@Test
	   public void launchApp() throws MalformedURLException, InterruptedException
	   {
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("Joree wifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		Thread.sleep(2000);
		//driver.executeScript("mobile: terminateApp",ImmutableMap.of("appId",""));
		((JavascriptExecutor)driver).executeScript("mobile:startActivity", ImmutableMap.of("intent","com.android.vending/.AssetBrowserActivity"));
		Thread.sleep(2000);
	   }
}	
	
	
	
	
	


