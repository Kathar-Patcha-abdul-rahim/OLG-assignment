package tests;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.OLG.OLGHomePage;
import pages.GoogleMap.GoogleMapHomePage;
import listeners.TestListener;

import java.util.ArrayList;
import java.util.List;

@Listeners(TestListener.class)
public class AssignmentTest extends BaseTest {


    /**
     * This test case covers the part 1 of the assignment
     * Where we need to verify the page title and visibility of two elements
     */
    @Test
    public void basicAssertions()
    {
        //creating an object for the OLGHomePage to use the Page Object Model
        OLGHomePage olgHomePage = new OLGHomePage(page);

        //navigating to the home page
        olgHomePage.navigate();

        //fetching the actual page title
        String actualPageTitle = olgHomePage.getPageTitle();
        String expectedPageTitle = "OLG | Ontario's Online LOTTERY, CASINO & SPORTS 2026";

        //asserting whether the actual page title matched the expected one
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "The Page title was not matched");

        //asserting whether the login button is visible
        Assert.assertTrue(olgHomePage.getLoginButton().isVisible(), "The Login button was not visible");

        //asserting whether the signup button is visible
        Assert.assertTrue(olgHomePage.getSignUpButton().isVisible(), "The SignUp button was not visible");

    }

    /**
     * This test case covers part 2 of the assignment
     * Where we need to search and verify atleast one item is returned
     */
    @Test
    public void searchScenario() {

        //creating an object for google map to use the page object model
        GoogleMapHomePage homePage = new GoogleMapHomePage(page);

        //navigating to the google map page
        homePage.navigate();

        //fetching the actual page title
        String actualPageTitle = homePage.getPageTitle();
        String expectedPageTitle = "Google Maps";

        //asserting whether the actual page title matched the expected one
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "The Page title was not matched");

        //searching the search box with the keyword
        homePage.getSearchField().fill("Restaurants");
        homePage.getSearchButton().click();

        //getting all the results of the search and extracting them into a list
        Locator searchResults = homePage.getSearchResults();
        List<String> restaurants = new ArrayList<>();
        for(int i = 0; i < searchResults.count(); i++)
        {
            String restaurantName =
                    searchResults.nth(i).getAttribute("aria-label");

            restaurants.add(restaurantName);
        }

        //asserting whether the result contains atleast one item
        Assert.assertFalse(restaurants.isEmpty(), "The restaurants list is empty");

    }
}
