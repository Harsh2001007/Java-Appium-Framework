package org.appiumFramework.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.appiumFramework.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EnquireFormPage extends AndroidActions {

    AndroidDriver driver;
    public EnquireFormPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy
    private WebElement dateOfBirthFieldSelector;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"30\"]")
    private WebElement calendarLastItemSelector;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Cancel\"]")
    private WebElement calendarCancelBtnSelector;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Done\"]")
    private WebElement calendarDoneBtnSelector;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Destination University*\"]/android.view.ViewGroup")
    private WebElement destinationCountryFieldSelector;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"Destination_University_Field\"])[1]/android.view.ViewGroup")
    private WebElement univesityAtFirstSelector;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Visa Status*\"]/android.view.ViewGroup")
    private WebElement visaStatusFieldSelector;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Received\"]")
    private WebElement visaStatusReceivedSelector;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"In-process\"]")
    private WebElement visaStatusInProcessSelector;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Need Assistance\"]")
    private WebElement visaStatusNeedAssitanceSelector;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Not Applicable\"]")
    private WebElement visaStatusNotApplicableSelector;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Select Visa Status\"]")
    private WebElement selectYourStatusField;

    @AndroidFindBy(xpath = "//com.horcrux.svg.SvgView")
    private WebElement visaStatusCloseIconSelector;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Best Platform to reach\"]/android.view.ViewGroup")
    private WebElement bestPlatformFieldSelector;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Discord\"]")
    private WebElement discordPlatformSelector;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Platform_Info-Field\"]")
    private WebElement platformIdSelector;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Message_Input_Field\"]")
    private WebElement messageFieldSelector;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Submit\"]")
    private WebElement submitBtnSelector;


    // object methods

    public void destinationCountryFieldClick(String searchItem){
        destinationCountryFieldSelector.click();
    }

    public void universityAtFirstClick(){
        univesityAtFirstSelector.click();
    }

    public void visaStatusFieldClick(){
        visaStatusFieldSelector.click();
    }

    public void visaStatusReceivedClick(){
        visaStatusReceivedSelector.click();
    }

    public void visaStatusInprocessClick(){
        visaStatusInProcessSelector.click();
    }

    public void visaStatusNotApplicableClick(){
        visaStatusNotApplicableSelector.click();
    }

    public void visaStatusNeedAssistanceClick(){
        visaStatusNeedAssitanceSelector.click();
    }

    public void visaStatusSearchFieldClick(){
        selectYourStatusField.click();
    }

    public void visaStatusCloseIconClick(){
        visaStatusCloseIconSelector.click();
    }

    public void bestPlatformFieldClick(){
        bestPlatformFieldSelector.click();
    }

    public void discordOptionClick(){
        discordPlatformSelector.click();
    }

    public void bestPlatformIdEntry(String platformID){
        platformIdSelector.sendKeys(platformID);
    }

}
