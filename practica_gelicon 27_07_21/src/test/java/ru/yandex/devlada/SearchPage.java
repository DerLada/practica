package ru.yandex.devlada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//Класс страницы поиска по заявкам
public class SearchPage {
    public WebDriver driver;
    public SearchPage(WebDriver driver) {
        this.driver = driver; }
    //Поиск шаблона: нажать на поле имени шаблона
    public void clickNameSearch() {
        WebElement nameField = driver.findElement(By.id("Profile_Search"));
        nameField.click();
    }
    //Поиск шаблона: выбрать имя шаблона
    public void inputNameSearch(String name) {
        Select dropdown = new Select(driver.findElement(By.id("Profile_Search")));
        dropdown.selectByVisibleText(name);
    }
    //Поиск шаблона: нажать кнопку Выбор
    public void choicePrnBtn() {
        WebElement choiceBtn = driver.findElement(By.xpath("html/body/div[3]/div/form[1]/div/button[1]"));
        choiceBtn.click();
    }
    //Поиск шаблона: нажать кнопку Удалить
    public void DeletePrnBtn() {
        WebElement deleteBtn = driver.findElement(By.xpath("html/body/div[3]/div/form[1]/div/button[2]"));
        deleteBtn.click();
    }
    //Поиск шаблона: нажать кнопку Поиск
    public void searchPrnBtn() {
        WebElement searchBtn = driver.findElement(By.xpath("html/body/div[3]/div/form[1]/div/button[3]"));
        searchBtn.click();
    }

    //ДЛЯ ТЕСТА СОЗДАНИЕ ШАБЛОНА ПОИСКА
    //Поставить галочку "Сохранить как шаблон поиска"
    public void savePrn() {
        WebElement saveField = driver.findElement(By.id("SaveProfile"));
        saveField.click();
    }
    //Ввести имя шаблона поиска
    public void createPrn(String name) {
        WebElement nameCreatField = driver.findElement(By.xpath("html/body/div[3]/div/form[2]/fieldset[6]/div[2]/input"));
        nameCreatField.sendKeys(name);
    }
    //Нажать кнопку Поиск (внизу страницы)
    public void searchBtn() {
        WebElement searchBtn = driver.findElement(By.id("Submit"));
        searchBtn.click();
    }
    //Заполняем поля поиска с вводом текстовых значений
    public void fieldInput(String text, String idField) {
        WebElement field = driver.findElement(By.id(idField));
        field.sendKeys(text);
    }
    //метод для получения текста в поле по id элемента
    public String getFieldNamePrn(String id) {
        WebElement nameField = driver.findElement(By.id(id));
        String FieldNamePrn = nameField.getText();
        return FieldNamePrn; }
}
