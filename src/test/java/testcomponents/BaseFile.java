package testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import utilities.Reusablecomponents;

public class BaseFile extends Reusablecomponents    {

	
	public  WebDriver basedriver;
	public FileInputStream fis;
	public Properties prop;
	public String browserName;
	public String applicationURL;
	public Reusablecomponents reusablecomp;
	public WebDriverWait wait= null;
	//public  static   ThreadLocal<WebDriver> basedriver = new ThreadLocal<WebDriver>();
	 
	/**
	 * method to set globalData file path and instantiate the desired browser 
	 */
	@SneakyThrows
	public void initializeDriver()   {
		 
		try
		{
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\GlobalData.properties";

		fis = new FileInputStream(path);
		prop = new Properties();
		prop.load(fis);
		browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			  WebDriverManager.chromedriver().setup();
			  //basedriver.set(new ChromeDriver());
			  basedriver=new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		 
		  //basedriver=new FirefoxDriver());
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			 WebDriverManager.edgedriver().setup();
			 //basedriver.set(new EdgeDriver());
		}

	//basedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		//basedriver.get().set(driver);
		basedriver.manage().window().maximize();
	   wait=	new WebDriverWait(basedriver,Duration.ofSeconds(10));
		}
		catch(Exception e)
		{
			// laterlogger
		}
		
		
		}

	/**This method launch webpage,hit url and 
	 * return the driver object 
	 * @return basedriver
	 */
	@SneakyThrows
	public WebDriver launchApplication(WebDriver driver)   {
      
		/* driver=browserFactory.getDriver(); */
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\GlobalData.properties";
		System.out.println(driver);
		fis = new FileInputStream(path);
		prop = new Properties();
		prop.load(fis);
		 wait=	new WebDriverWait(driver,Duration.ofSeconds(10));
		//initializeDriver();
		setDriverWaits(driver);
		applicationURL = prop.getProperty("url");
		driver.get(applicationURL);
		return driver;
		 
		
	}
	
	public WebDriver getDriverObject()
	{
		return basedriver;
	}
	
	
	
	/**
	 * This method will initialize the driver object and waits
	 * in ReusableComponents class
	 */
	public void setDriverWaits(WebDriver driver)
	{
		 new Reusablecomponents().setDriver(driver,wait);
		 
		 
	}
	
	/**Take the screenshot place it in report folder and return the path of the screenshot
	 * @param testCaseName
	 * @return
	 */
	@SneakyThrows
	public String getScreenshot(String testCaseName)
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File newfile = new File(System.getProperty("user.dir")+"//reports//" +testCaseName + ".png");
		FileUtils.copyFile(source, newfile);
		return System.getProperty("user.dir")+"//reports//" +testCaseName + ".png";
		
	
	}
	
	

}
