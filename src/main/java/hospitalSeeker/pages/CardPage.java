package hospitalSeeker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardPage {
    @FindBy(css = "a.btn.btn-info")
    public WebElement newRecordButton;

    @FindBy(css = "a.collapsed")
    public WebElement dateRecordButton;

    @FindBy(linkText = "Edit")
    public WebElement editButton;

    public Date dateParser() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd-MM-yyyy");
        String dateString = dateRecordButton.getAttribute("value").trim();
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static CardPage init(WebDriver driver) {
        return PageFactory.initElements(driver, CardPage.class);
    }
}
