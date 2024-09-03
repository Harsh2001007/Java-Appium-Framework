package org.appiumFramework.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.appiumFramework.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PickYourCampusPage extends AndroidActions {
    AndroidDriver driver;

    public PickYourCampusPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Search_Icon")
    private WebElement searchBarSelector;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Property_1\"]")
    private WebElement searchedFirstItemSelector;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Button\"]")
    private WebElement continueBtnSelector;

    public void searchBarEntry(String searchItem){
        searchBarSelector.sendKeys(searchItem);
    }

    public void searchFirstItemClick(){
        searchedFirstItemSelector.click();
    }

    public void continueBtnClick(){
        continueBtnSelector.click();
    }
}
