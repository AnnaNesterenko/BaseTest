package com.selenium.test.webtestsbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

/**
 * Created by Anna_Nesterenko on 10.01.2016.
 */
public abstract class BasePage {
   // protected static final int WAIT_FOR_PAGE_LOAD_IN_SECONDS = 10;

    WebDriverWait wait = new WebDriverWait(getDriver(), 5);

    protected abstract void openPage();

    public abstract boolean isPageOpened();

    public BasePage(boolean openPageByUrl) {
        if (openPageByUrl) {
            openPage();
        }
        PageFactory.initElements(getDriver(), this);
        waitForOpen();
    }

    protected void waitForOpen() {
        getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        int secondsCount = 0;
        //boolean isPageOpenedIndicator = isPageOpened();
//        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOAD_IN_SECONDS) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            secondsCount++;
//            isPageOpenedIndicator = isPageOpened();
//        }
        if (!isPageOpened()) {
            throw new AssertionError("Page "+this.getClass().getSimpleName()+" was not opened");
        }
    }

    protected WebDriver getDriver() {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public boolean isElementDisplayed (WebElement element){
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

//    public void waitForElementIsVisible(WebElement element){
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }

    public void clickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}