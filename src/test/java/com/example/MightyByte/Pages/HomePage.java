package com.example.MightyByte.Pages;

import com.example.MightyByte.Base.BasePage;
import com.example.MightyByte.stepDefinitions.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HomePage {
    Logger logger = LoggerFactory.getLogger(Steps.class);
    @FindBy(xpath = "//div[@class=\"login_btn\"]")
    WebElement loginButtonUi;

    String selectCalTypeLocator = "//div[contains(@class,'__classcalc-desktop-taskbar ')]//div[@id='__classcalc-calc-options-controller']";

    String calTypesLocator = "//div[contains(@class,'__classcalc-desktop-taskbar ')]//ul[@id='calc-options-list']/li/a/span";

    String typeScientificLocator = "//div[@class='sc-kLIISr espGTq']";

    String typeGraphingLocator = "//div[@class='sc-kaNhvL ddSbZh']";

    String typeMatrixLocator = "//div[@class='sc-cooIXK grdCsm']";

    String typeBasicLocator = "//div[@class='sc-jXQZqI kLkZbY']";

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);}

    public void waitForPageLoad(){
        try {
            wait.until(ExpectedConditions.visibilityOf(loginButtonUi));
            logger.info("Switching to iframe");
            driver.switchTo().frame(0);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectCalTypeLocator)));
        } catch (NullPointerException e){
            e.getStackTrace();
            logger.error(e.toString());
        }

    }

    public void clickButton(String buttonName) {
        try {
            List<WebElement> calTypesLocators = driver.findElements(By.xpath(calTypesLocator));
            switch (buttonName.toLowerCase()) {
                case "login":
                    logger.info("Switching out of iframe");
                    driver.switchTo().defaultContent();
                    loginButtonUi.click();
                    logger.info("Switching to iframe");
                    driver.switchTo().frame(0);
                    break;
                case "typedropdown":
                    WebElement tempEle = driver.findElement(By.xpath(selectCalTypeLocator));
                    wait.until(ExpectedConditions.visibilityOf(tempEle));
                    driver.findElement(By.xpath(selectCalTypeLocator)).click();
                    break;
                case "scientific":
                case "matrix":
                case "graphing":
                case "basic":
                    for (WebElement calType : calTypesLocators) {
                        if (calType.getText().equalsIgnoreCase(buttonName)) {
                            calType.click();
                            break;
                        }
                    }
                    break;

            }
        }catch (NullPointerException e){
            e.getStackTrace();
            logger.error(e.toString());
        }
    }


    public Boolean verifyCalType(String type){
        try {
            switch (type.toLowerCase()) {
                case "scientific":
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(typeScientificLocator)));
                    return driver.findElement(By.xpath(typeScientificLocator)).isDisplayed();
                case "graphing":
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(typeGraphingLocator)));
                    return driver.findElement(By.xpath(typeGraphingLocator)).isDisplayed();
                case "matrix":
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(typeMatrixLocator)));
                    return driver.findElement(By.xpath(typeMatrixLocator)).isDisplayed();
                case "basic":
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(typeBasicLocator)));
                    return driver.findElement(By.xpath(typeBasicLocator)).isDisplayed();
            }
        }catch (NullPointerException e){
            e.getStackTrace();
            logger.error(e.toString());
        }
        return false;

    }
}
