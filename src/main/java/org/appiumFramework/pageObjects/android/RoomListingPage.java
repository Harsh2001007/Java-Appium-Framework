package org.appiumFramework.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.appiumFramework.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RoomListingPage extends AndroidActions {
    AndroidDriver driver;

    public RoomListingPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"Enquire\"])[1]")
    private WebElement enquireBtnSelector;

    public void enquireBtnClick(){
        enquireBtnSelector.click();
    }


}
