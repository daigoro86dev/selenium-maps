package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class AcceptCookiesPage {

    private WebDriver driver;
    private By acceptCookiesButton = By.cssSelector("button[jsname='higCR']");

    public  AcceptCookiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public MapsPage clickAcceptCookiesButton() {
        try {
            driver.findElement(acceptCookiesButton).click();
        } catch(NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Element not found");
        }
        return new MapsPage(driver);
    }
}
