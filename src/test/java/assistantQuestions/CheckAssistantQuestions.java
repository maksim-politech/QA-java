package assistantQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;

import java.util.concurrent.TimeUnit;


public class CheckAssistantQuestions {

    private WebDriver driver;

    //ожидаемый текст ответа1
    private final String assistantQuestion1ExpectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    //ожидаемый текст ответа2
    private final String assistantQuestion2ExpectedText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
    }

    @Test
    public void shownTextWhenOpenAssistantQuestion1() {

        MainPage mainPage = new MainPage(driver);

        mainPage.open();
        mainPage.scrollLastAssistantQuestion();
        mainPage.clickAssistantQuestion1Button();
        Assert.assertEquals(assistantQuestion1ExpectedText, mainPage.getAssistantQuestion1Text());

    }

    @Test
    public void shownTextWhenOpenAssistantQuestion2(){

        MainPage mainPage = new MainPage(driver);

        mainPage.open();
        mainPage.scrollLastAssistantQuestion();
        mainPage.clickAssistantQuestion2Button();
        Assert.assertEquals(assistantQuestion2ExpectedText, mainPage.getAssistantQuestion2Text());

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
