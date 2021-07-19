package ru.yandex.devlada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LinkMenuTest {
    public static ExtraFunction extraFunction;
    public static LoginPage loginPage;
    //public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void  setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium firefox\\chromedriver_win32\\chromedriver.exe");
        // System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.binary", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        extraFunction = new ExtraFunction();
        loginPage = new LoginPage(driver);
        //profilePage = new ProfilePage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("page2"));
    }
   /** public void login() {
        loginPage.inputLogin(ConfProperties.getProperty("loginTrue"));
        loginPage.inputPasswrd(ConfProperties.getProperty("passwordTrue"));
        loginPage.clickLoginBtn();
    }*/
    @Test
    //

    public void linkMenuTest() {
        //ввойти в аккаунт
        loginPage.inputLogin(ConfProperties.getProperty("loginTrue"));
        loginPage.inputPasswrd(ConfProperties.getProperty("passwordTrue"));
        loginPage.clickLoginBtn();
//        extraFunction.linkMenu(); //переход по ссылке в меню заявки
        //так как пока не работает: необходимо открыть меню и перейти по первой ссылке (новые заявки), чтобы открыть меню, надо на него просто навести мышкой
        //находит расположение меню
        WebElement MainMenuBTN = driver.findElement(By.tagName("a"));
        Actions builder = new Actions(driver);
        //должен открывать меню наведением мышки, но не открывает
        builder.moveToElement(MainMenuBTN).click().build().perform();
        /**  // WebElement logoutBtn = driver.findElement(By.id("LogoutButton"));
        // WebElement clickBtn = driver.findElement(ExpectedConditions.elementToBeClickable);

//<a href="/otrs/customer.pl?Action=CustomerTicketOverview;Subaction=MyTickets" accesskey="m" title="Заявки. (m)">Заявки</a>*/
      //ждет, пока будет открыто меню, и щелкает по ссылке "Новые заявки"
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(text(), 'Новая заявка')]/.."))).click();

    }
   /** @AfterClass
    public static void tearDown() {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.;

        //  setTimeout(profilePage.logout(), 1000);
      //  profilePage.logout();
      //   driver.quit();
    }*/
}
