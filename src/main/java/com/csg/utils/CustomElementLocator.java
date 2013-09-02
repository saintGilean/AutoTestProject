package com.csg.utils;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;

public class CustomElementLocator extends AjaxElementLocator {
    public CustomElementLocator(WebDriver driver, Field field, int timeOutInSeconds) {
        super(driver, field, timeOutInSeconds);
    }

    protected boolean isElementUsable(WebElement element) {
        return element.isDisplayed();
    }
}
