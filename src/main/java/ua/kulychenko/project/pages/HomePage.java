package ua.kulychenko.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    private final By searchBoxLocator = By.name("search_query");
    private final By searchSuggestionsLocator = By.cssSelector(".ytSuggestionComponentSuggestion");
    private final By searchButtonLocator = By.id("search-icon-legacy");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Метод для выполнения поиска с учетом клика по второй подсказке из выпадающего списка.
     *
     * @param query запрос для ввода в строку поиска
     * @return объект страницы результатов поиска (SearchResultsPage)
     */
    public SearchResultsPage search(String query) throws InterruptedException {
        // Ввод текста в строку поиска
        WebElement searchBox = waitForElementToBeVisible(driver.findElement(searchBoxLocator), 10);
        enterText(searchBox, query);
        // Разворачиваем браузер на весь экран
        maximizeWindow();
        // Ожидание появления выпадающего списка с подсказками
        List<WebElement> suggestions = waitForElementsToBeVisible(searchSuggestionsLocator, 10);

        // Проверка, что есть как минимум две подсказки
        if (suggestions.size() >= 2) {
            WebElement secondSuggestion = suggestions.get(1);

            Thread.sleep(4000); // Использую здесь Thread.sleep только для того что бы продемонстрировать что выбирается действительно вторая позиция сверху
            // Клик по второй подсказке
            clickElement(secondSuggestion, 10);

            System.out.println("Кликнули по второй подсказке в списке.");
        } else {
            throw new RuntimeException("Недостаточно подсказок в списке для выбора второй позиции.");
        }

        // Возврат новой страницы результатов поиска
        return new SearchResultsPage(driver);
    }
}