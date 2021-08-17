package tests.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.time.Duration;

public class HomePage {
    private AndroidDriver<AndroidElement> driver = null;

    public HomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)),this);
    }

    @AndroidFindBy(id="com.experitest.ExperiBank:id/makePaymentButton")
    private AndroidElement makePaymentButton;

    public void clickMakePaymentButton(){
        makePaymentButton.click();
        Reporter.log("Button Make Payment clicked",true);
    }
}
