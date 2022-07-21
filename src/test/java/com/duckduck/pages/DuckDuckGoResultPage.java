package com.duckduck.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DuckDuckGoResultPage {
    private WebDriver wd;
    private WebDriverWait wait;

    public DuckDuckGoResultPage(WebDriver wd) {
        this.wd = wd;
        wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        PageFactory.initElements(wd, this);
    }

    @FindBy(css = "div#duckbar a.js-zci-link--videos")
    WebElement videoBtn;

    public void clickVideoBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(videoBtn));
        videoBtn.click();
    }

    public List<String> getVideosLink() {
        List<String> videoLinks = new ArrayList<>();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div.tile-wrap div.tile__body h6 a"), 59));
        List<WebElement> videoDiv = wd.findElements(By.cssSelector(("div.tile-wrap div.tile__body h6 a")));
        for (WebElement webEl : videoDiv) {
            videoLinks.add(webEl.getAttribute("href"));
        }
        return videoLinks;
    }

}
