package pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObjects.utils.AndroidActions;

public class CartPage extends AndroidActions {

	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='$160.97']")
	private WebElement amountOne;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='$120.0']")
	private WebElement amountTwo;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement termsConditions;
	
	@AndroidFindBy(id = "android:id/message")
	private WebElement termsText;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
	private WebElement termsClose;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")
	private WebElement checkBox;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement visitButton;
	
	String termsMessage = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";

	public void compareTotal() {

		double cartTotal = Double.parseDouble(totalAmount1.getText().substring(2));
	

		double lastPageTotal = Double.parseDouble(amountOne.getText().substring(1))
				+ Double.parseDouble(amountTwo.getText().substring(1));
		

		Assert.assertEquals(cartTotal, lastPageTotal);

	}
	
	public void handleTermsConditions() {
		longPressAction(termsConditions);
		Assert.assertEquals(termsText.getText(), termsMessage);
		termsClose.click();
		
	}
	
	public void confirmBuy() {
		checkBox.click();
		visitButton.click();
	}

}
