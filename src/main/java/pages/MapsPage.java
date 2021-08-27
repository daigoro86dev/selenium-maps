package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MapsPage {

    private WebDriver driver;
    private final By searchBoxInput = By.id("searchboxinput");
    private final By searchBoxButton = By.id("searchbox-searchbutton");
    private final By directionsButton = By.xpath("//button[@jsaction='pane.placeActions.directions;keydown:pane.placeActions.directions']");
    private final By destinationSearchBoxInput = By.xpath("//div[@id='directions-searchbox-1']//input");
    private WebDriverWait wait;

    public MapsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setLocation(String locationName) {
        driver.findElement(searchBoxInput).clear();
        driver.findElement(searchBoxInput).sendKeys(locationName);
    }

    public MapsPage clickSearchButton() {
        driver.findElement(searchBoxButton).click();
        return new MapsPage(driver);
    }

    public MapsPage clickDirectionsButton() {
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(directionsButton));
        driver.findElement(directionsButton).click();
        return new MapsPage(driver);
    }

    public String getLocationPageTitle() {
        return driver.getTitle();
    }

    public String getLocationPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getHeadlineText(String headlineText) {
        By headlineTextSpan = By.xpath(String.format("//span[text() = '%s']", headlineText));
        return driver.findElement(headlineTextSpan).getText();
    }

    public String getDestinationInputText() {
        return driver.findElement(destinationSearchBoxInput).getAttribute("value");
    }

    public void waitForResults(String queryValue) {
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.urlContains(queryValue));
    }
}
