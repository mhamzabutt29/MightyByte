package com.example.MightyByte.Pages;

import com.example.MightyByte.Base.BasePage;
import com.example.MightyByte.stepDefinitions.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPopUp {
    Logger logger = LoggerFactory.getLogger(Steps.class);
    @FindBy(xpath = "//div[(contains(text(),'Login'))]")
    WebElement loginPopUpHeading;

    @FindBy(xpath = "//div[@class='popup_div_login display_block']//input[@placeholder='Email']")
    WebElement usernameFieldUi;

    @FindBy(css = "#loginPassword")
    WebElement passwordFieldUi;

    @FindBy(xpath = "//div[contains(text(),'Invalid')] | //div[contains(text(),'You cannot leave blank')] | //div[contains(text(),'required')]")
    WebElement validationMessage;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButtonUi;

    WebDriver driver;
    WebDriverWait wait;

    public LoginPopUp(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver, this);
    }


    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOf(loginPopUpHeading));
        wait.until(ExpectedConditions.visibilityOf(usernameFieldUi));
        wait.until(ExpectedConditions.visibilityOf(passwordFieldUi));
        wait.until(ExpectedConditions.visibilityOf(loginButtonUi));
    }

    public String verifyLoginPopUp(){
        String text;
        try{

            wait.until(ExpectedConditions.visibilityOf(loginPopUpHeading));
            text = loginPopUpHeading.getText();
        }catch (NullPointerException e){
            e.getStackTrace();
            return e.toString();
        }
        return text;
    }

    public String verifyValidationMessageDisplayed(){
        String message;
        try {
            wait.until(ExpectedConditions.visibilityOf(validationMessage));
            message = validationMessage.getText();
        } catch (NullPointerException e){
            e.getStackTrace();
            return e.toString();
        }
        return message;
    }

    public void enterValue(String textBox, String value){
        switch (textBox.toLowerCase()){
            case "username":
                usernameFieldUi.sendKeys(value);
                break;
            case "password":
                passwordFieldUi.sendKeys(value);
                break;
        }
    }

    public void clickButton(String buttonName){
        switch (buttonName.toLowerCase()){
            case "login":
                loginButtonUi.click();
                break;
        }
    }


}
