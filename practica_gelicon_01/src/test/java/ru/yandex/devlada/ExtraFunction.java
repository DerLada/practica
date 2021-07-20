package ru.yandex.devlada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;
//класс, в который планировалось помещать функции общие для нескольких тестов (может быть)
public class ExtraFunction {
    public static WebDriver driver;
    public ExtraFunction(WebDriver driver) {
        this.driver = driver; }
    public static void  setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium firefox\\chromedriver_win32\\chromedriver.exe");
        // System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.binary", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    Actions action;
    public void linkMenu() {
        action = new Actions(driver);
        WebElement menuBtn = driver.findElement(By.xpath("html/body/div[2]/ul[1]/li[1]/a"));
        //переход по ссылке Новая заявка (1-ый переход)
        action.moveToElement(menuBtn).moveToElement(driver.findElement(By.xpath(".//*[contains(text(), 'Новая заявка')]/.."))).click().build().perform();

        //menuBtn = driver.findElement(By.xpath("html/body/div[2]/ul[1]/li[1]/a"));
        //второй переход по ссылке (Новая заявка) - не работает - невидимый элемент, скорее всего не раскрывается меню
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(), 'Мои заявки')]/..")));
        action.moveToElement(menuBtn).moveToElement(driver.findElement(By.xpath(".//*[contains(text(), 'Мои заявки')]/.."))).click().build().perform();
      }

}
