package com.juaracoding;

import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.DashboardPage;
import com.juaracoding.pages.InventoryPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.internal.Util;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InventoryTest {
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static InventoryPage inventoryPage = new InventoryPage();
    private static DashboardPage dashboardPage = new DashboardPage();
    private static CheckoutPage checkoutPage = new CheckoutPage();

    public InventoryTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("I am login swag labs")
    public void i_am_login_swag_labs(){
        driver.get(Constants.URL);
        loginPage.loginUsernamePassword("standard_user","secret_sauce");
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"I enter username and password");
    }

    @When("I click login")
    public void i_click_login(){
        Utils.delay(2);
        loginPage.setBtnlogin();
        extentTest.log(LogStatus.PASS,"I click login button");
    }

    @And("I click product and checkout")
    public void i_click_product(){
        Utils.delay(2);
        checkoutPage.setCheckout();
        Assert.assertEquals(checkoutPage.getCartBadge(),"2");
        extentTest.log(LogStatus.PASS,"I click product and checkout");
    }

    @And("I fill form checkout")
    public void i_fill_form_checkout(){
        Utils.delay(2);
        inventoryPage.form("Respati","Adhitya","1523");
        inventoryPage.setContinueButton();
        inventoryPage.setFinishButton();
        extentTest.log(LogStatus.PASS,"I fill form checkout");
    }

    @Then("I see message thank you for your order")
    public void i_see_message_thank_you_for_your_order(){
        Utils.delay(2);
        Assert.assertEquals(inventoryPage.getTxtSuccesfull(),"Thank you for your order!");
        extentTest.log(LogStatus.PASS,"I see message thank you for your order");
    }

    @Given("I go to logout")
    public void i_go_to_logout(){
        dashboardPage.DashboardLogout();
        extentTest.log(LogStatus.PASS,"I am logout");
    }

    @When("I go to checkout")
    public void i_go_to_checkout(){
        loginPage.loginUsernamePassword("standard_user","secret_sauce");
        loginPage.setBtnlogin();
        Utils.delay(3);
        checkoutPage.setCheckout();
        extentTest.log(LogStatus.PASS,"I go to checkout");
    }

    @And("I am not input form checkout")
    public void i_am_not_input_form_checkout(){
        Utils.delay(2);
        inventoryPage.form("","","");
        inventoryPage.setContinueButton();
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"I didnt input form checkout");
    }

    @Then("I see message first name is required")
    public void i_see_message_first_name_is_required(){
        Utils.delay(2);
        Assert.assertEquals(inventoryPage.getTxtInvalidForm(),"Error: First Name is required");
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"I see message first name is required");
    }

    @Given("I am logout after see message invalid")
    public void i_am_logout_after_see_message_invalid(){
        dashboardPage.DashboardLogout();
    }
}
