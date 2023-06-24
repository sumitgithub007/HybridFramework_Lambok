package pageObjects;

import static org.openqa.selenium.By.*;

import org.openqa.selenium.By;
 
import lombok.Getter;

 
@Getter
public class HomePage  extends basePage  {

 	private By openSignUpModal = xpath("//*[starts-with(@id,'signin')]");
	private By usernamesignup = xpath("//input[@id='sign-username']");
	private By passwordsignup = xpath("//input[@id='sign-password']");
	private By signup_button = xpath("//div[@class='modal-footer'] //*[@onclick='register()']");
	private By loginModalOpen = xpath("//*[@id='login2']");
	private By loginusername = xpath("//input[@id='loginusername']");
	private By loginpassword = xpath("//input[@id='loginpassword']");
	private By login_button = xpath("//div[@class='modal-footer'] //*[@onclick='logIn()']");
	private By loginperson = id("nameofuser");
	private By cartclick =    xpath("//*[text()='Cart']");
	 
	
}
