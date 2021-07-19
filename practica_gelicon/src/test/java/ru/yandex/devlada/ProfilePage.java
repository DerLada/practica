package ru.yandex.devlada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver; }
    //выход из аккаунта
    public void logout() {
        WebElement logoutBtn = driver.findElement(By.id("LogoutButton"));
        logoutBtn.click();
    }
}
