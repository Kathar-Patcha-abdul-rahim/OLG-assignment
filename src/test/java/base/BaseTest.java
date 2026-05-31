package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseTest {

    private Playwright playwright;
    private Browser browser;
    private boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

    protected BrowserContext context;
    protected Page page;

    /**
     * Initial setup is been done in this method
     * creating playwright, browser, and page objects
     */
    @BeforeMethod
    public void setup()
    {
        playwright = Playwright.create();

        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(headless)
                        .setArgs(List.of("--start-maximized")));

        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null));

        page = context.newPage();
    }

    /**
     * Tear down is done in this method
     * closing all the opened sessions
     */
    @AfterMethod
    public void tearDown()
    {
        if(context != null)
            context.close();

        if(browser != null)
            browser.close();

        if(playwright != null)
            playwright.close();
    }

    /**
     * return the current page of an instance
     * @return - current page
     */
    public Page getPage()
    {
        return this.page;
    }

}
