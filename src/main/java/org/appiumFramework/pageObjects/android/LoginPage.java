package org.appiumFramework.pageObjects.android;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.appiumFramework.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends AndroidActions {
    AndroidDriver driver;


    public  LoginPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Other_email_signIn']")
    public WebElement useOtherEmailBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Email']")
    private WebElement emailField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='OTP_Button']")
    private WebElement getOtpBtnSelector;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"City_1\"]")
    private  WebElement searchCityOneSelector;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Continue\"]")
    private WebElement searchContinueBtnSelector;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"I'll do it later\"]")
    private WebElement illDoItLaterSelector;

    @AndroidFindBy(accessibility = "Hamburger_Icon")
    private WebElement hamburgerSelector;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Test Test, pravin.garg@universityliving.com']")
    private WebElement profileIconSelector;


    public void emailButtonClick(){
        useOtherEmailBtn.click();
    }

    public void emailFieldText(String loginEmail){
        emailField.sendKeys(loginEmail);
    }

    public void getOtpBtn(){
        getOtpBtnSelector.click();
    }

    public void loginOtpDigits(){
        driver.findElement(By.xpath("(//android.widget.EditText[@content-desc='Input_Field'])[1]")).sendKeys("1");
        driver.findElement(By.xpath("(//android.widget.EditText[@content-desc='Input_Field'])[2]")).sendKeys("2");
        driver.findElement(By.xpath("(//android.widget.EditText[@content-desc='Input_Field'])[3]")).sendKeys("3");
        driver.findElement(By.xpath("(//android.widget.EditText[@content-desc='Input_Field'])[4]")).sendKeys("4");
        driver.findElement(By.xpath("(//android.widget.EditText[@content-desc='Input_Field'])[5]")).sendKeys("5");
    }

    public void searchCity1(){
        searchCityOneSelector.click();
    }

    public void searchContinueBtn(){
        searchContinueBtnSelector.click();
    }

    public void illDoItLaterBtn(){
        illDoItLaterSelector.click();
    }

    public void hamburger(){
        hamburgerSelector.click();
    }

    public void profileIcon(){
        profileIconSelector.click();
    }
//    public void scrollingToGetText( String nameOfProperty){
//        scrollToText(nameOfProperty);
//    }



}
