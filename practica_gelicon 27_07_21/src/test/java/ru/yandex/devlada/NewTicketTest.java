package ru.yandex.devlada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;
//Тест 3. Заполнение формы новой
public class NewTicketTest {
    public static LinkFunction linkFunction;
    public static LoginPage loginPage;//страница авторизации
    public static NewTicketPage newTicketPage;//страница Новая заявка
    public static WebDriver driver;
    @BeforeClass
    public static void  setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium firefox\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.binary", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        linkFunction = new LinkFunction(driver);
        loginPage = new LoginPage(driver);
        newTicketPage = new NewTicketPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("page3"));
        //ввод логина
        loginPage.inputLogin(ConfProperties.getProperty("loginTrue"));
        //ввод пароля
        loginPage.inputPasswrd(ConfProperties.getProperty("passwordTrue"));
        //нажатие на кнопку "Войти"
        loginPage.clickLoginBtn();
    }

    @Test
    public void newTicketTest() throws AWTException, InterruptedException {
        //заполняем поле Тип
        newTicketPage.inputType(ConfProperties.getProperty("numType"));
        //заполняем поле Сервис
        newTicketPage.inputService(ConfProperties.getProperty("numSer"));
        //Заполняем поле Тема
        newTicketPage.inputTopic(ConfProperties.getProperty("topic"));
        //заполняем поле текст
        newTicketPage.inputText(ConfProperties.getProperty("textTicket"));
        //заполняем поле Приоритет
        newTicketPage.inputPriority(ConfProperties.getProperty("numPr"));
        Thread.sleep(2000);
        newTicketPage.clickSendBtn();
        Thread.sleep(2000);
    }
    @AfterClass
    public static void tearDown() {
        //выход из аккаунта
        linkFunction.logout();
        driver.quit();
    }

}
