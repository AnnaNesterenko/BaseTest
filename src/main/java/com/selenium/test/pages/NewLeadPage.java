package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anna_Nesterenko on 12.01.2016.
 */
public class NewLeadPage extends BasePage {
    public static final String LAST_NAME = "TestLead";

    @FindBy(css = "#lead-last-name")
    private WebElement lastNameField;

    @FindBy(css = ".save")
    private WebElement saveBtn;

    public NewLeadPage() {
        super(false);
    }

    public void openPage() {
    }

    public boolean isPageOpened() {
        return isElementDisplayed(lastNameField);
    }

    public LeadDetailsPage saveNewLead(String LastName) {
        lastNameField.sendKeys(LastName);
        clickElement(saveBtn);
        return new LeadDetailsPage();
    }
}
