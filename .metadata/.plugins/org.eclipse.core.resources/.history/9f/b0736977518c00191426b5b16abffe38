package com.logigear.testfw.common;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.logging.Logger;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.logigear.testfw.conf.DriverConfig;
import com.logigear.testfw.conf.LogWrapper;
import com.logigear.testfw.driver.BaseDriver;
import com.logigear.testfw.driver.DriverManager;

/**
 * 
 * @author ngocquang.tran
 *
 */
public class BaseTest {
	protected static final Logger LOG = LogWrapper.createLogger(BaseTest.class.getName());
	
	@Parameters({ "environment" })
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(String browser, Method method, ITestContext context) throws Throwable {
		
		try {
			TestExecutor.getInstance().initialize(context);
			
			if(TestExecutor.getInstance().isMobileTesting() == false) {
				// open browser and navigate to startup URL
				DriverConfig drvConfig = TestExecutor.getInstance().getDriverConfig();
				
				if(drvConfig != null && drvConfig.hasProperty(DriverConfig.KEY_STARTUP_URL))
				{
					String startupURL = drvConfig.getProperty(DriverConfig.KEY_STARTUP_URL);
					TestExecutor.getInstance().getCurrentDriver().get(startupURL);
				}
			}
			
		} catch (Exception e) {
		    LOG.warning(e.toString());
		}
	}
	
	
	@AfterMethod(alwaysRun = true)
	 public void cleanUp(ITestResult result) 
	{
		Collection<BaseDriver> drivers = DriverManager.getInstance().getAllDrivers();
		for(BaseDriver driver : drivers) {
			try {
				driver.quit();
			}
			catch (Exception e) {
				e.printStackTrace();
		    }
		}
	}
	
	
}
