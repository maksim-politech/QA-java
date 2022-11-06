package MakeOrder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;
import pom.OrderPage1;
import pom.OrderPage2;

import java.util.concurrent.TimeUnit;

public class CheckMakeOrder {

    private WebDriver driver;

    private String expectedTextAboutSuccessText = "Заказ оформлен";

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();


        /////запуск фаерфокс 1ый способ
        //WebDriverManager.firefoxdriver().setup();

        //driver = new FirefoxDriver();

        /////запуск фаерфокс 2ой способ
        // GeckoDriverService gecko = new GeckoDriverService.Builder()
            //   .usingDriverExecutable(new File("C:\\WevDriver\\bin\\geckodriver.exe"))
            //   .usingFirefoxBinary(new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")))
            //   .build();
        //driver = new FirefoxDriver(gecko);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void MakeOrder(){

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOrderButton();

        OrderPage1 orderPage1 = new OrderPage1(driver);
        orderPage1.fillNameField();
        orderPage1.fillSurnameField();
        orderPage1.fillAdress();
        orderPage1.fillMetro();
        orderPage1.fillPhone();
        orderPage1.clickNextButton();

        OrderPage2 orderPage2 = new OrderPage2(driver);
        orderPage2.fillDate();
        orderPage2.fillRentalTime();
        orderPage2.fillColour();
        orderPage2.clickOrderButton();
        orderPage2.clickConfirmOrderButton();

        Assert.assertEquals(expectedTextAboutSuccessText, orderPage2.getTextAboutSuccessText());

    }

    @Test
    public void MakeOrder2(){

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollOrderButton2();
        mainPage.clickOrderButton2();

        OrderPage1 orderPage1 = new OrderPage1(driver);
        orderPage1.fillNameField2();
        orderPage1.fillSurnameField2();
        orderPage1.fillAdress2();
        orderPage1.fillMetro2();
        orderPage1.fillPhone2();
        orderPage1.clickNextButton();

        OrderPage2 orderPage2 = new OrderPage2(driver);
        orderPage2.fillDate();
        orderPage2.fillRentalTime();
        orderPage2.fillColour();
        orderPage2.clickOrderButton();
        orderPage2.clickConfirmOrderButton();

        Assert.assertEquals(expectedTextAboutSuccessText, orderPage2.getTextAboutSuccessText());

    }


    @After
    public void tearDown() {
      driver.quit();
   }

}
