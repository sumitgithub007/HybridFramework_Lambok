package testcomponents;

 

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

 

public class BrowserFactory {
    private static BrowserFactory instance = null;

    public static BrowserFactory getInstance () {
        if (instance == null) {
            instance = new BrowserFactory ();
        }
        return instance;
    }

    ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver> ();

    private BrowserFactory () {

    }

    public WebDriver getDriver () {
        return webDriver.get ();
    }

    public final void setDriver (String browser) throws Exception {

        DesiredCapabilities caps = null;

        switch (browser) {

            case "chrome":
                WebDriverManager.chromedriver().setup ();
                webDriver.set (new ChromeDriver ());
        }
    }
}
