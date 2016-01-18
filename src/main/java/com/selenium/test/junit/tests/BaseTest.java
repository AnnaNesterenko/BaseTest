package com.selenium.test.junit.tests;

import com.selenium.test.pages.*;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Anna_Nesterenko on 10.01.2016.
 */
public class BaseTest {

    String userEmail = "romawkka@gmail.com";
    String userPassword = "Password1";
    String lastNameForNewLead = "TestLead";
    String defaultStatusName = "New";
    String newStatusName = "NewStatus";

    @Before
    public void beforeTest() {
        WebDriverFactory.getDriver();
    }

    @Test
    public void baseTest() {

        //1. Log into the Web version of Base.
        StartPage startPage = new StartPage();
        HomePage homePage = startPage.logInWithExistedUser(userEmail, userPassword);

        //2. Create a new Lead.
        LeadsPage leadsPage = homePage.navigateToLeadsPage();
        LeadDetailsPage leadDetailsPage = leadsPage.createNewLead(lastNameForNewLead);

        //3. Check that its Lead status is "New"
        String createdLeadStatus = leadDetailsPage.getLeadStatus();
        assertEquals("Incorrect Lead's status is displayed", defaultStatusName, createdLeadStatus);

        //3. Go into Settings / Leads / Lead statuses and change the name of the "New" status to a different name.
        homePage.changeStatusNameTo(newStatusName);

        //4. Go back to the Lead to check if the name change is reflected.
        homePage.navigateToLeadsPage();
        String changedStatusName = leadsPage.getLeadStatus(lastNameForNewLead);
        assertEquals("Incorrect Lead's status is displayed", newStatusName, changedStatusName);

        //post-condition: back system to initial state
        homePage.changeStatusNameTo(defaultStatusName);
        homePage.navigateToLeadsPage();
        leadsPage.cleanLeads();
    }

    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }
}