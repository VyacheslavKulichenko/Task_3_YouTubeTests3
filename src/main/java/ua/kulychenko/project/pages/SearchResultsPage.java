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

    // Локатор для выпадающего списка предложений
    //private final By suggestionBoxLocator = By.xpath("//*[@id='center']/yt-searchbox/div[2]");
    private final By searchSuggestionsLocator = By.xpath("//div[@role='listbox' and @class='ytSearchboxComponentSuggestionsContainer' and @style='min-width: 536px; margin-left: 0px;']");


    // Локатор для всех элементов в списке предложений
    private final By suggestionItemsLocator = By.cssSelector(".ytSuggestionComponentSuggestion");

    // Локатор для списка видео результатов
    private final By videoResultsLocator = By.cssSelector("ytd-video-renderer");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Выбор второй позиции в выпадающем списке предложений.
     */
//    public void selectSecondSuggestion() {
//        // Ожидание появления выпадающего списка
//        WebElement suggestionBox = waitForElementToBeVisible(driver.findElement(suggestionBoxLocator), 10);
//
//        // Получаем все элементы в списке
//        List<WebElement> suggestionItems = suggestionBox.findElements(suggestionItemsLocator);
//
//        // Проверяем, что есть хотя бы две позиции
//        if (suggestionItems.size() >= 2) {
//            WebElement secondSuggestion = suggestionItems.get(1);
//
//            // Скроллим к элементу
//            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secondSuggestion);
//
//            // Кликаем по элементу
//            clickElement(secondSuggestion, 10);
//            System.out.println("Выбрана вторая позиция в списке предложений.");
//        } else {
//            throw new RuntimeException("Недостаточно элементов в списке предложений для выбора второй позиции.");
//        }
//    }

//    /**
// * Метод для выбора второй подсказки из выпадающего списка.
// */
//public void selectSecondSuggestion() {
//    // Ожидание появления выпадающего списка с подсказками
////    List<WebElement> suggestions = new WebDriverWait(driver, Duration.ofSeconds(10000))
////            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchSuggestionsLocator));
//    List<WebElement> suggestions = waitForElementsToBeVisible(suggestionItemsLocator, 10);
//
//    // Проверка, что есть как минимум две подсказки
//    if (suggestions.size() >= 2) {
//        WebElement secondSuggestion = suggestions.get(1);
//
//        // Клик по второй подсказке
//        clickElement(secondSuggestion, 10);
//
//        System.out.println("Кликнули по второй подсказке в списке.");
//    } else {
//        throw new RuntimeException("Недостаточно подсказок в списке для выбора второй позиции.");
//    }
//}

    /**
     * Метод для воспроизведения четвёртого видео сверху.
     */
//    public VideoPage playFourthVideo() {
//        // Ожидание появления списка видео
//        List<WebElement> videoResults = waitForElementsToBeVisible(videoResultsLocator, 10);
//
//        // Проверяем, что есть как минимум четыре видео
//        if (videoResults.size() >= 4) {
//            WebElement fourthVideo = videoResults.get(3);
//
//            // Скроллим к четвёртому видео
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fourthVideo);
//
//            // Ожидаем, что элемент станет кликабельным, и кликаем
//            clickElement(fourthVideo, 10);
//            //((JavascriptExecutor) driver).executeScript("arguments[0].click();", fourthVideo);
//
//            System.out.println("Четвёртое видео успешно запущено.");
//            return new VideoPage(driver);
//        } else {
//            throw new RuntimeException("Недостаточно видео на странице для выбора четвёртого.");
//        }
//    }
//    public VideoPage playFourthVideo() {
//        // Ожидание появления списка видео
//        List<WebElement> videoResults = waitForElementsToBeVisible(videoResultsLocator, 10);
//
//        // Проверяем, что есть как минимум четыре видео
//        if (videoResults.size() >= 4) {
//            WebElement fourthVideo = videoResults.get(3);
//
//            // Скроллим к четвёртому видео
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fourthVideo);
//
//            // Убедимся, что элемент не перекрыт всплывающими окнами
//            try {
//                waitForElementToBeClickable(fourthVideo, 10); // Убедимся, что видео кликабельно
//            } catch (TimeoutException e) {
//                System.out.println("Элемент не стал кликабельным. Проверяем возможные перекрытия...");
//
//                // Проверяем наличие блокирующего элемента
//                WebElement blockingElement = driver.findElement(By.tagName("ytd-video-preview"));
//                if (blockingElement.isDisplayed()) {
//                    System.out.println("Блокирующий элемент найден. Пытаемся его закрыть.");
//                    ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", blockingElement);
//                }
//            }
//
//            // Кликаем по видео
//            clickElement(fourthVideo, 10);
//
//            System.out.println("Четвёртое видео успешно запущено.");
//            return new VideoPage(driver);
//        } else {
//            throw new RuntimeException("Недостаточно видео на странице для выбора четвёртого.");
//        }
//    }

//    public VideoPage playFourthVideo() {
//        // Ожидание появления списка видео
//        List<WebElement> videoResults = waitForElementsToBeVisible(videoResultsLocator, 10);
//
//        // Проверяем, что есть как минимум четыре видео
//        if (videoResults.size() >= 4) {
//            WebElement fourthVideo = videoResults.get(3);
//
//            // Скроллим к четвёртому видео
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fourthVideo);
//
//            // Ждём, пока видео станет кликабельным
//            WebElement clickableVideo = waitForElementToBeClickable(fourthVideo, 10);
//
//            // Кликаем по видео
//            clickableVideo.click();
//
//            System.out.println("Четвёртое видео успешно запущено.");
//            return new VideoPage(driver);
//        } else {
//            throw new RuntimeException("Недостаточно видео на странице для выбора четвёртого.");
//        }
//    }
    public VideoPage playFourthVideo() {
        // Ожидание появления списка видео
        List<WebElement> videoResults = waitForElementsToBeVisible(videoResultsLocator, 10);

        // Проверяем, что есть как минимум четыре видео
        if (videoResults.size() >= 4) {
            WebElement fourthVideo = videoResults.get(3);

            // Скроллим к четвёртому видео
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fourthVideo);

            // Ждём, пока видео станет кликабельным
            WebElement clickableVideo = waitForElementToBeClickable(fourthVideo, 10);

            // Кликаем по видео
            clickableVideo.click();

            // Для проверки что видео действительно запустилось, проверяем что URL изменится на тот, который содержит "watch"
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            boolean isVideoPlaying = wait.until(ExpectedConditions.urlContains("watch"));

            if (isVideoPlaying) {
                System.out.println("Четвёртое видео успешно запущено.");
                return new VideoPage(driver);
            } else {
                throw new RuntimeException("Не удалось запустить четвёртое видео. URL не изменился на 'watch'.");
            }
        } else {
            throw new RuntimeException("Недостаточно видео на странице для выбора четвёртого.");
        }
    }
}




