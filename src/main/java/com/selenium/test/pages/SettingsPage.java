package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anna_Nesterenko on 12.01.2016.
 */
public class SettingsPage extends BasePage {

    @FindBy(css = "#sidebar>.nav>.leads>a")
    private WebElement leadsMenu;

    @FindBy(css = "a[ data-toggle=\"lead-status\"]")
    private WebElement leadStatusesTab;

//    @FindBy(css = ".named-object-lead:nth-child(1)")
//    private WebElement firstStatus;

    @FindBy(css = ".named-object-lead:nth-child(1) .control-label>h4")
    private WebElement firstStatusName;

    @FindBy(css = ".named-object-lead:nth-child(1) .controls .edit")
    private WebElement firstStatusEdit;

    @FindBy(css = ".item.form:nth-child(1) #name")
    private WebElement nameStatusField;

    @FindBy(css = ".item.form:nth-child(1) .save")
    private WebElement saveStatusNameBtn;

    public SettingsPage() {
        super(false);
    }

    public void openPage() {
    }

    public boolean isPageOpened() {
        return isElementDisplayed(leadsMenu);
    }

    public void openLeadStatuses() {
        clickElement(leadsMenu);
        clickElement(leadStatusesTab);
    }

    public String getCurrentStatusName() {
        String status = firstStatusName.getText();
        return status;
    }

    public void editStatusWithNewName(String NewStatusName) {
        clickElement(firstStatusEdit);
        nameStatusField.clear();
        nameStatusField.sendKeys(NewStatusName);
        clickElement(saveStatusNameBtn);
    }
}
