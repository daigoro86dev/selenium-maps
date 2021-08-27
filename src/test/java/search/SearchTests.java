package test.java.search;

import test.java.base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import main.java.pages.MapsPage;

public class SearchTests extends BaseTests {

    private String locationName = "Dublin";

    @Test
    public void TestSuccessfulSearch() {
        mapsPage.setLocation(locationName);
        MapsPage mapsSearchResultsPage = mapsPage.clickSearchButton();
        mapsSearchResultsPage.waitForResults(locationName);
        Assert.assertEquals(mapsSearchResultsPage.getLocationPageTitle(),
                String.format("%s - Google Maps", locationName),
                "Search is incorrect"
        );
        Assert.assertTrue(mapsSearchResultsPage.getLocationPageUrl().contains(locationName));
        Assert.assertTrue(mapsSearchResultsPage.getHeadlineText(locationName).equals(locationName));
        MapsPage mapsDirectionsPage = mapsPage.clickDirectionsButton();
        mapsDirectionsPage.waitForResults("/dir/");
        Assert.assertTrue(mapsDirectionsPage.getDestinationInputText().contains(locationName));
    }
}
