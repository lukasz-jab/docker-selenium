package tests;

import com.duckduck.pages.DuckDuckGoPage;
import com.duckduck.pages.DuckDuckGoResultPage;
import com.duckduck.pages.SessionHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DuckDuckVideoTest extends TestBase {

    private DuckDuckGoPage duckDuckGoPage;
    private DuckDuckGoResultPage duckDuckGoResultPage;
    private SessionHelper sessionHelper;

    @BeforeMethod
    public void setUp() {
        duckDuckGoPage = new DuckDuckGoPage(wd);
        duckDuckGoResultPage = new DuckDuckGoResultPage(wd);
        sessionHelper = new SessionHelper(wd);
    }

    @Test
    public void testDuckDuckGoVideo() throws InterruptedException {
        duckDuckGoPage.goTo();
        duckDuckGoPage.searchInput("Java");
        duckDuckGoPage.clickSearchBtn();
        duckDuckGoResultPage.clickVideoBtn();
        List<String> videoLinks = duckDuckGoResultPage.getVideosLink();
        int i = 0;
        for (String link : videoLinks.subList(0,10)) {
            System.out.println("Link: " + i + " " + link);
            sessionHelper.goToLink(link, 5);
            i++;
        }
    }
}
