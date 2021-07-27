package ru.yandex.devlada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
//Тест 5_01. Проверка ссылок на странице «Мои заявки»
public class MyTicketTest {
    public static LinkFunction linkFunction;
    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeClass
    public static void  setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium firefox\\chromedriver_win32\\chromedriver.exe");
        // System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.binary", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        linkFunction = new LinkFunction(driver);
        loginPage = new LoginPage(driver);
        //profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("page5_01"));
        //ввойти в аккаунт
        loginPage.inputLogin(ConfProperties.getProperty("loginTrue"));
        loginPage.inputPasswrd(ConfProperties.getProperty("passwordTrue"));
        loginPage.clickLoginBtn();
    }

    @Test
     public void myTicketTest() throws InterruptedException {
        //переход по ссылке Все
        linkFunction.linkTicket(ConfProperties.getProperty("el1MyTic"));
        Thread.sleep(500);
        //переход по ссылке Открытые
        linkFunction.linkTicket(ConfProperties.getProperty("el2MyTic"));
        Thread.sleep(500);
        //переход по ссылке Закрытые
        linkFunction.linkTicket(ConfProperties.getProperty("el3MyTic"));
        Thread.sleep(2000);

    }
    @AfterClass
    public static void tearDown() {
        //выход из аккаунта
        linkFunction.logout();
        driver.quit();
    }

}
