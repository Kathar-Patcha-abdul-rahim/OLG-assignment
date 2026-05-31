package pages.OLG;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OLGHomePage {

    private final Page page;
    private static final String OLG_URL = "https://www.olg.ca/";
    private static final String loginButton = "#login-button-sign-in-register";
    private static final String signUpButton = "#login-button-sign-up-register";


    /**
     * Assign the page with the current page session
     * @param page - Page that need to be assigned
     */
    public OLGHomePage(Page page)
    {
        this.page = page;
    }

    /**
     * Navigate to the predefined url
     */
    public void navigate()
    {
        page.navigate(OLG_URL);
    }

    /**
     * get the page title
     * @return - page title
     */
    public String getPageTitle()
    {
        return page.title();
    }

    /**
     * get the sign up button
     * @return - sign up button locator
     */
    public Locator getSignUpButton()
    {
        return page.locator(signUpButton);
    }

    /**
     * get the log in button
     * @return - login button locator
     */
    public Locator getLoginButton()
    {
        return page.locator(loginButton);
    }
}
