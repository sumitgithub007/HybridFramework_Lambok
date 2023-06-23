package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.Manager;
import static pageObjects.Manager.*;
import testcomponents.BaseFile;

public class PurchaseProductTest extends BaseFile {

	public WebDriver driver;// This driver object is Local to this class only
	//public Manager manager ;
	
	@BeforeMethod
	public void launchapplication()   {
		driver = launchApplication();// open the webpage of Application you mentioned in GlobalData File
	 
	
	}

	@Test
	public void signUpApplication()   {
		Click(gethomePage().getLoginModalOpen());
		Type(gethomePage().getLoginusername(), prop.getProperty("username")); // remove hardcode data later
		Type(gethomePage().getLoginpassword(), prop.getProperty("password"));
		Click(gethomePage().getLogin_button());

		refresh();
		Click(getCartPage().getPlaceOrder());
		Click(getCartPage().getAddtoCart());
		// Click(cartpage.get);

		Type(getCartPage().getName(), "sumit");
		Type(getCartPage().getCountry(), "India");
		Type(getCartPage().getCity(), "Gwalior");
		Type(getCartPage().getCreditcard(), "4018034566789090");
		Type(getCartPage().getMonth(), "August");
		Type(getCartPage().getYear(), "2023");
		Click(getCartPage().getPurchaseitem());
		//Type(cartpage.getCommonlogout(), "sumit");

	}

	@AfterMethod
	public void TearDown() {
		// driver.quit();
	}

}
