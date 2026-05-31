package pages.GoogleMap;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class googleMapHomePage {

    private final Page page;
    private static final String TRIP_URL = "https://www.google.com/maps";

    private static final String searchBox = "#ucc-1";
    private static final String searchResults = "//div[@aria-label = 'Results for Restaurants']//div[@role='article']";

    /**
     * Assign the page with the current page session
     * @param page - page that need to be assigned
     */
    public googleMapHomePage(Page page)
    {
        this.page = page;
    }

    /**
     * Navigate to the predefined url
     */
    public void navigate()
    {
        page.navigate(TRIP_URL);
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
     * get the search button locator
     * @return - search button locator
     */
    public Locator getSearchButton()
    {
        return page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Search"));
    }

    /**
     * get the search field locator
     * @return - search field locator
     */
    public Locator getSearchField()
    {
        return page.locator(searchBox);
    }

    /**
     * get the locator of the search results
     * @return - search result locator
     */
    public Locator getSearchResults()
    {
        Locator results = page.locator(searchResults);

        results.first().waitFor();

        return results;
    }
}
