package ru.yandex.devlada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//Класс страницы аутентификации
public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver; }
    //вводим логин
    public void inputLogin(String login) {
        WebElement loginField = driver.findElement(By.id("User"));
        loginField.sendKeys(login);
    }
    //вводим пароль
    public void inputPasswrd(String password) {
        WebElement passwdField = driver.findElement(By.id("Password"));
        passwdField.sendKeys(password);
    }
    //нажимаем на кнопку "Войти"
    public void clickLoginBtn() {
        WebElement clickBtn = driver.findElement(By.xpath(".//*[contains(text(), 'Войти')]/.."));
        clickBtn.click(); }
}
