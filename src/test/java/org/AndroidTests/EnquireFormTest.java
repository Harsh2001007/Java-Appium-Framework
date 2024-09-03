package org.AndroidTests;
import org.appiumFramework.pageObjects.android.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.HashMap;
import java.util.List;

public class EnquireFormTest extends BaseTest {

    @Test()
    public void EnquireForm() throws InterruptedException, MalformedInputException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        PickYourCampusPage pickYourCampus = new PickYourCampusPage(driver);
        PropertyDeatilPage propertyDetailPage = new PropertyDeatilPage(driver);
        RoomListingPage roomListingPage = new RoomListingPage(driver);
        EnquireFormPage enquireFormPage = new EnquireFormPage(driver);

//        Actual test automation

        loginPage.emailButtonClick();
        loginPage.emailFieldText("pravin.garg@universityliving.com");
        loginPage.getOtpBtn();
        Thread.sleep(10000);
        loginPage.loginOtpDigits();
        Thread.sleep(5000);

        loginPage.searchCity1();

        loginPage.searchContinueBtn();

        Thread.sleep(5000);

        loginPage.illDoItLaterBtn();

        homepage.searchIconClick();
        pickYourCampus.searchBarEntry("chapter ealing");
        pickYourCampus.continueBtnClick();
        propertyDetailPage.selectRoomBtnClick();

        roomListingPage.enquireBtnClick();



    }



    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//testData//ulAppTestData.json");
        return new Object[][]{{data.get(0)}};
    }
}
