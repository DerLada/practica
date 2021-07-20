package ru.yandex.devlada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        extraFunction = new ExtraFunction(driver);
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
        extraFunction.linkMenu(); //переход по ссылке в меню заявки
        /**  //то, что записано в методе linkMenu класса extraFunction ля открытия ссылки
        Actions action = new Actions(driver);
        WebElement menuBtn = driver.findElement(By.xpath("html/body/div[2]/ul[1]/li[1]/a"));
        action.moveToElement(menuBtn).moveToElement(driver.findElement(By.xpath(".//*[contains(text(), 'Новая заявка')]/.."))).click().build().perform();
*/


      //ждет, пока будет открыто меню, и щелкает по ссылке "Новые заявки"
       // new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(text(), 'Новая заявка')]/.."))).click();

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
