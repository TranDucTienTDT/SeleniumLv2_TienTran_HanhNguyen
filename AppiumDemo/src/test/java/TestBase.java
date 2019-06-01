import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TestBase {

	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;


	@BeforeMethod
	public void setup () throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Android");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.sec.android.app.shealth");
		caps.setCapability("appActivity","com.sec.android.app.shealth.SplashScreenActivity");
		caps.setCapability("automationName", "UiAutomator2");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
		wait = new WebDriverWait(driver, 10);
	}

	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
