package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //Кнопка раскрытия первого вопроса
    private final By assistantQuestion1Button = By.xpath(".//div[contains(text(), 'Сколько это стоит? И как оплатить?')]");
    //Элемент с текстом
    private final By assistantQuestion1Text = By.xpath(".//div[@id='accordion__panel-0']/p");


    private final By assistantQuestion2Button = By.xpath(".//div[contains(text(), 'Хочу сразу несколько самокатов! Так можно?')]");
    private final By assistantQuestion2Text = By.xpath(".//div[@id='accordion__panel-1']/p");

    private WebDriver driver;

    private final By orderButton = By.className("Button_Button__ra12g");
    private final By orderButton2 = By.xpath(".//div[@class='Home_FinishButton__1_cWm']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void scrollLastAssistantQuestion() {
        WebElement element = driver.findElement(By.xpath(".//div[@data-accordion-component='AccordionItem'] [7]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //////////Методы для теста shownTextWhenOpenAssistantQuestion1
    public void clickAssistantQuestion1Button () {
        driver.findElement(assistantQuestion1Button).click();
    }

    public String getAssistantQuestion1Text() {
        return driver.findElement(assistantQuestion1Text).getText();
    }

    //////////Методы для теста shownTextWhenOpenAssistantQuestion2
    public void clickAssistantQuestion2Button() {
        driver.findElement(assistantQuestion2Button).click();
    }

    public String getAssistantQuestion2Text() {
        return driver.findElement(assistantQuestion2Text).getText();
    }

    ///////Методы для теста makeOrder
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickOrderButton2() {
        driver.findElement(orderButton2).click();
    }

    public void scrollOrderButton2() {
        WebElement element = driver.findElement(orderButton2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

}




