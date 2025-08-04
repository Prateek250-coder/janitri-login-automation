package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Locators
    By userIdField = By.id("email");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//button[contains(text(), 'Login')]");
    By eyeIcon = By.xpath("//button[@aria-label='toggle password visibility']");
    By errorMsg = By.className("error-message"); // You may need to update this

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterUserId(String userId) {
        driver.findElement(userIdField).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public boolean isPasswordMasked() {
        return driver.findElement(passwordField).getAttribute("type").equals("password");
    }

    public void togglePasswordVisibility() {
        driver.findElement(eyeIcon).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}
