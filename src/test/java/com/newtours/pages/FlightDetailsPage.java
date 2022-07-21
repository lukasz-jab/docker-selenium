package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightDetailsPage {

    private WebDriver wd;
    private WebDriverWait wait;

    public FlightDetailsPage(WebDriver wd) {
        this.wd = wd;
        wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        PageFactory.initElements(wd, this);
    }

    @FindBy(css = "form[name='findflight'] select[name='passCount']")
    WebElement passengerNOSelect;

    @FindBy(css = "form[name='findflight'] input[name='findFlights']")
    WebElement submitFlightDetailsBtn;

    @FindBy(css = "a[href='index.php'] img[src$='home.gif']")
    WebElement goBackHomeBtn;

    public void setPassengerNO(String no) {
        wait.until(ExpectedConditions.elementToBeClickable(passengerNOSelect));
        Select selectPassengerNO = new Select(passengerNOSelect);
        selectPassengerNO.selectByVisibleText(no);
    }

    public void submitFlightDetailsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(submitFlightDetailsBtn));
        submitFlightDetailsBtn.click();
    }

    public void clickBackHomeBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(goBackHomeBtn));
        goBackHomeBtn.click();
    }

}
