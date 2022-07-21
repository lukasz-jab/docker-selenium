package tests;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    protected WebDriver wd;

    @BeforeTest
    public void tearUp() throws MalformedURLException {
        String host = "localhost";
        MutableCapabilities cap = new MutableCapabilities();
        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            cap.setCapability("browserName", "firefox");
        } else {
            ChromeOptions options = new ChromeOptions();
            cap.setCapability("browserName", "chrome");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            cap.setCapability(ChromeOptions.CAPABILITY, options);
        }
        if(System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }
        String completeURL = "http://" + host + ":4444/wd/hub";

        wd = new RemoteWebDriver(new URL(completeURL), cap);

        //assuming driver is the name of the variable for WebDriver instance.
        if(wd instanceof RemoteWebDriver){
            ((RemoteWebDriver) wd).setFileDetector(new LocalFileDetector());
        }
    }

    @AfterTest()
    public void tearDown() throws InterruptedException {
        Thread.sleep(3600);
        wd.quit();
    }
}
