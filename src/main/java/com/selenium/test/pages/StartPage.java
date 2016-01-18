package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anna_Nesterenko on 12.01.2016.
 */
public class StartPage extends BasePage {

    private static final String BASE_URL = "https://getbase.com/";

    @FindBy(css = ".show-for-large-up:nth-child(1)>a")
    private WebElement logInBtn;

    public StartPage() {
        super(true);
    }

    public void openPage() {
        getDriver().get(BASE_URL);
    }

    public boolean isPageOpened() {
        return isElementDisplayed(logInBtn);
    }

    public LogInPage navigateToLogInPage() {
        clickElement(logInBtn);
        return new LogInPage();
    }

    public HomePage logInWithExistedUser(String Email, String Password) {
        LogInPage logInPage = navigateToLogInPage();
        return logInPage.logInAs(Email, Password);
    }
}
