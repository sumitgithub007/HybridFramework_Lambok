package testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import utilities.Reusablecomponents;

public class BaseFile extends Reusablecomponents    {

	
	public static WebDriver basedriver;
	public FileInputStream fis;
	public Properties prop;
	public String browserName;
	public String applicationURL;
	public Reusablecomponents reusablecomp;
	public WebDriverWait wait= null;

	 
	@SneakyThrows
	public void initializeDriver()   {
		// Global Properties file Path
		try
		{
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\GlobalData.properties";

		fis = new FileInputStream(path);
		prop = new Properties();
		prop.load(fis);
		browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			  WebDriverManager.chromedriver().setup();
			  basedriver =new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  basedriver=new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			 WebDriverManager.edgedriver().setup();
			 basedriver=new EdgeDriver();
		}

	//basedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		basedriver.manage().window().maximize();
	 wait=	new WebDriverWait(basedriver,Duration.ofSeconds(8));
		}
		catch(Exception e)
		{
			// laterlogger
		}
		
		
		}

	@SneakyThrows
	public WebDriver launchApplication()   {
      
		
		initializeDriver(); //This will initialize driver object
		set_reusablecomponentdriver();
		applicationURL = prop.getProperty("url");
		basedriver.get(applicationURL);
		return basedriver;
		 
		
	}
	
	public WebDriver getDriverObject()
	{
		return basedriver;
	}
	
	
	
	public void set_reusablecomponentdriver()
	{
		 new Reusablecomponents().setDriver(basedriver,wait);
		 
	}
	
	 

}
