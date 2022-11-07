package pom;

import org.openqa.selenium.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OrderPage2 {

    private WebDriver driver;

    public OrderPage2(WebDriver driver) {
        this.driver = driver;
    }

    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    Date dateToday = new Date();
    String date =df.format(dateToday);

    private final By datePath = By.xpath(".//*[@placeholder='* Когда привезти самокат']");

    private final By rentalTime = By.xpath(".//*[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    private final By rentalTimeDropdown = By.xpath(".//*[@class ='Dropdown-option' and text()='двое суток']");

    private final By colourBlack = By.xpath(".//label[@for ='black']");

    public final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public final By confirmOrderButton = By.xpath(".//button[text()='Да']");

    public final By textAboutSuccessText = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");


    public void fillDate() {
        driver.findElement(datePath).sendKeys(date + Keys.ENTER);
    }
    public void fillRentalTime() {
        driver.findElement(rentalTime).click();
        driver.findElement(rentalTimeDropdown).click();
    }

    public void fillColour(){
        driver.findElement(colourBlack).click();
    }


    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }

    public void clickConfirmOrderButton(){
        driver.findElement(confirmOrderButton).click();
    }

    public String getTextAboutSuccessText(){
        return driver.findElement(textAboutSuccessText).getText();
    }

}
