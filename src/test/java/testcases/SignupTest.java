package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lombok.SneakyThrows;
import pageObjects.HomePage;
import pageObjects.Manager;
import testcomponents.BaseFile;
import testcomponents.BrowserFactory;


 
public class SignupTest extends BaseFile {
	Manager manager;
	
	
	public HomePage gethomePage()
	{
		return manager.gethomePage();
	}
	/**
	 * driver object for current class
	 */
	public WebDriver driver;
	public BrowserFactory browserFactory ;
	
  @BeforeMethod
  @SneakyThrows
  public void launchWebsite() throws IOException
  {
	   manager=new Manager();
		browserFactory = BrowserFactory.getInstance();
		browserFactory.setDriver("chrome");
		driver = browserFactory.getDriver();
		launchApplication(driver);
	    
  }
	
	
	@Test
	public void signUpApplication() throws IOException, InterruptedException
	{
		Click(gethomePage().getOpenSignUpModal());
		Type(gethomePage().getUsernamesignup(),prop.getProperty("username")); //remove hardcode data later
		Type(gethomePage().getPasswordsignup(),prop.getProperty("password"));
		Click(gethomePage().getSignup_button());
		WaitandAcceptAlert();
	}
	
	
	@AfterClass
	public void TearDown()
	{
		browserFactory.getDriver().quit();
	}
	
	
	
	
	
	
	
}
