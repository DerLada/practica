package ru.yandex.devlada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver; }
    //вводим логин
    public void inputLogin(String loginTrue) {
        WebElement loginField = driver.findElement(By.id("User"));
        loginField.sendKeys(loginTrue);
    }
    //вводим пароль
    public void inputPasswrd(String passwordTrue) {
        WebElement passwdField = driver.findElement(By.id("Password"));
        passwdField.sendKeys(passwordTrue);
    }
    //нажимаем на кнопку "Войти"
    public void clickLoginBtn() {
        WebElement clickBtn = driver.findElement(By.xpath(".//*[contains(text(), 'Войти')]/.."));
        clickBtn.click(); }
}
