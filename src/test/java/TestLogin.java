package atqc.hospital;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;

public class TestLogin extends BaseTest{
	
	LoginPage loginPage;
	DropdownLogin dropdownLogin;
	
	@BeforeMethod
	public void beforeMethod(){
		super.beforeMethod();
		loginPage = PageFactory.initElements(browserActions.getDriver(), LoginPage.class);
		dropdownLogin = PageFactory.initElements(browserActions.getDriver(), DropdownLogin.class);
	}
	

	  @Test(priority=0)
	    public void checkElementsLoginPage() {
	        browserActions.goTo(loginUrl);
	        Assert.assertTrue(browserActions.isElementPresent(loginPage.emailLogin));
	        Assert.assertTrue(browserActions.isElementPresent(loginPage.passwordLogin));
	        Assert.assertTrue(browserActions.isElementPresent(loginPage.rememberMe));
	        Assert.assertTrue(browserActions.isElementPresent(loginPage.loginButton));
	        Assert.assertTrue(browserActions.isElementPresent(loginPage.homeButton));
	    }
	  
	/*Correct log in
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"*/
	@Test(priority=1, dependsOnMethods={"checkElementsLoginPage"})
	public void testLogin(){
		loginPage.goTo(loginUrl);
		loginPage.emailLogin.sendKeys("nadja_cv@mail.ru");
		loginPage.passwordLogin.sendKeys("perekuta96");
		loginPage.loginButton.click();
		Assert.assertTrue(loginPage.containsText("@"));
	}
	
	/*Correct log in
	 * go to login page
	 * inut e-mail
	 * input password
	 * click on button "Log in"*/
	@Test(priority=2, dependsOnMethods={"checkElementsLoginPage"})
	public void testLoginHomeButton(){
		loginPage.goTo(loginUrl);
		loginPage.emailLogin.sendKeys("nadja_cv@mail.ru");
		loginPage.passwordLogin.sendKeys("perekuta96");
		loginPage.homeButton.click();
		Assert.assertEquals(loginPage.getCurrentUrl(),"http://localhost:8080/hospital/");
	}
	
	/*Login without e-mail
	 * go to login page
	 * field for e-mail keep empty
	 * input password
	 * click on button "Log in"*/
	@Test(priority=0, dependsOnMethods={"checkElementsLoginPage"})
	public void testLoginWithoutEmail(){
		loginPage.goTo(loginUrl);
		loginPage.emailLogin.sendKeys("");
		loginPage.passwordLogin.sendKeys("nadja");
		loginPage.loginButton.click();
		Assert.assertEquals(loginPage.getCurrentUrl(),loginUrl);
	}
	
	/*Login without password
	 * go to login page
	 * input e-mail
	 * field for password keep empty
	 * click on button "Log in"*/
	@Test(priority=4, dependsOnMethods={"checkElementsLoginPage"})
	public void testLoginWithoutPassword(){
		loginPage.goTo(loginUrl);
		loginPage.emailLogin.sendKeys("nadjacv545@mail.ru");
		loginPage.passwordLogin.sendKeys("");
		loginPage.loginButton.click();	
		Assert.assertEquals(loginPage.getCurrentUrl(),loginUrl);
	}
	
	/*Login by unregistered e-mail
	 * go to login page
	 * input unregistered e-mail
	 * input password
	 * click on button "Log in"*/
	@Test(priority=5, dependsOnMethods={"checkElementsLoginPage"})
	public void testLoginIncorrectEmail(){
		loginPage.goTo(loginUrl);
		loginPage.emailLogin.sendKeys("nadjacv577@mail.ru");
		loginPage.passwordLogin.sendKeys("nadja57");
		loginPage.loginButton.click();
		Assert.assertTrue(loginPage.containsText("Invalid"));
	}
	
	/*Login by incorrect password
	 * go to login page
	 * input registered e-mail
	 * input incorrect password
	 * click on button "Log in"*/
    @Test(priority=6, dependsOnMethods={"checkElementsLoginPage"})
	public void testLoginIncorrectPassword(){
		loginPage.goTo(loginUrl);
		loginPage.emailLogin.sendKeys("nadjacv57@mail.ru");
		loginPage.passwordLogin.sendKeys("nadja577");
		loginPage.loginButton.click();
		Assert.assertTrue(loginPage.containsText("Invalid"));
	}
	
	@AfterMethod
	public void afterMethod(){
		browserActions.getDriver().quit();
	}
	
}
