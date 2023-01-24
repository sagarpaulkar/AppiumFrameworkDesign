package QA.AppiumFrameworkDesign;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import QA.AppiumFrameworkDesign.pageObjectsandroid.CartPage;
import QA.AppiumFrameworkDesign.pageObjectsandroid.FormPage;
import QA.AppiumFrameworkDesign.pageObjectsandroid.ProductCatalogue;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_Hybrid extends BaseTest{
@Test
public void fillForm() throws InterruptedException {
	
	FormPage formPage =new FormPage(driver);
		formPage.setNameField("Sagar");
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		ProductCatalogue productcatalogue= formPage.submitForm();
	
		productcatalogue.addItemToCartByIndex(0);		
		productcatalogue.addToCart("ADD TO CART");
		Thread.sleep(4000);		
		productcatalogue.addItemToCartByIndex(0);		
		CartPage cartpage =productcatalogue.goToCartPage();
		Thread.sleep(3000);
//		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		double totalSum= cartpage.getProductsSum();
		double displayFormattedSum= cartpage.getTotalSumDisplayed();
		Assert.assertEquals(totalSum, displayFormattedSum);
		cartpage.acceptTermsConditions();
		cartpage.submitOrder();
		}
}
