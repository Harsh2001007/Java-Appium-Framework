package org.AndroidTests;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium() throws URISyntaxException, MalformedURLException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//TUL//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")  // Correct format: just the IP address
                .usingPort(4723)
                .build();

        service.start();

        UiAutomator2Options options= new UiAutomator2Options();
        options.setDeviceName("pix-6");
        options.setApp("C://Users//TUL//Desktop//AppiumFramework//apps//Beta.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void longPressAction(WebElement ele, int duration){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",duration));
    }

    public void ScrollToEnd(){
        boolean canScrollMore;
        do{
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left",100,"top",100,"width",200,"height",200,"direction","down","percent",3.0
            ));
        }while (canScrollMore);
    }

    public void swipeAction( WebElement ele, String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
                "direction",direction,
                "percent",0.75));
    }


    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException{

        //convert json file content to json string
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
