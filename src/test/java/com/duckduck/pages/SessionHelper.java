package com.duckduck.pages;

import org.openqa.selenium.WebDriver;

public class SessionHelper {
    private WebDriver wd;

    public SessionHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void goToLink(String link, int wait) throws InterruptedException {
        wd.navigate().to(link);
        Thread.sleep(wait * 1000);
    }
}
