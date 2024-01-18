package pageTests.android;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.chromium.ChromiumDriver;
import pageObjects.android.CartPage;
import pageObjects.android.FormPage;
import pageObjects.android.ProductCatalogue;

public class ECommerceTest1 extends BaseTest {

	@Test
	public void negativeFlow() throws InterruptedException {
//		driver.findElement(
//				By.xpath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']"))
//				.sendKeys("Ankur Dey");
		//driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
//		driver.findElement(
//				By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Azerbaijan']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name"),
				"Please enter your name");
	}
	
	@Test
	public void positiveFlow() throws InterruptedException {
		driver.findElement(
				By.xpath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']"))
				.sendKeys("Ankur Dey");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
//		driver.findElement(
//				By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Azerbaijan']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		Assert.assertFalse(driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name"),
				"Please enter your name");
	}
	
}
