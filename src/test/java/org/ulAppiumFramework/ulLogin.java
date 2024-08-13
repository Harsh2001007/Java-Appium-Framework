package org.ulAppiumFramework;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.appiumFramework.pageObjects.android.LoginPage;
import org.appiumFramework.pageObjects.android.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ulLogin extends BaseTest {

    @Test(dataProvider="getData")
    public void AppLogin(HashMap<String,String> inputs) throws InterruptedException, MalformedInputException {


        LoginPage loginpage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        Assert.assertTrue(loginpage.useOtherEmailBtn.isDisplayed());
        loginpage.emailButtonClick();
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Email']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='OTP_Button']")).isDisplayed());
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("Heading")).getText(),"Verify your Email ID");
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Email eg sh@gmail.com']")).getText(), "Email eg sh@gmail.com");
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Get OTP']")).isDisplayed());

        String loginName = "Test Test";
        String loginEmail = "pravin.garg@universityliving.com";
        loginpage.emailFieldText(inputs.get("usedLoginEmail"));



        loginpage.getOtpBtn();
        Thread.sleep(10000);

        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("Heading")).isDisplayed());
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("Heading")).getText(), "Enter your Verification Code");
        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("Verify_Button")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Didn’t receive it? Retry in ']")).isDisplayed());

        loginpage.loginOtpDigits();

        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("Heading")).isDisplayed());
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("Heading")).getText(),"Pick Your Campus");

        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("Search_Bar")).isDisplayed());
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("Search_Bar")).getText()," Search by City, University or Property");

        loginpage.searchCity1();

        loginpage.searchContinueBtn();

        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("Heading")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text=\"Welcome! \"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("SubHeading")).isDisplayed());
        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("Button")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text=\"I'll do it later\"]")).isDisplayed());

        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("Heading")).getText(),"Test! Let's Streamline Your Search.");
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("SubHeading")).getText(),"Dive into hassle-free accommodation hunting!");
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Welcome! ']")).getText(),"Welcome! ");
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text=\"Personalize My Journey\"]")).getText(),"Personalize My Journey");
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text=\"I'll do it later\"]")).getText(),"I'll do it later");

        loginpage.illDoItLaterBtn();

        Thread.sleep(5000);

        loginpage.hamburger();
        Assert.assertEquals(profilePage.profileNameText(),loginName);
        Assert.assertEquals(profilePage.profileEmailText(),inputs.get("usedLoginEmail"));
        profilePage.profileEmailElement();

        Thread.sleep(10000);


    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//testData//ulAppTestData.json");
        return new Object[][]{{data.get(0)}};
    }
}
