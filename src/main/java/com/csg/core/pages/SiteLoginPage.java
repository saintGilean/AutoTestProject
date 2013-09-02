package com.csg.core.pages;

import com.csg.utils.ConfigProperties;
import com.csg.utils.CustomElementLocatorFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * User: Grobov
 * Date: 17/07/12
 * Time: 11:23 AM
 */
public class SiteLoginPage extends Page{

    @FindBy(id = "wpName1")
    public WebElement fieldUsername;

    @FindBy(id = "wpPassword1")
    public WebElement fieldPassword;

    @FindBy(id = "wpLoginAttempt")
    public WebElement buttonLogin;

    public SiteLoginPage(WebDriver driver) {
        super(driver);
        //set custom waiter for this page with ajax
        PageFactory.initElements(new CustomElementLocatorFactory(driver, 60), this);
    }

    private void login(String login, String password){
        type(fieldUsername, login);
        type(fieldPassword, password);
        buttonLogin.click();
    }

    public SiteHomePage loginSuccess(String login, String password) {
        login(login, password);
        return PageFactory.initElements(driver, SiteHomePage.class);
    }

    public SiteLoginPage loginFail(String login, String password) {
        login(login, password);
        return PageFactory.initElements(driver, SiteLoginPage.class);
    }

    public boolean isErrorLogin() {
        return isElementVisibleOnPage(fieldUsername);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("SiteLogin.url")+"/w/index.php?title=Special:UserLogin&returnto=Main+Page");
    }
}
