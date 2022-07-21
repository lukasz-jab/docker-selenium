package com.newtours.pages;

import model.RegisterUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegistrationPage {

    private WebDriver wd;
    private WebDriverWait wait;

    @FindBy(css = "button#denyAll")
    WebElement rodoDismiss;

    @FindBy(css = "input[name='firstName']")
    WebElement inputFirstName;

    @FindBy(css = "input[name='lastName']")
    WebElement inputLastName;

    @FindBy(css = "input[name='email']")
    WebElement inputUserName;

    @FindBy(css = "input[name='password']")
    WebElement inputPassword;

    @FindBy(css = "input[name='confirmPassword']")
    WebElement inputConfirmPassword;

    @FindBy(css = "input[name='submit']")
    WebElement submitBtn;

    public RegistrationPage(WebDriver wd) {
        this.wd = wd;
        wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        PageFactory.initElements(wd, this);
    }

    public void goTo() {
        this.wd.get("https://demo.guru99.com/test/newtours/register.php");
        this.wait.until(ExpectedConditions.visibilityOf(inputFirstName));
    }

    public void rodoDismiss() throws InterruptedException {
        String windowHandle = wd.getWindowHandle();
        Thread.sleep(7000);
        wd.switchTo().frame("gdpr-consent-notice");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#denyAll")));
        rodoDismiss.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.okButton")));
        wd.findElement(By.cssSelector("button.okButton")).click();
        Thread.sleep(4000);
        wd.switchTo().window(windowHandle);
    }

    public void fillRegisterForm(RegisterUser registerUser) {
        inputFirstName.sendKeys(registerUser.getFirstName());
        inputLastName.sendKeys(registerUser.getLastName());
        inputUserName.sendKeys(registerUser.getUserName());
        inputPassword.sendKeys(registerUser.getPassword());
        inputConfirmPassword.sendKeys(registerUser.getPassword());
        submitBtn.click();
    }
}
