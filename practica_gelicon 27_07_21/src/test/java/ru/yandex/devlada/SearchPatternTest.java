package ru.yandex.devlada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;
//Тест 7_04 Поиск с помощью использования шаблона. Проверка элемента работы с шаблонами кнопки «Поиск»
public class SearchPatternTest {
    public static LinkFunction linkFunction;
    public static LoginPage loginPage;
    public static SearchPage searchPage;
    public static WebDriver driver;

    @BeforeClass
    public static void  setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium firefox\\chromedriver_win32\\chromedriver.exe");
        // System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.binary", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        linkFunction = new LinkFunction(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("page7"));
        //ввойти в аккаунт
        loginPage.inputLogin(ConfProperties.getProperty("loginTrue"));
        loginPage.inputPasswrd(ConfProperties.getProperty("passwordTrue"));
        loginPage.clickLoginBtn();
    }

    @Test
    public void searchPatternTestt() throws AWTException, InterruptedException {
        searchPage.clickNameSearch();
        //ПРОБЛЕМА ВЫБРАТЬ ШАБЛОН ПОИСКА ИЗ СПИСКА


        //нажать на кнопку поиск
        searchPage.searchPrnBtn();
        //задержка для визуального сравнения и оценки
        Thread.sleep(5000);

    }
    /**     @AfterClass
    public static void tearDown() {
    //выход из аккаунта
    linkFunction.logout();
    driver.quit();
    }*/
}
