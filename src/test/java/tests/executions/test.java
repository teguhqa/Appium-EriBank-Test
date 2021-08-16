package tests.executions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

public class test {

    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","9");
        caps.setCapability("deviceName","ASUS_X00TD");
        caps.setCapability("udid","J6AXGF00A966L6E");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("noReset","false");
        caps.setCapability("appPackage","com.experitest.ExperiBank");
        caps.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");

        AndroidDriver driver = new AndroidDriver(caps);
        driver.findElement(By.id("android:id/button1")).click();
        Reporter.log("OK button clicked",true);
        driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
        Reporter.log("Fill username",true);
        driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
        Reporter.log("Fill password",true);
        driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
        Reporter.log("Login button clicked",true);
        Thread.sleep(2000);
        driver.findElement(By.id("com.experitest.ExperiBank:id/makePaymentButton")).click();
        Reporter.log("Payment button clicked",true);
        Thread.sleep(2000);
        driver.findElement(By.id("com.experitest.ExperiBank:id/phoneTextField")).sendKeys("089609293939");
        Reporter.log("Fill phone number",true);
        driver.findElement(By.id("com.experitest.ExperiBank:id/nameTextField")).sendKeys("Teguh Hariyadi");
        Reporter.log("Fill name",true);

        //slider horizontal
        //Locating seek bar by id
        WebElement seekBar = driver.findElement(By.id("com.experitest.ExperiBank:id/amount"));
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
        int endCoordinateX = startCoodinateX+(seekBarWidth/2);
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

        Reporter.log("Seek bar 50%",true);





    }

}
