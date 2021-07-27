package ru.yandex.devlada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//класс сдл организации перехода по ссылкам с помощью нажатия на элементы, расположенные на страницах
public class LinkFunction {
    public static WebDriver driver;
    public LinkFunction(WebDriver driver) {
        this.driver = driver; }

   //выход из аккаунта
   public void logout() {
       WebElement logoutBtn = driver.findElement(By.id("LogoutButton"));
       logoutBtn.click();
   }
    Actions action;
    //метод для перехода по ссылкам Меню
    public void linkMenu(String xpathEl) {
        action = new Actions(driver);
        WebElement menuBtn = driver.findElement(By.xpath("html/body/div[2]/ul[1]/li[1]/a"));
        action.moveToElement(menuBtn).moveToElement(driver.findElement(By.xpath(xpathEl))).click().build().perform();
    }
    //метод для перехода по ссылкам страниц Мои заявки и Заявки компании
    public void linkTicket(String xpathEl) {
        WebElement ticketBtn = driver.findElement(By.xpath(xpathEl));
        ticketBtn.click();
    }

}
