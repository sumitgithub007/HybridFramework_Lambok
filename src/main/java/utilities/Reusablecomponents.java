package utilities;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import enumPackage.WaitStrategy;
import static enumPackage.WaitStrategy.*;

public class Reusablecomponents {

	/*
	 * public WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(8));
	 * 
	 */
	public static WebDriver driver;
	public static WebDriverWait wait;

	public void setDriver(WebDriver driver, WebDriverWait waitnew) {
		Reusablecomponents.driver = driver;
		Reusablecomponents.wait = waitnew;
	}

	public WebElement getWebElement(By locator) {
		return driver.findElement(locator);
	}

	public WebElement getWebElement(WaitStrategy strategy, By locator) {
		wait(strategy, locator);
		return driver.findElement(locator);
	}

	public List<WebElement> getWebElements(By locator) {
		return driver.findElements(locator);
	}

	public static void wait(WaitStrategy strategy, By locator) {
		switch (strategy) {

		case VISIBLE:
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			break;

		case PRESENT:
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			break;

		default:
			// default statements
		}

	}

	/**
	 * @param accepts By locator.
	 * It will click locator
	 */
	public void Click(By by) {

		getWebElement(VISIBLE, by).click();

	}

	public void Type(By ele, String text) {

		getWebElement(VISIBLE, ele).sendKeys(text);
		

	}

	public boolean isAlertPresent()
	{

		 boolean foundAlert = false;
		    
		    try {
		        wait.until(ExpectedConditions.alertIsPresent());
		        foundAlert = true;
		    } catch (Exception eTO) {
		        foundAlert = false;
		    }
		    return foundAlert;
		
			
	}
	
	
	public void WaitandAcceptAlert()   {
		
		
	  if(isAlertPresent())
	  {
		  driver.switchTo().alert().accept();
	  }
		
		
		
		
		

	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void scrollDownPage() {

		 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)", "");

	}

}
