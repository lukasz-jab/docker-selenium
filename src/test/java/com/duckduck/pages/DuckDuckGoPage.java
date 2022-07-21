package com.duckduck.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DuckDuckGoPage {
    private WebDriver wd;
    private WebDriverWait wait;

    public DuckDuckGoPage(WebDriver wd) {
        this.wd = wd;
        wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        PageFactory.initElements(wd, this);
    }

    @FindBy(css = "input#search_form_input_homepage")
    WebElement searchInput;

    @FindBy(css = "input#search_button_homepage")
    WebElement searchBtn;

    public void goTo() {
        wd.navigate().to("https://duckduckgo.com/");
    }

    public void searchInput(String searchText) {
        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.sendKeys(searchText);
    }

    public void clickSearchBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        searchBtn.click();
    }
}
