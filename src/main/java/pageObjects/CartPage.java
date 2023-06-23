package pageObjects;

import static org.openqa.selenium.By.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import lombok.Getter;


@Getter
public class CartPage extends basePage {
 
	private By placeOrder = xpath("//*[text()='Sony xperia z5']");
 	private By name = cssSelector("#name");
	private By city = cssSelector("#city");
	private By country = cssSelector("#country");
	private By creditcard = cssSelector("#card");
	private By month = cssSelector("#month");
	private By year = cssSelector("#year");
	private By AddtoCart = xpath("//*[text()='Add to cart']");
	private By purchaseitem = cssSelector("#purchaseitem");

}
