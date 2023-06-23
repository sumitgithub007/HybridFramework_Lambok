package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testcomponents.BaseFile;

public class LoginTest extends BaseFile{

	public HomePage homepage;
	public WebDriver driver;//This driver object is Local to this class only
	
	
  @BeforeMethod
  public void launchapplication()  
  {
	  driver=launchApplication();//open the webpage of Application you mentioned in GlobalData File
	  homepage = new HomePage(); //Initializing driver object of HomePage
	   
  }
	
	
	@Test
	public void LoginIntopApplication()  
	{
		Click(homepage.getLoginModalOpen());
		Type(homepage.getLoginusername(),prop.getProperty("username")); //remove hardcode data later
		Type(homepage.getLoginpassword(),prop.getProperty("password"));
		Click(homepage.getLogin_button());
		
	}
	
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
