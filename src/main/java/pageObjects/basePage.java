package pageObjects;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lombok.Getter;

@Getter
public class basePage {

	public WebDriver driver ;
	
     //future  common locators like header information
	//footer button
	//logout button same gape
	private By commonlogout = xpath("id=logout"); 
 
	
	
}
