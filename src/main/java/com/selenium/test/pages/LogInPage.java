package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anna_Nesterenko on 12.01.2016.
 */
public class LogInPage extends BasePage {

    @FindBy(css = "#user_email")
    private WebElement emailField;

    @FindBy(css = "#user_password")
    private WebElement passwordField;

    @FindBy(css = ".btn-primary")
    private WebElement logInBtn;

    public LogInPage() {
        super(false);
    }

    public void openPage() {
    }

    public boolean isPageOpened() {
        return isElementDisplayed(emailField);
    }

    public HomePage logInAs(String ExistedEmail, String ExistedPassword) {
        emailField.sendKeys(ExistedEmail);
        passwordField.sendKeys(ExistedPassword);
        clickElement(logInBtn);
        return new HomePage();
    }
}
