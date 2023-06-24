package testcases;

import static pageObjects.Manager.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lombok.SneakyThrows;
import pageObjects.HomePage;
import pageObjects.Manager;
import testcomponents.BaseFile;
import testcomponents.BrowserFactory;
 

public class LoginTest extends BaseFile{
	public BrowserFactory browserFactory ;
	public WebDriver driver;//This driver object is Local to this class only
	Manager manager ;
	
	public HomePage gethomePage()
	{
		return manager.gethomePage();
	}
	
	
  @BeforeMethod
  @SneakyThrows
  public void launchWebsite()  
  {
	  manager=new Manager();
		browserFactory = BrowserFactory.getInstance();
		browserFactory.setDriver("chrome");
		driver = browserFactory.getDriver();
		launchApplication(driver);
  }
	
	
	@Test
	public void LoginIntopApplication()  
	{
		  System.out.println("start method Login---");
		Click(gethomePage().getLoginModalOpen());
		Type(gethomePage().getLoginusername(),prop.getProperty("username")); //remove hardcode data later
		Type(gethomePage().getLoginpassword(),prop.getProperty("password"));
		Click(gethomePage().getLogin_button());
		Validation(gethomePage().getLoginperson(), "Welcome"+" "+prop.getProperty("username"));
	}
	
	
	@AfterMethod
	public void TearDown()
	{
		browserFactory.getDriver().quit();
	}
	
	
	
	
	
	
	
	
}
