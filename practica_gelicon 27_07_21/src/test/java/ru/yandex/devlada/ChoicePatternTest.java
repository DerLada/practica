package ru.yandex.devlada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
//Тест 7_03 Поиск с помощью использования шаблона. Проверка элемента работы с шаблонами кнопки «Выбор»
public class ChoicePatternTest {
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
    public void choicePatternTest() {
        searchPage.clickNameSearch();
        //ПРОБЛЕМА ВЫБРАТЬ ШАБЛОН ПОИСКА ИЗ СПИСКА
        //searchPage.inputNameSearch(ConfProperties.getProperty("name01"));
        //driver.findElement(By.xpath("//li[text() = 'Pattern01']")).click();

       // driver.findElement(By.xpath("//*[contains(text(), 'Pattern01')]")).click();


        searchPage.choicePrnBtn();
        String namePrn = searchPage.getFieldNamePrn("Profile_Search");
      //  Assert.assertEquals("", namePrn);
        //сравнения полей после выбора шаблона и нажания кнопки выбор
        //сравнение идет только по заполненным полям. Возможно расширить до сравнения по всем текстовым полям
        switch (namePrn) {
            case "Pattern01":
                Assert.assertEquals(ConfProperties.getProperty("fieldNTicketPrn01"), searchPage.getFieldNamePrn("idFieldNTicket"));
                Assert.assertEquals(ConfProperties.getProperty("fieldLetterBodyPrn01"), searchPage.getFieldNamePrn("idFieldLetterBody"));
                Assert.assertEquals(ConfProperties.getProperty("fieldTopicPrn01"), searchPage.getFieldNamePrn("fieldNTicketPrn01"));
                break;
            case "Pattern02":
                Assert.assertEquals(ConfProperties.getProperty("fieldNTicketPrn02"), searchPage.getFieldNamePrn("idFieldNTicket"));
                Assert.assertEquals(ConfProperties.getProperty("fieldLetterBodyPrn02"), searchPage.getFieldNamePrn("idFieldLetterBody"));
                break;
            default:
                break;
        }
        //нажать на кнопку "Поиск"
        searchPage.searchBtn();
    }
    /**     @AfterClass
    public static void tearDown() {
    //выход из аккаунта
    linkFunction.logout();
    driver.quit();
    }*/
}
