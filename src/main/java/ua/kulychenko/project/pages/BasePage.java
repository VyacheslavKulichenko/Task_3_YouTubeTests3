package ua.kulychenko.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Ожидание появления элемента
    protected WebElement waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Для ожидания загрузки страницы с определенным заголовком
    public void waitForPageTitle(String expectedTitle, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.titleIs(expectedTitle));
    }

    // Клик по элементу с ожиданием
    protected void clickElement(WebElement element, int timeoutInSeconds) {
        waitForElementToBeVisible(element, timeoutInSeconds).click();
    }

    // Получение заголовка страницы
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Ввод текста в поле с очисткой
    protected void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    //Сделать браузер во весь экран
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    //Закрыть текущую вкладку браузера
    public void closeCurrentTab() {
        driver.close();
    }
}
