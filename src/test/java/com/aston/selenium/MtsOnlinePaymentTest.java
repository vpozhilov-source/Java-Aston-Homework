package com.aston.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class MtsOnlinePaymentTest {

    @Test
    public void testOnlinePaymentBlock() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.mts.by");
            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(2000);

            WebElement paymentBlock = driver.findElement(By.xpath("//*[contains(text(), 'Онлайн пополнение')]"));
            String actualText = paymentBlock.getText();
            assertTrue(actualText.contains("Онлайн пополнение"));
            assertTrue(actualText.contains("без комиссии"));

            List<WebElement> logos = driver.findElements(By.xpath("//footer//img"));
            assertTrue(logos.size() > 0);

            WebElement serviceLink = driver.findElement(By.xpath("//a[contains(text(), 'Сервисы для жизни')]"));
            assertTrue(serviceLink.isDisplayed());

            List<WebElement> inputs = driver.findElements(By.xpath("//input[contains(@placeholder, 'номер') or contains(@placeholder, 'Номер')]"));
            WebElement phoneInput = inputs.get(0);
            phoneInput.sendKeys("297777777");

            List<WebElement> buttons = driver.findElements(By.xpath("//button[contains(text(), 'Продолжить')]"));
            WebElement continueButton = buttons.get(0);
            assertTrue(continueButton.isEnabled());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}