package ru.yandex.devlada;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;//страница авторизации
    public static ProfilePage profilePage;//страница профиля, на которую мы попадаем после входа
    public static WebDriver driver;
    //public static  ExtraFunction extraFunction;//страница, содержащая какие-то общие функции для тестов
    @BeforeClass
    public static void  setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium firefox\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.binary", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
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
        profilePage.logout();
        driver.quit();
    }

}
