
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;

import org.testng.annotations.Test;

public class NewTest extends TestBase {

	//Elements
	String nextButton ="com.sec.android.app.shealth:id/next_image";


	@Test
	public void basicTest () throws InterruptedException {
		//Click and pass Splash
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id(nextButton))).click();
		//Check Terms of use
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.sec.android.app.shealth:id/checkAgree_Terms"))).click();
		//Check Private Policy
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.sec.android.app.shealth:id/checkAgree_PP"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id(nextButton))).click();
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id(nextButton))).click();
		//Enter name
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.sec.android.app.shealth:id/profile_name"))).sendKeys("TienTran");
		//Choose gender
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.sec.android.app.shealth:id/male_icon"))).click();
		//Set birthday
		//wait.until(ExpectedConditions.visibilityOfElementLocated
		//		(By.id("android:id/numberpicker_input")));
		
		//Hide my profile
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.sec.android.app.shealth:id/use_ranking_checkbox"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id(nextButton))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id(nextButton))).click();
		//Choose actions
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.sec.android.app.shealth:id/lev3_radio_button"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id(nextButton))).click();
		//Click start
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id(nextButton))).click();
		
		String actualMsg = wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("com.sec.android.app.shealth:id/blank_dashboard"))).getText();
		String expectedMsg = "Be active and healthy!";
		
		Assert.assertEquals(actualMsg, expectedMsg, "The message is not displayed as expected");

	}

}
