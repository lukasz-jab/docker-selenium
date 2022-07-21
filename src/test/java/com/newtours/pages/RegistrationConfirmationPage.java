package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationConfirmationPage {

    private WebDriver wd;
    private WebDriverWait wait;

    public RegistrationConfirmationPage(WebDriver wd) {
        this.wd = wd;
        wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//tr//td//b[contains(text(), 'Dear')]")
    WebElement welcomeTag;

    @FindBy(css = "td a[href='reservation.php']")
    WebElement flightsBtn;

    public void waitForConfirmationUser() {
        wait.until(ExpectedConditions.visibilityOf(welcomeTag));
    }

    public void clickFlightsBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(flightsBtn));
        flightsBtn.click();
    }
}
