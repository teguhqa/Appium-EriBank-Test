package tests.testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import tests.pages.HomePage;
import tests.pages.LoginPage;
import tests.pages.MakePaymentPage;
import tests.utils.SliderAmount;
import tests.utils.SwipeVertical;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {

    //set the url parameter
    private final String url = "http://0.0.0.0:4723/wd/hub";
    //declare desired capabilities in global scope
    DesiredCapabilities desiredCapabilities = null;
    //declare driver in global scope
    AndroidDriver<AndroidElement> driver = null;
    //declare page object in global scope
    HomePage homePage = null;
    LoginPage loginPage = null;
    MakePaymentPage makePaymentPage = null;
    //declare util object in global scope
    SliderAmount slider = null;
    SwipeVertical swipe = null;

    @BeforeSuite
    public void suiteSetup() throws MalformedURLException {
        //create desired capabilities
        desiredCapabilities = new DesiredCapabilities();
        //set device capabilities
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("platformVersion","9");
        desiredCapabilities.setCapability("deviceName","ASUS_X00TD");
        desiredCapabilities.setCapability("udid","J6AXGF00A966L6E");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        //set option capabilities
        desiredCapabilities.setCapability("noReset","false");
        //set application capabilities
        desiredCapabilities.setCapability("appPackage","com.experitest.ExperiBank");
        desiredCapabilities.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");
        //create driver and passes url and desired capabilities parameter
        driver = new AndroidDriver<AndroidElement>(new URL(url),desiredCapabilities);
        //create page object and passes driver
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        makePaymentPage = new MakePaymentPage(driver);
        //create util object and passes driver
        slider = new SliderAmount(driver);
        swipe = new SwipeVertical(driver);

    }

    @Test
    public void test1() throws InterruptedException {
        loginPage.clickOK();
        loginPage.typeUsername("company");
        loginPage.typePassword("company");
        loginPage.clickLogin();
        Thread.sleep(3000);
        homePage.clickMakePaymentButton();
        Thread.sleep(3000);
        makePaymentPage.typePhone("089600000000");
        makePaymentPage.typeName("hehuh");
        slider.performSlider("com.experitest.ExperiBank:id/amount",30);
        makePaymentPage.clickSelect();
        swipe.swipeUp(50,90,10);
        makePaymentPage.clickSelectCanada();
        makePaymentPage.clickSendPayment();
        driver.switchTo().alert().accept();

    }

    @AfterSuite
    public void suiteTeardown(){
        if(driver != null){
            driver.quit();
            Reporter.log("Quit the driver",true);
        }else{
            Reporter.log("Already quit the driver",true);
        }
    }


}
