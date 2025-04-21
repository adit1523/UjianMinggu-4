package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement btnReactBurgerMenu;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement btnLogout;

    public void DashboardLogout() {
        this.btnReactBurgerMenu.click();
        this.btnLogout.click();
    }
}
