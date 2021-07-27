package ru.yandex.devlada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

//класс для страницы "Новые заявки"
public class NewTicketPage {
    public WebDriver driver;
    public NewTicketPage(WebDriver driver) {
        this.driver = driver; }
    //преобразование текста в число
    public int StringToInt(String str) {
        int num=0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.err.println("Неправильный формат строки!");
        }
        return num;
    }
    //ввод в поле Тип
    public void inputType(String numStr) throws AWTException {
        int num=StringToInt(numStr);
        //определяем местоположения поля Тип
        WebElement typeField = driver.findElement(By.id("TypeID_Search"));
        typeField.click();
        //выбираем элемент из списка для ввода в поле тип и вводим его в поле Тип
        switch (num) {
            case 1:
                WebElement field1 = driver.findElement(By.id("j1_1_anchor"));
                field1.click();
                break;
            case 2:
                WebElement field2 = driver.findElement(By.id("j1_2_anchor"));
                field2.click();
                break;
            case 3:
                WebElement field3 = driver.findElement(By.id("j1_3_anchor"));
                field3.click();
                break;
            case 4:
                WebElement field4 = driver.findElement(By.id("j1_4_anchor"));
                field4.click();
                break;
            case 5:
                WebElement field5 = driver.findElement(By.id("j1_5_anchor"));
                field5.click();
                break;
            case 6:
                WebElement field6 = driver.findElement(By.id("j1_6_anchor"));
                field6.click();
                break;
            default:
                //если ничего не вводим, то выходим из "списка" нажатием клавиши Esc
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ESCAPE);
                break;
        }
    }
    //ввод в поле Сервис
    public void inputService(String numStr) throws AWTException {
        int num=StringToInt(numStr);
        //определяем местоположения поля Сервис
        WebElement serviceField = driver.findElement(By.id("ServiceID_Search"));
        serviceField.click();
        //выбираем элемент из списка для ввода в поле Сервис и вводим его в поле Сервис
        switch (num) {
            case 1:
                WebElement field1 = driver.findElement(By.id("j2_1_anchor"));
                field1.click();
                break;
            default:
                //если ничего не вводим, то выходим из "списка" нажатием клавиши Esc
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ESCAPE);
                break;
        }
    }
    //ввод в поле Тема
    public void inputTopic(String topic) {
        WebElement passwdField = driver.findElement(By.id("Subject"));
        passwdField.sendKeys(topic);
    }

    //ввод в поле Текст
    public void inputText(String textTicket) {
        driver.switchTo().frame(0);
        WebElement passwdField = driver.findElement(By.xpath("/html/body"));
        WebElement el  =  driver.switchTo().activeElement();
        new Actions(driver).moveToElement(el).perform();
        passwdField.sendKeys(textTicket);
        driver.switchTo().defaultContent();
    }
    //ввод в поле Приоритет
    public void inputPriority(String numStr) throws AWTException {
        int num=StringToInt(numStr);
        //Определяем местоположение поля Приоритет
        WebElement priorityField = driver.findElement(By.xpath(".//*[contains(text(), '3 normal - нормальная')]/.."));
        priorityField.click();
        //выбираем элемент из списка для ввода в поле Приоретет и вводим его в поле Приоритет
        switch (num) {
            case 1:
                WebElement field1 = driver.findElement(By.id("j3_1_anchor"));
                field1.click();
                break;
            case 2:
                WebElement field2 = driver.findElement(By.id("j3_2_anchor"));
                field2.click();
                break;
            case 3:
                WebElement field3 = driver.findElement(By.id("j3_3_anchor"));
                field3.click();
                break;
            case 4:
                WebElement field4 = driver.findElement(By.id("j3_4_anchor"));
                field4.click();
                break;
            case 5:
                WebElement field5 = driver.findElement(By.id("j3_5_anchor"));
                field5.click();
                break;
            default:
                //если ничего не вводим, то выходим из "списка" нажатием клавиши Esc
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ESCAPE);
                break;
        }
    }
    //нажать кнопку отправить
    public void clickSendBtn() {
        WebElement clickBtn = driver.findElement(By.id("submitRichText"));
        clickBtn.click();
    }
}
