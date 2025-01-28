package ua.kulychenko.project.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class VideoPage extends BasePage {
    private final By avatarLocator = By.cssSelector(".yt-simple-endpoint.ytd-video-owner-renderer");
    private final By subscribeButtonLocator = By.xpath("//div[@class='yt-spec-button-shape-next__button-text-content'][text()='Подписаться']");
    private By modalLocator = By.xpath("//*[@id='contentWrapper']/ytd-modal-with-title-and-button-renderer");
    private By loginButtonLocator = By.xpath("//*[@id='button']/yt-button-shape/a");

    public VideoPage(WebDriver driver) {
        super(driver);
    }

    // Клик по аватару отправителя
    public void clickAvatar() {
        WebElement avatar = waitForElementToBeVisible(driver.findElement(avatarLocator), 10);
        clickElement(avatar, 10);
    }

    // Клик по кнопке "Подписаться"
    public void clickSubscribe() {
        // Ожидание появления кнопки "Подписаться"
        WebElement subscribeButton = waitForElementToBeVisible(driver.findElement(subscribeButtonLocator), 10);

        // Скроллим к кнопке, чтобы она стала видимой
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subscribeButton);

        // Убедимся, что кнопка находится в области видимости
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(subscribeButton));

        // Используем JavaScript для клика по кнопке, если обычный клик не работает
        try {
            subscribeButton.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Обычный клик не удался, пробуем клик через JavaScript.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", subscribeButton);
        }

        System.out.println("Кнопка 'Подписаться' успешно нажата.");
    }

    // Проверка отображения модального окна с кнопкой "Войти"
//    public boolean isLoginPromptDisplayed() {
//        try {
//            // Ожидание появления модального окна
//            WebElement modal = waitForElementToBeVisible(driver.findElement(modalLocator), 10);
//
//            // Проверка наличия кнопки "Войти" в модальном окне
//            WebElement loginButton = modal.findElement(loginButtonLocator);
//            return loginButton.getAttribute("aria-label").equals("ВОЙТИ");
//        } catch (Exception e) {
//            return false; // Если элемент не найден или модальное окно не появилось
//        }
//    }
    public boolean isLoginPromptDisplayed() {
        try {
            // Ожидание появления модального окна
            WebElement modal = waitForElementToBeVisible(driver.findElement(By.xpath("//*[@id='contentWrapper']/ytd-modal-with-title-and-button-renderer")), 10);

            // Проверка наличия кнопки "Войти" в модальном окне
            WebElement loginButton = modal.findElement(By.xpath("//*[@id='button']/yt-button-shape/a"));

            // Проверка точного соответствия текста в атрибуте aria-label
            String ariaLabelText = loginButton.getAttribute("aria-label");
            if ("ВОЙТИ".equals(ariaLabelText)) {
                System.out.println("Модальное окно отображается, и текст кнопки равен 'ВОЙТИ'.");
                return true;
            } else {
                System.out.println("Модальное окно отображается, но текст кнопки отличается от 'ВОЙТИ'.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Модальное окно не отображается или кнопка 'Войти' отсутствует.");
            return false;
        }
    }

}
