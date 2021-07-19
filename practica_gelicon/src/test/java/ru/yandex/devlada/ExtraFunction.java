package ru.yandex.devlada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
//класс, в который планировалось помещать функции общие для нескольких тестов (может быть)
public class ExtraFunction {
    public static WebDriver driver;
    public ExtraFunction(/**WebDriver driver*/) {
        this.driver = driver; }
    public static void  setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium firefox\\chromedriver_win32\\chromedriver.exe");
        // System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.binary", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void linkMenu() {
        WebElement MainMenuBTN = driver.findElement(By.className(" Selected Selected")/**xpath(".//*[contains(text(), 'Заявки')]/..")*/);
        Actions builder = new Actions(driver);
        builder.moveToElement(MainMenuBTN).click().build().perform();
       // WebElement logoutBtn = driver.findElement(By.id("LogoutButton"));
       // WebElement clickBtn = driver.findElement(ExpectedConditions.elementToBeClickable);

//<a href="/otrs/customer.pl?Action=CustomerTicketOverview;Subaction=MyTickets" accesskey="m" title="Заявки. (m)">Заявки</a>
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(text(), 'Новая заявка')]/.."))).click();

    }
  /**  System.setProperty("webdriver.chrome.driver", "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
options.addArguments("start-maximized");
options.addArguments("--disable-extensions");
    //options.addArguments("disable-infobars");
    WebDriver driver = new ChromeDriver(options);
driver.get("https://www.ebay.com/");
new Actions(driver).moveToElement(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sports")))).perform();
new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sports']//following::div[@class='hl-cat-nav__flyout']//span[text()='Other Categories']//following::ul[1]/li/a[normalize-space()='Tennis']"))).click();
*/
}
