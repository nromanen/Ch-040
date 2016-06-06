package atqc.hospital;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserWrapper {
	
    
	protected WebDriver driver;
	
	public BrowserWrapper(WebDriver driver) {
        this.driver = driver;
    }

	public void goTo(String Url){
		driver.get(Url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }
	
	public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
	
	public WebDriver getDriver(){
		return driver;
	}
	
    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean containsText(String Text){
    	if(driver.findElement(By.tagName("body")).getText().contains(Text)){
    		return true;
    	} else 
    		return false;
    		
    }
	
}
