package hospitalSeeker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Alex on 6/14/2016.
 */
public class BrowserInitialization {

    public static WebDriver initialize() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = BrowserInitialization.class.getResourceAsStream("/app.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String browserType = properties.getProperty("browserType");
        String driverType = properties.getProperty("driverType");
        String driverPath = properties.getProperty("driverPath");

        switch (browserType) {
            case "firefox" :
//                System.setProperty(driverType, driverPath);
                return new FirefoxDriver();
            case "chrome" :
                System.setProperty(driverType, driverPath);
                return new ChromeDriver();
            case "firefoxLinux" :
                System.setProperty(driverType, driverPath);
                return new MarionetteDriver();
            case "chromeLinux" :
                System.setProperty(driverType, driverPath);
                return new ChromeDriver();
            case "internetExplorer" :
                System.setProperty(driverType, driverPath);
                return new InternetExplorerDriver();
            default:
                System.out.println(browserType + " is invalid");
                break;
        } return null;
    }
}
