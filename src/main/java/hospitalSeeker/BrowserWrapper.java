package hospitalSeeker;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserWrapper {

    protected WebDriver driver;

    public static final int STANDARD_WAIT_TIME = 10;

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

    public boolean containsText(String text) {
        if (driver.getPageSource().contains(text)) {
            return true;
        } else {
            return false;
        }
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

    public String checkIfElementNotPresent(WebElement element) {
        try {
            element.isDisplayed();
            return "";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public void doubleClick(WebElement element) {
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void browserBack() {
        driver.navigate().back();
    }

    public void implicitWait(int sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public void waitUntilAlertIsPresent() {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.alertIsPresent());
    }

    public void waitUntilElementSelectionState(WebElement element, boolean bool) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.elementSelectionStateToBe(element, bool));
    }

    public void waitUntilElementClickable(WebElement element) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementSelected(WebElement element) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.elementToBeSelected(element));
    }

    public void waitUntilElementVisible(WebElement element) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementInvisible(By locator) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitUntilTitleContains(String title) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.titleContains(title));
    }

    public void waitUntilAllVisible(List<WebElement> elements) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitUntilElementIsPresent(By locator) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitUntilUrlToBe(String url) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.urlToBe(url));
    }

    public void selectDropdown(WebElement element, String text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    public void sleep(int Seconds){
        try {
            Thread.sleep(Seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void browserMaximize() {
        driver.manage().window().maximize();
    }
}

