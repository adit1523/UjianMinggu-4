package com.juaracoding;

import com.juaracoding.pages.InventoryPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import okhttp3.internal.Util;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.juaracoding.Hooks.extentTest;

public class LoginTest {
    private static WebDriver driver;
    private static LoginPage loginPage = new LoginPage();
    private static InventoryPage inventoryPage = new InventoryPage();

    public LoginTest(){
        driver = Hooks.driver;
        extentTest = extentTest;
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS,"I am on the login page");
    }
    @When("I enter a valid username and password")
    public void i_enter_a_valid_username_and_password(){
        loginPage.clearTextBoxes();
        loginPage.loginUsernamePassword("standard_user","secret_sauce");
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"I enter a valid username and password");
    }
    @And("I click the login button")
    public void i_click_the_login_button(){
        loginPage.setBtnlogin();
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"I click the login button");
    }
    @Then("I should be redirected to dashboard page")
    public void i_should_be_redirected_to_dashboard_page(){
        Assert.assertEquals(loginPage.getTxtDashboard(),"Products");
        extentTest.log(LogStatus.PASS,"I should be redirected to dashboard page");
    }
    @Given("I am logout")
    public void i_am_logout(){
        Utils.delay(2);
        loginPage.setBtnLogout();
        extentTest.log(LogStatus.PASS,"I am logout");
    }
    @When("I enter a invalid username and password")
    public void i_enter_a_invalid_username_and_password(){
        loginPage.loginUsernamePassword("userinvalid","passwordinvalid");
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"I enter a invalid username and password");
    }
    @And("I click login button")
    public void i_click_login_button(){
        loginPage.setBtnlogin();
        extentTest.log(LogStatus.PASS,"I click the login button");
    }
    @Then("I see message invalid credentials")
    public void i_see_message_invalid_credentials(){
        Assert.assertEquals(loginPage.getTxtInvalid(),"Epic sadface: Username and password do not match any user in this service");
        extentTest.log(LogStatus.PASS,"I see message invalid credentials");
    }
}
