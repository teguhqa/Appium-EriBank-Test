package tests.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Reporter;

public class SwipeVertical {
    AndroidDriver<AndroidElement> driver = null;

    public SwipeVertical(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public void swipeUp(int XCoordinate, int yStart, int yEnd){
        int middleXCoordinate = (driver.manage().window().getSize().width*XCoordinate)/100;
        int bottomYCoordinate = (driver.manage().window().getSize().height*yStart)/100;
        int upperYCoordinate = (driver.manage().window().getSize().height*yEnd)/100;

        TouchAction action2 = new TouchAction(driver);
        PointOption startPoint = new PointOption();
        startPoint.withCoordinates(middleXCoordinate,bottomYCoordinate);
        PointOption endPoint = new PointOption();
        endPoint.withCoordinates(middleXCoordinate,upperYCoordinate);
        action2.longPress(startPoint).moveTo(endPoint).release().perform();
        Reporter.log("Swipe from: "+bottomYCoordinate+" to: "+upperYCoordinate,true);
    }
}
