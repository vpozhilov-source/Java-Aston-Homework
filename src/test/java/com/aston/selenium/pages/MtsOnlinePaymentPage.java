package com.aston.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.*;

public class MtsOnlinePaymentPage {

    private WebDriver driver;

    public MtsOnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(), 'Онлайн пополнение')]")
    private WebElement paymentBlock;

    @FindBy(xpath = "//footer//img")
    private List<WebElement> paymentLogos;

    @FindBy(xpath = "//a[contains(text(), 'Сервисы для жизни')]")
    private WebElement serviceLink;

    @FindBy(xpath = "//span[contains(text(), 'Услуги связи')]")
    private WebElement mobileServicesTab;

    @FindBy(xpath = "//input[@placeholder='Номер телефона' or @placeholder='Номер']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement amountInput;

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement continueButton;

    public void verifyPaymentBlock() {
        assertTrue(paymentBlock.isDisplayed());
        String text = paymentBlock.getText();
        assertTrue(text.contains("Онлайн пополнение"));
        assertTrue(text.contains("без комиссии"));
    }

    public void verifyPaymentLogos() {
        assertTrue(paymentLogos.size() > 0);
    }

    public void verifyServiceLink() {
        assertTrue(serviceLink.isDisplayed());
    }

    public void selectMobileServices() {
        mobileServicesTab.click();
    }

    public void fillPhoneNumber(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void fillAmount(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void verifyMobileServicesTab() {
        selectMobileServices();
        assertEquals(phoneInput.getAttribute("placeholder"), "Номер телефона");
    }
}