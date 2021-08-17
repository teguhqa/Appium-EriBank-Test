package tests.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class SliderAmount {
    AndroidDriver<AndroidElement> driver = null;

    public SliderAmount(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public void performSlider(String idLocator, int percentMove){
        //Locating seek bar by id
        WebElement seekBar = driver.findElement(By.id(idLocator));
        //get slider location
        int xTopLeftElementLocation = seekBar.getLocation().getX();
        int yTopLeftElementLocation = seekBar.getLocation().getY();
        //get slider width & height
        int seekBarWidth = seekBar.getSize().width;
        int seekBarHeight = seekBar.getSize().height;
        //start coordinate
        int startCoodinateY = yTopLeftElementLocation+(seekBarHeight/2);
        int startCoodinateX =  xTopLeftElementLocation+(seekBarWidth/20);
        //end coodinate
        int endCoordinateX = startCoodinateX+((seekBarWidth*percentMove)/100);
        //Instatiate Action
        TouchAction action = new TouchAction(driver);
        //create start pinpoint
        PointOption opstart = new PointOption();
        opstart.withCoordinates(startCoodinateX,startCoodinateY);
        //create end pinpoint
        PointOption opend = new PointOption();
        opend.withCoordinates(endCoordinateX, startCoodinateY);
        //perform swipe
        action.longPress(opstart).moveTo(opend).release().perform();
        Reporter.log("Seek bar : "+percentMove+"%",true);

    }

}
