package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseTest {

    private Playwright playwright;
    private Browser browser;

    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    public void setup()
    {
        playwright = Playwright.create();

        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(List.of("--start-maximized")));

        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null));

        page = context.newPage();
    }

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

}
