package ru.yandex.devlada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
//Тест 2. Проверка ссылок в пунктах меню Запросы
public class LinkMenuTest {
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("page2"));
        //ввойти в аккаунт
        loginPage.inputLogin(ConfProperties.getProperty("loginTrue"));
        loginPage.inputPasswrd(ConfProperties.getProperty("passwordTrue"));
        loginPage.clickLoginBtn();
    }
   /** public void login() {
        loginPage.inputLogin(ConfProperties.getProperty("loginTrue"));
        loginPage.inputPasswrd(ConfProperties.getProperty("passwordTrue"));
        loginPage.clickLoginBtn();
    }*/
    @Test
    //

    public void linkMenuTest() throws InterruptedException {
        //переход по ссылке Новая заявка (1-ый переход)
        linkFunction.linkMenu(ConfProperties.getProperty("el1Menu"));
        Thread.sleep(1000);
        //переход по ссылке Мои заявки (2-й переход)
        linkFunction.linkMenu(ConfProperties.getProperty("el2Menu"));
        Thread.sleep(1000);
        //переход по ссылке Заявки компании(3-й переход)
        linkFunction.linkMenu(ConfProperties.getProperty("el3Menu"));
        Thread.sleep(1000);
        //переход по ссылке Поиск(4-й переход)
        linkFunction.linkMenu(ConfProperties.getProperty("el4Menu"));
        Thread.sleep(1000);
    }
    @AfterClass
    public static void tearDown() {
        //выход из аккаунта
        linkFunction.logout();
        driver.quit();
    }
}
