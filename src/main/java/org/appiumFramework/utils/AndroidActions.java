package org.appiumFramework.utils;

import com.google.common.collect.ImmutableMap;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import javax.annotation.concurrent.Immutable;
import java.net.MalformedURLException;

public class AndroidActions  {

    AndroidDriver driver;

    public  AndroidActions(AndroidDriver driver){
        this.driver = driver;
    }

    public void longPressAction(WebElement ele){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(), "duration",2000));
    }

    public void scrollToEndAction(){
        boolean canScrollMore;

        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
        }while (canScrollMore);
    }

    public void swipeAction(WebElement ele, String direction){
        ((JavascriptExecutor)driver).executeScript("mobile:swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(), "direction",direction,"percent",0.75));
    }

    public void scrollToText(String text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));

    }



    }




