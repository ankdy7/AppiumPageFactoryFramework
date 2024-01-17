package pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObjects.utils.AndroidActions;

public class FormPage extends AndroidActions {

	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// using private to achieve encapsualtion, so that test classes cannot access this webelements directy
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']")
	private WebElement nameField;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement genderFemale;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement genderMale;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;

	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement selectCountry;

	public void selectCountry(String name) {
		selectCountry.click();
		scrollToElement(name);
		System.out.println("start");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+name+"']")).click();
		System.out.println("end");

	}

	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}

	public void selectGender(String gender) {

		if (gender.equals("female")) {
			genderFemale.click();
		} else
			genderMale.click();
	}

	public ProductCatalogue clickShopButton() {
		shopButton.click();
		return new ProductCatalogue(driver);
	}

	

}
