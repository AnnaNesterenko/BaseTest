package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anna_Nesterenko on 10.01.2016.
 */
public class HomePage extends BasePage {

    @FindBy(css = "#nav-leads")
    private WebElement leadsBtn;

    @FindBy(css = ".dropdown-toggle[data-original-title=\"Settings\"]")
    private WebElement settingsBtn;

    @FindBy(css = ".settings>a[href=\"/settings/profile\"]")// or .icon-cog
    private WebElement settingsMenu;

    public HomePage() {
        super(false);
    }

    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return isElementDisplayed(leadsBtn);
    }

    public LeadsPage navigateToLeadsPage(){
        clickElement(leadsBtn);
        return new LeadsPage();
    }

    public SettingsPage navigateToSettingsPage(){
        clickElement(settingsBtn);
        clickElement(settingsMenu);
        return new SettingsPage();
    }

    public void changeStatusNameTo(String defaultStatusName) {
        String currentStatusName;
        SettingsPage settingsPage = navigateToSettingsPage();
        settingsPage.openLeadStatuses();
        currentStatusName = settingsPage.getCurrentStatusName();
        if (!currentStatusName.equals(defaultStatusName)) {
            settingsPage.editStatusWithNewName(defaultStatusName);
        }
    }
}