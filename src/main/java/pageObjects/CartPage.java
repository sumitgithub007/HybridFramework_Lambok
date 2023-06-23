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
 
	private By SonyXperiaMob = xpath("//*[text()='Sony xperia z5']");
 	private By name = cssSelector("#name");
	private By city = cssSelector("#city");
	private By country = cssSelector("#country");
	private By creditcard = cssSelector("#card");
	private By month = cssSelector("#month");
	private By year = cssSelector("#year");
	private By addtoCart = xpath("//*[text()='Add to cart']");
	private By purchaseItemButton = cssSelector("button[onclick='purchaseOrder()']");
	private By cartPageOpen = xpath("//*[text()='Cart']"); ///Change later text not good
	private By placeOrderbutton = xpath("//button[@data-target='#orderModal']");

}
