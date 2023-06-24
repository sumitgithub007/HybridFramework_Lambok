package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lombok.SneakyThrows;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.Manager;
import testcomponents.BaseFile;
import testcomponents.BrowserFactory;

public class PurchaseProductTest extends BaseFile {
	public BrowserFactory browserFactory ;

	public WebDriver driver;

	Manager manager ;
	
	public HomePage gethomePage()
	{
		return manager.gethomePage();
	}
	

	public CartPage getCartPage()
	{
		return manager.getCartPage();
	}
	
	
	@BeforeClass
	@SneakyThrows
	public void launchWebsite() {

		manager=new Manager();
		
		browserFactory = BrowserFactory.getInstance();
		browserFactory.setDriver("chrome");
		driver = browserFactory.getDriver();
		launchApplication(driver);

	}

	@Test
	public void loginwebapp() {
		Click(gethomePage().getLoginModalOpen());
		Type(gethomePage().getLoginusername(), prop.getProperty("username")); // remove hardcode data later
		Type(gethomePage().getLoginpassword(), prop.getProperty("password"));
		Click(gethomePage().getLogin_button());
		Validation(gethomePage().getLoginperson(), "Welcome" + " " + prop.getProperty("username"));
		refresh();

	}

	@Test(dependsOnMethods = { "loginwebapp" })
	public void purchaseProductFromWebsite() {

		Click(getCartPage().getSonyXperiaMob());
		Click(getCartPage().getAddtoCart());
		WaitandAcceptAlert();

		Click(getCartPage().getCartPageOpen());
		Click(getCartPage().getPlaceOrderbutton());

		Type(getCartPage().getName(), "sumit");
		Type(getCartPage().getCountry(), "India");
		Type(getCartPage().getCity(), "Gwalior");
		Type(getCartPage().getCreditcard(), "4018034566789090");
		Type(getCartPage().getMonth(), "August");
		Type(getCartPage().getYear(), "2023");

		Click(getCartPage().getPurchaseItemButton());

		// Type(cartpage.getCommonlogout(), "sumit");

	}

	@AfterClass
	public void TearDown() {
		browserFactory.getDriver().quit();

	}

}
