package pageObjects.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver) {
		this.driver= driver;
	}

	public void longPressAction(WebElement item) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) item).getId(), "duration", 2000));
	}

	public void scrollToElement(String scrollTo) {
		
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(" + scrollTo + "))"));
		
	}

	public void keepScrolling() {
		boolean canScrollMore = true;

		// when you just want to scroll up or down
		while (canScrollMore) {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		}
	}
	
	public void swipeLeftToElement(WebElement firstImage, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)firstImage).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
}
