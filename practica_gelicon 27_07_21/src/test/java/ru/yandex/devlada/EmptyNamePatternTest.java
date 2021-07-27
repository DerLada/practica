package ru.yandex.devlada;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
//Тест 7.2 Поиск с помощью использования шаблона. Проверка элементов работы с шаблонами при пустом значении поля «шаблон поиска»
public class EmptyNamePatternTest {
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
    public void emptyNamePatternTest() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        //запросить значение находящееся в поле "Шаблон поиска"
        String namePrn = searchPage.getFieldNamePrn("Profile_Search");
        //Проверить, что это значение является нулевым
        Assert.assertEquals("", namePrn);
        //Нажать на кнопку "Выбор"
        searchPage.choicePrnBtn();
        Thread.sleep(1500);
        //Нажать на кнопку "Удалить"
        searchPage.DeletePrnBtn();
        //Щелкнуть по полю "Шаблон поиска"
        searchPage.clickNameSearch();
        //Визуально проверить, что ничего не изменилось
        Thread.sleep(1000);
        searchPage.clickNameSearch();
        //выйти из режима выбора шаблон через нажатие клавиши Esc
        robot.keyPress(KeyEvent.VK_ESCAPE);
        //Нажать на кнопку "Поиск"
        searchPage.searchPrnBtn();
        Thread.sleep(3000);
    }
    @AfterClass
    public static void tearDown() {
    //выход из аккаунта
    linkFunction.logout();
    driver.quit();
    }
}
