package pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObjects.utils.AndroidActions;

public class ProductCatalogue extends AndroidActions {

	AndroidDriver driver;

	public ProductCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[1]")
	private WebElement addToCart1;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[2]")
	private WebElement addToCart2;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']")
	private WebElement openCart;
	
	public CartPage addAndOpenCart() {
		addToCart1.click();
		addToCart2.click();
		openCart.click();
		
		return new CartPage(driver);

	}
}
