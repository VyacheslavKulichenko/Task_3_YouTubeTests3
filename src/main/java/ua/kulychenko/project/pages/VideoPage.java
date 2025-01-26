package ua.kulychenko.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



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
        WebElement subscribeButton = waitForElementToBeVisible(driver.findElement(subscribeButtonLocator), 10);
        clickElement(subscribeButton, 10);
    }

    // Проверка отображения модального окна с кнопкой "Войти"
    public boolean isLoginPromptDisplayed() {
        try {
            // Ожидание появления модального окна
            WebElement modal = waitForElementToBeVisible(driver.findElement(modalLocator), 10);

            // Проверка наличия кнопки "Войти" в модальном окне
            WebElement loginButton = modal.findElement(loginButtonLocator);
            return loginButton.getAttribute("aria-label").equals("ВОЙТИ");
        } catch (Exception e) {
            return false; // Если элемент не найден или модальное окно не появилось
        }
    }
}
