package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anna_Nesterenko on 12.01.2016.
 */
public class LeadDetailsPage extends BasePage {

    @FindBy(css = ".lead-status")
    private WebElement leadStatus;

    public LeadDetailsPage() {
        super(false);
    }

    public void openPage() {
    }

    public boolean isPageOpened() {
        return isElementDisplayed(leadStatus);
    }

    public String getLeadStatus() {
        return leadStatus.getText();
    }
}
