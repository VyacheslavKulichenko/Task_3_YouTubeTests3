package ua.kulychenko.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private final By searchBox = By.name("search_query");
    private final By searchResults = By.cssSelector("ytd-video-renderer");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage search(String query) {
        WebElement searchInput = driver.findElement(searchBox);
        enterText(searchInput, query);
        searchInput.submit();

        // Явное ожидание загрузки результатов поиска
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(searchResults));
        return new SearchResultsPage(driver);
    }
}
