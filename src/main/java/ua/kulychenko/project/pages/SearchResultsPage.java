package ua.kulychenko.project.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SearchResultsPage extends BasePage {

    // Локатор для списка видео
    @FindBy(css = "ytd-video-renderer")
    private List<WebElement> videoResults;

    // Конструктор
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод для открытия второго видео сверху в новой вкладке (без переключения на неё).
     */
    public void openSecondResultInNewTab() {
        // Ожидание появления списка видео
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(videoResults));

        // Проверка, что есть как минимум два видео
        if (videoResults.size() >= 2) {
            WebElement secondVideo = videoResults.get(1);

            // Скроллим к элементу, чтобы он стал видимым
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secondVideo);

            // Ожидание, что элемент станет кликабельным
            wait.until(ExpectedConditions.elementToBeClickable(secondVideo));

            // Открываем второе видео в новой вкладке (Ctrl + Click)
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL)
                    .click(secondVideo)
                    .keyUp(Keys.CONTROL)
                    .perform();

            System.out.println("Второе видео открыто в новой вкладке.");
        } else {
            throw new RuntimeException("Недостаточно видео на странице для выбора второго.");
        }
    }

    /**
     * Метод для воспроизведения четвёртого видео сверху.
     */
    public VideoPage playFourthVideo() {
        // Ожидание появления списка видео
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(videoResults));

        // Проверка, что есть как минимум четыре видео
        if (videoResults.size() >= 4) {
            WebElement fourthVideo = videoResults.get(3);

            // Скроллим к четвёртому видео
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fourthVideo);

            // Ожидание, что элемент станет кликабельным
            wait.until(ExpectedConditions.elementToBeClickable(fourthVideo));

            try {
                // Клик по четвёртому видео
                fourthVideo.click();
            } catch (ElementClickInterceptedException e) {
                // Если клик не удался, пробуем выполнить клик через JS
                System.out.println("Элемент перекрыт. Пробуем выполнить клик через JavaScript.");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fourthVideo);
            }

            // Ожидание, что URL изменится и будет содержать "watch"
            wait.until(ExpectedConditions.urlContains("watch"));

            System.out.println("Четвёртое видео успешно запущено.");
            return new VideoPage(driver);
        } else {
            throw new RuntimeException("Недостаточно видео на странице для выбора четвёртого.");
        }
    }
}


