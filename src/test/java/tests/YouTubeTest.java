package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.kulychenko.project.pages.HomePage;
import ua.kulychenko.project.pages.SearchResultsPage;
import ua.kulychenko.project.pages.VideoPage;


import java.util.Random;

public class YouTubeTest extends BaseTest {

    @Test
    public void testYouTubeActions() {
        driver.get("https://www.youtube.com/");

        // Инициализация главной страницы
        HomePage homePage = new HomePage(driver);
        homePage.waitForPageTitle("YouTube", 10);

        // Проверка заголовка страницы
        Assert.assertEquals(homePage.getPageTitle(), "YouTube");

        // Генерация случайного числа для поиска (2-4 цифры)
        Random random = new Random();
        int queryLength = 2 + random.nextInt(3);  // Рандомно выбираем длину числа (2, 3 или 4 цифры)
        int lowerBound = (int) Math.pow(10, queryLength - 1);  // Нижняя граница для числа с выбранной длиной
        int upperBound = (int) Math.pow(10, queryLength) - 1;  // Верхняя граница для числа с выбранной длиной

// Генерируем случайное число с нужной длиной
        String query = String.valueOf(lowerBound + random.nextInt(upperBound - lowerBound + 1));


        // Выполнение поиска
        SearchResultsPage searchResultsPage = homePage.search(query);

        // Открытие второго видео в новой вкладке
        searchResultsPage.openSecondResultInNewTab();

        // Воспроизведение четвёртого видео
        VideoPage videoPage = searchResultsPage.playFourthVideo();

        // Действия на странице видео
        videoPage.clickAvatar(); // Клик на аватар отправителя
        videoPage.clickSubscribe(); // Клик на кнопку "Подписаться"

        // Проверка отображения модального окна с кнопкой "Войти"
        Assert.assertTrue(videoPage.isLoginPromptDisplayed(), "Модальное окно с кнопкой 'Войти' не отображается.");

        // Закрытие текущей вкладки
        homePage.closeCurrentTab();
    }
}