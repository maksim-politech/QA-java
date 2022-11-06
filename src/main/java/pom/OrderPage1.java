package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage1 {

    private WebDriver driver;

    public OrderPage1(WebDriver driver) {
        this.driver = driver;
    }


    private final By nameField = By.xpath(".//*[@placeholder='* Имя']");

    private final By surnameField = By.xpath(".//*[@placeholder='* Фамилия']");

    private final By adress = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");

    private final By metro = By.xpath(".//*[@placeholder='* Станция метро']");

    private final By phone = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");

    private final By nextButton = By.xpath(".//button[text()='Далее']");



    public void fillNameField(){
        driver.findElement(nameField).sendKeys("Максим");
    }

    public void fillSurnameField(){
        driver.findElement(surnameField).sendKeys("Проскурин");
    }

    public void fillAdress(){
        driver.findElement(adress).sendKeys("Санкт-Петербург");
    }

    public void fillMetro(){
        driver.findElement(metro).sendKeys("Площадь"+ Keys.DOWN+Keys.ENTER);
    }


    public void fillPhone(){
        driver.findElement(phone).sendKeys("+77777777777");
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }






    ////Методы с данными для второго теста
    public void fillNameField2(){
        driver.findElement(nameField).sendKeys("Ева");
    }

    public void fillSurnameField2(){
        driver.findElement(surnameField).sendKeys("Адамовна");
    }

    public void fillAdress2(){
        driver.findElement(adress).sendKeys("Москва");
    }

    public void fillMetro2(){
        driver.findElement(metro).sendKeys("Площадь"+Keys.DOWN+Keys.DOWN+Keys.ENTER);
    }

    public void fillPhone2(){
        driver.findElement(phone).sendKeys("+8777777777");
    }

}
