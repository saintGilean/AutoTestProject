package com.csg.core.pages;

import com.csg.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * User: Grobov
 * Date: 12/07/12
 * Time: 3:31 PM
 */
public class SiteHomePage extends Page {
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    private WebElement linkLogOut;

    public SiteHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedIn() {
        return isElementVisibleOnPage(linkLogOut);
    }

    public SiteHomeBeforeLoginPage logOut() {
        linkLogOut.click();
        return PageFactory.initElements(driver, SiteHomeBeforeLoginPage.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("SiteLogin.url")+"/wiki/Main_Page");
    }
}
