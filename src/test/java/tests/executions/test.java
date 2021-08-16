package tests.executions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import java.util.Set;

public class test {

    public static void main(String[] args) throws InterruptedException {
        //create capabilities object
        DesiredCapabilities caps = new DesiredCapabilities();
        //set capabilities
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","9");
        caps.setCapability("deviceName","ASUS_X00TD");
        caps.setCapability("udid","J6AXGF00A966L6E");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("noReset","false");
        caps.setCapability("appPackage","com.experitest.ExperiBank");
        caps.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");

        //create driver object and paasing the capabilities
        AndroidDriver driver = new AndroidDriver(caps);

        //login
        driver.findElement(By.id("android:id/button1")).click();
        Reporter.log("OK button clicked",true);
        driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
        Reporter.log("Fill username",true);
        driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
        Reporter.log("Fill password",true);
        driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
        Reporter.log("Login button clicked",true);
        Thread.sleep(2000);

        //navigate to payment menu
        driver.findElement(By.id("com.experitest.ExperiBank:id/makePaymentButton")).click();
        Reporter.log("Payment button clicked",true);
        Thread.sleep(2000);

        //fill the form
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

        driver.findElement(By.id("com.experitest.ExperiBank:id/countryButton")).click();

        int windowWidth = driver.manage().window().getSize().width;
        int windowHeight = driver.manage().window().getSize().height;
        int middleXCoordinate = (driver.manage().window().getSize().width*50)/100;
        int bottomYCoordinate = (driver.manage().window().getSize().height*90)/100;
        int upperYCoordinate = (driver.manage().window().getSize().height*10)/100;
        System.out.println("lebar full : "+windowWidth);
        System.out.println("tinggi full : "+windowHeight);
        System.out.println("tengah lebar : "+middleXCoordinate);
        System.out.println("90% tinggi full : "+bottomYCoordinate);
        System.out.println("10% tinggi full : "+upperYCoordinate);

        TouchAction action2 = new TouchAction(driver);
        PointOption startPoint = new PointOption();
        startPoint.withCoordinates(middleXCoordinate,bottomYCoordinate);
        PointOption endPoint = new PointOption();
        endPoint.withCoordinates(middleXCoordinate,upperYCoordinate);
        action2.longPress(startPoint).moveTo(endPoint).release().perform();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[10]"))
                .click();
        driver.findElement(By.id("com.experitest.ExperiBank:id/sendPaymentButton")).click();
        //driver.findElement(By.id("android:id/button1")).click();
        driver.switchTo().alert().accept();
        driver.findElementByAccessibilityId("");
        driver.f
    }

}
