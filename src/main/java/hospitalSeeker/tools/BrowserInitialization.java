package hospitalSeeker.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
            case "firefox":
                return new FirefoxDriver();
            case "chrome":
                System.setProperty(driverType, driverPath);
                return new ChromeDriver();
            case "firefoxLinux":
                return new FirefoxDriver();
            case "chromeLinux":
                System.setProperty(driverType, driverPath);
                return new ChromeDriver();
            case "internetExplorer":
                System.setProperty(driverType, driverPath);
                return new InternetExplorerDriver();
            default:
                System.out.println(browserType + " is invalid");
                break;
        }
        return null;
    }
}
