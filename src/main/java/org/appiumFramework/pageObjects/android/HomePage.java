package org.appiumFramework.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.appiumFramework.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AndroidActions {
    AndroidDriver driver;

    public  HomePage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

//    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Other_email_signIn']")
//    public WebElement useOtherEmailBtn;

    @AndroidFindBy(id = "Search_Icon")
    private WebElement searchIconSelector;

    public void searchIconClick(){
        searchIconSelector.click();
    }




}
