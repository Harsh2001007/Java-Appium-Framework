package org.appiumFramework.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.appiumFramework.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfilePage extends AndroidActions {

    private static final Logger log = LoggerFactory.getLogger(ProfilePage.class);
    AndroidDriver driver;

    public ProfilePage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Name\"]")
    private WebElement profileNameSelector;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Email\"]")
    private WebElement profileEmailSelector;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"First Name*\"]")
    private WebElement firstNameFieldLabelSelector;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last Name*\"]")
    private WebElement lastNameFieldLabel;

    @AndroidFindBy(id = "Edit")
    private WebElement editBtnSelector;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Button\"]")
    private WebElement logoutBtnSelector;

    public String profileNameText(){
         return profileNameSelector.getText();
    }

    public void profileEmailElement(){
         profileEmailSelector.click();
    }

    public String profileEmailText(){
        return profileEmailSelector.getText();
    }

    public void editBtn(){
        editBtnSelector.click();
    }

    public  void logoutBtn(){
        logoutBtnSelector.click();
    }




}
