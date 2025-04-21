package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement btnlogin;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement txtDashboard;

    @FindBy(css = "h3[data-test='error']")
    private WebElement txtInvalid;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement btnReactBurgerMenu;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement btnLogout;

    public void clearTextBoxes(){
        usernameField.clear();
        passwordField.clear();
    }

    public void loginUsernamePassword(String username, String password){
        this.usernameField.sendKeys(username);
        this.passwordField.sendKeys(password);
    }
    public void setBtnlogin(){
        btnlogin.click();
    }
    public String getTxtDashboard(){

        return txtDashboard.getText();
    }
    public String getTxtInvalid(){

        return txtInvalid.getText();
    }
    public void setBtnLogout(){
        btnReactBurgerMenu.click();
        btnLogout.click();
    }
}
