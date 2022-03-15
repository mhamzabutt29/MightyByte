package com.example.MightyByte.stepDefinitions;

import com.example.MightyByte.Base.BasePage;
import com.example.MightyByte.Browser.Browser;
import com.example.MightyByte.MightyByteApplication;
import com.example.MightyByte.Pages.HomePage;
import com.example.MightyByte.Pages.LoginPopUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration( classes = MightyByteApplication.class)
public class Steps extends BasePage {
    Logger logger = LoggerFactory.getLogger(Steps.class);
    @Autowired
    Browser browser;

    LoginPopUp loginPopUp;

    HomePage homePage;
    WebDriverWait wait;
    WebDriver driver;

    @Before
    public void beforeScenario(){
        browser.setDriver();
        driver = browser.getDriver();
        setWait(driver);
        wait = getWait();
        browser.openUrl();
    }

    @After
    public void afterScenario(){
        Assert.assertEquals("Driver closed and quit", browser.closeDriver());
    }

    @Given("^I am on class calc login popup$")
    public void iAmOnClassCalcLoginPopUp()  {
        homePage = new HomePage(driver, wait);
        homePage.waitForPageLoad();
        homePage.clickButton("login");
        logger.info("Switching out of iframe");
        driver.switchTo().defaultContent();
        loginPopUp = new LoginPopUp(driver, wait);
        loginPopUp.waitForPageLoad();
        Assert.assertEquals("Login", loginPopUp.verifyLoginPopUp());
    }

    @Given("^I am on class calc home page$")
    public void iAmOnClassicCalcHomePage(){
        homePage = new HomePage(driver, wait);
        homePage.waitForPageLoad();
    }

    @When("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterCredential(String username, String password){
        logger.info("Switching out of iframe");
        driver.switchTo().defaultContent();
        loginPopUp.enterValue("username", username);
        loginPopUp.enterValue("password", password);

    }

    @And("^I click \"(Login|typeDropdown)\"$")
    public void iClickButton(String buttonName) {
        if(buttonName.equalsIgnoreCase("Login")) {
            logger.info("Switching out of iframe");
            driver.switchTo().defaultContent();
            loginPopUp.clickButton(buttonName);
        }
        else
            homePage.clickButton(buttonName);

    }

    @Then("^I am shown validation ([^\"]*)$")
    public void iAmShownValidationMessage(String message){
        String messageFromUi = loginPopUp.verifyValidationMessageDisplayed();
        Assert.assertEquals(message, messageFromUi);
    }

    @And("^I click dropdown ([^\"]*)$")
    public void iClickDropdownButton(String buttonName) {
        homePage.clickButton(buttonName);
    }

    @And("^I am shown calculator changed to ([^\"]*)$")
    public void iAmShownCalculatorChangedTo(String type){
        Assert.assertEquals(true, homePage.verifyCalType(type));
    }


}
