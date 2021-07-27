package ru.yandex.devlada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreatePatternTest {
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
    public void createPatternTest() throws InterruptedException {
        searchPage.fieldInput(ConfProperties.getProperty("fieldNTicketPrn01"), ConfProperties.getProperty("idFieldNTicket"));
        searchPage.fieldInput(ConfProperties.getProperty("fieldLetterBodyPrn01"), ConfProperties.getProperty("idFieldLetterBody"));
        searchPage.fieldInput(ConfProperties.getProperty("fieldTopicPrn01"), ConfProperties.getProperty("idFieldTopic"));

        //ДЛЯ СОЗДАНИЯ ШАБЛОНА Pattern02
        /**
        searchPage.fieldInput(ConfProperties.getProperty("fieldNTicketPrn02"), ConfProperties.getProperty("idFieldNTicket"));
        searchPage.fieldInput(ConfProperties.getProperty("fieldLetterBodyPrn02"), ConfProperties.getProperty("idFieldLetterBody"));
 */
        searchPage.savePrn();
        searchPage.createPrn(ConfProperties.getProperty("name01"));
        Thread.sleep(1000);
        searchPage.searchBtn();
        Thread.sleep(3000);
    }
    @AfterClass
    public static void tearDown() {
    //выход из аккаунта
    linkFunction.logout();
    driver.quit();
    }
}
