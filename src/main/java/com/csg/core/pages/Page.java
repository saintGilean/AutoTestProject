package com.csg.core.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by IntelliJ IDEA.
 * User: Grobov
 * Date: 9/07/12
 * Time: 11:42 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Page {
    protected WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
    }
    
    protected void type(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public boolean isElementVisibleOnPage(WebElement element) {
        try{
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public abstract void open();
}
