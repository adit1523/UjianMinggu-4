package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    private WebDriver driver;

    public InventoryPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[@data-test='error']")
    private static WebElement txtInvalidForm;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement complete;


    public void form(String firstName, String lastName, String postalCode) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
    }

    public void setContinueButton(){
        continueButton.click();
    }

    public void setFinishButton(){
        finishButton.click();
    }

    public String getTxtSuccesfull() {

        return complete.getText();
    }

    public String getTxtInvalidForm(){
        return txtInvalidForm.getText();
    }
}
