package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private static WebElement txtCartBadge;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private static WebElement backpack;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private static WebElement tshirt;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private static WebElement shoppingCart;

    @FindBy(xpath = "//button[@id='checkout']")
    private static WebElement checkout;

    public void setCheckout() {
        backpack.click();
        tshirt.click();
        shoppingCart.click();
        checkout.click();
    }

    public String getCartBadge(){
        return txtCartBadge.getText();
    }
}
