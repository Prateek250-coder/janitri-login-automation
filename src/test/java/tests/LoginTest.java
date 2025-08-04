package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldsAreEmpty() {
        LoginPage login = new LoginPage(driver);
        Assert.assertFalse(login.isLoginButtonEnabled(), "Login button should be disabled when fields are empty");
    }

    @Test
    public void testPasswordMaskedButton() {
        LoginPage login = new LoginPage(driver);
        Assert.assertTrue(login.isPasswordMasked(), "Password should be masked initially");
        login.togglePasswordVisibility();
        Assert.assertFalse(login.isPasswordMasked(), "Password should be visible after clicking eye icon");
    }

    @Test
    public void testInvalidLoginShowsErrorMsg() {
        LoginPage login = new LoginPage(driver);
        login.enterUserId("invalid@example.com");
        login.enterPassword("wrongpassword");
        login.clickLogin();

        String error = login.getErrorMessage();
        System.out.println("Error shown: " + error);
        Assert.assertTrue(error.toLowerCase().contains("invalid"), "Expected error message to mention 'invalid'");
    }
}

