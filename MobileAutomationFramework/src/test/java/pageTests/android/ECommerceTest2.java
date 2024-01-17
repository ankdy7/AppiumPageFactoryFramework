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

public class ECommerceTest2 extends BaseTest {

	@Test
	public void fillForm() throws InterruptedException {
		double sum = 0.0;
		

		// formPage.selectCountry("\""+"Angola"+"\"");
		formPage.setNameField("Ankur Dey");
		formPage.selectGender("female");
		ProductCatalogue productCatalogue = formPage.clickShopButton();
		CartPage cartPage = productCatalogue.addAndOpenCart();
		cartPage.compareTotal();
		cartPage.handleTermsConditions();
		cartPage.confirmBuy();
		

	}
}
