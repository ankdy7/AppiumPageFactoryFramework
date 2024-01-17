package pageTests.android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pageObjects.android.FormPage;

public class BaseTest {
	// global variables
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public FormPage formPage;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		

		// start appium server automatically
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\Dank\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		// define where appium starts
		URL url = new URL("http://127.0.0.1:4723/");
		// driver responsible for automation
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("DankPhone");
		options.setChromedriverExecutable(
				"C:\\Users\\Dank\\git\\AppiumFramework\\AppiumFramework\\src\\test\\java\\Resources\\chromedriver.exe");

		options.setApp(
				// "C:\\Users\\Dank\\Downloads\\eclipse-workspace-20240102T221256Z-001\\eclipse-workspace\\AppiumTest\\src\\test\\java\\Resources\\ApiDemos-debug.apk");
				"C:\\Users\\Dank\\git\\AppiumFramework\\AppiumFramework\\src\\test\\java\\Resources\\General-Store.apk");
		driver = new AndroidDriver(url, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		formPage = new FormPage(driver);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
