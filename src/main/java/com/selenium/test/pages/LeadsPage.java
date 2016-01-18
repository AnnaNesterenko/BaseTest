package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anna_Nesterenko on 12.01.2016.
 */
public class LeadsPage extends BasePage {

    @FindBy(css = ".select-all")
    private WebElement selectAllBtn;

    @FindBy(css = ".select-all>span")
    private WebElement selectAllBtnState;

    @FindBy(css = "#leads-more-actions>span>a")
    private WebElement moreBtn;

    @FindBy(css = "#leads-delete")
    private WebElement deleteLead;

    @FindBy(css = ".btn-danger.confirm")
    private WebElement confirmRemoving;

    @FindBy(css = ".help")
    private WebElement noLeadsMsg;

    @FindBy(css = "#leads-new")
    private WebElement addLeadBtn;

    @FindBy(css = ".lead-name")
    private WebElement leadName;

    public LeadsPage() {
        super(false);
    }

    public void openPage() {
    }

    public boolean isPageOpened() {
        return isElementDisplayed(addLeadBtn);
    }

    public boolean isNoLeadsMsgDisplayed() {
        return isElementDisplayed(noLeadsMsg);
//        try {
//            return noLeadsMsg.isDisplayed();
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            return false;
//        }
       // return noLeadsMsg.isDisplayed();
    }

    public void selectAllLeads() {
        clickElement(selectAllBtn);
        if(!selectAllBtnState.getText().equals("1")) {
            throw new AssertionError("All leads not selected");
        }
    }

    public void deleteAllLeads() {
        clickElement(moreBtn);
        clickElement(deleteLead);
        clickElement(confirmRemoving);
    }

    public void cleanLeads() {
        if (!isNoLeadsMsgDisplayed()){
            selectAllLeads();
            deleteAllLeads();
        }
    }

    public NewLeadPage addNewLead() {
        cleanLeads();
        clickElement(addLeadBtn);
        return new NewLeadPage();
    }

    public LeadDetailsPage createNewLead(String Name) {
        NewLeadPage newLeadPage = addNewLead();
        LeadDetailsPage leadDetailsPage = newLeadPage.saveNewLead(Name);
        return leadDetailsPage;
    }

    public String getLeadStatus(String LeadName) {
        if (!leadName.getText().equals(LeadName)){
            throw new AssertionError("Created lead not present");
        } clickElement(leadName);
        LeadDetailsPage leadDetailsPage = new LeadDetailsPage();
        return leadDetailsPage.getLeadStatus();
    }

}