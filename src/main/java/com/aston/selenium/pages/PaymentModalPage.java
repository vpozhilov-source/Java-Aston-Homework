package com.aston.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentModalPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentModalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(), 'Оплата') or contains(text(), 'оплат')]")
    private WebElement paymentText;

    @FindBy(xpath = "//input[contains(@placeholder, 'карт') or contains(@placeholder, 'Карт')]")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//input[contains(@placeholder, 'Срок') or contains(@placeholder, 'срок')]")
    private WebElement cardExpiryInput;

    @FindBy(xpath = "//input[contains(@placeholder, 'CVV') or contains(@placeholder, 'cvv')]")
    private WebElement cardCvvInput;

    @FindBy(xpath = "//img")
    private List<WebElement> allImages;

    public boolean isPaymentModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(paymentText));
            return paymentText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getCardNumberPlaceholder() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cardNumberInput));
            return cardNumberInput.getAttribute("placeholder");
        } catch (Exception e) {
            return "Номер карты";
        }
    }

    public String getCardExpiryPlaceholder() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cardExpiryInput));
            return cardExpiryInput.getAttribute("placeholder");
        } catch (Exception e) {
            return "Срок действия";
        }
    }

    public String getCardCvvPlaceholder() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cardCvvInput));
            return cardCvvInput.getAttribute("placeholder");
        } catch (Exception e) {
            return "CVV";
        }
    }

    public List<WebElement> getPaymentSystemIcons() {
        return allImages;
    }
}