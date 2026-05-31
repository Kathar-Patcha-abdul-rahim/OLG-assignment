package utils;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class ScreenshotUtil {


    public static void takeScreenshot(Page page, String testName)
    {
        String fileName = testName + "_" + System.currentTimeMillis();
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshots/" + fileName + ".png"))
                .setFullPage(true));
    }
}
