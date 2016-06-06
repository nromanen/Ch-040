package atqc.hospital;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	public BrowserWrapper browserActions;

	public static final String loginUrl = "http://localhost:8080/hospital/login" ;
	public static final String registerUrl = "http://localhost:8080/hospital/newUser";
	public static final String homeUrl = "http://localhost:8080/hospital/";
	
	@BeforeMethod
	public void beforeMethod(){
		browserActions = new BrowserWrapper (new FirefoxDriver());
		browserActions.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
}
