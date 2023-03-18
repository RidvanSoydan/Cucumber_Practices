package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CtisPage {

    public CtisPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="//input[@name='USER_LOGIN']")
    public WebElement userNameBox;

    @FindBy(xpath="//input[@name='USER_PASSWORD']")
    public WebElement userPassBox;

    @FindBy(xpath="//input[@class='login-btn']")
    public WebElement loginButton;

    public void login(String userName, String userPass){
        userNameBox.sendKeys(userName);
        userPassBox.sendKeys(userPass);
        loginButton.click();
    }
}


