package ru.yandex.devlada;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
//Тест 1. Аутентификация
public class LoginTest {
    public static LoginPage loginPage;//страница авторизации
    public static LinkFunction linkFunction;//страница профиля, на которую мы попадаем после входа
    public static WebDriver driver;

    @BeforeClass
    public static void  setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium firefox\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.binary", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        linkFunction = new LinkFunction(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("page1"));
    }

    @Test
    public void loginTest() {
        //ввод логина
        loginPage.inputLogin(ConfProperties.getProperty("loginTrue"));
        //ввод пароля
        loginPage.inputPasswrd(ConfProperties.getProperty("passwordTrue"));
        //нажатие на кнопку "Войти"
        loginPage.clickLoginBtn();
    }

    @AfterClass
    public static void tearDown() {
        //выход из аккаунта
        linkFunction.logout();
        driver.quit();
    }

}
