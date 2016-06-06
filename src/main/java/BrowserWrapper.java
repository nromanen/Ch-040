import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserWrapper {

    protected WebDriver driver;

    public static String homeUrl = "http://91.209.24.68";
    public static String doctorPageUrl = "http://91.209.24.68/hospital/1/department/1";


    BrowserWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void goTo(String url) {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void resize(int width, int height) {
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public boolean isElementPresentByXpath(String xpath) {
        boolean present;
        try {
            driver.findElement(By.xpath(xpath));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        return present;
    }

    public boolean isElementPresentByClassName(String className) {
        boolean present;
        try {
            driver.findElement(By.className(className));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        return present;
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public void browserBack() {
        sleep();
        driver.navigate().back();
    }

    public void sleep() {
        WebDriverWait sleeper = new WebDriverWait(getDriver(), 10);
    }
}

