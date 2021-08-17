package tests.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MakePaymentPage {
    private AndroidDriver<AndroidElement> driver = null;

    public MakePaymentPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)),this);
    }

    @AndroidFindBy(id="com.experitest.ExperiBank:id/phoneTextField")
    private AndroidElement phoneField;

    @AndroidFindBy(id="com.experitest.ExperiBank:id/nameTextField")
    private AndroidElement nameField;

    //slide

    @AndroidFindBy(id="com.experitest.ExperiBank:id/countryButton")
    private AndroidElement selectButton;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[10]")
    private AndroidElement selectButtonCanada;

    @AndroidFindBy(id="com.experitest.ExperiBank:id/sendPaymentButton")
    private AndroidElement sendPaymentButton;

    public void typePhone(String phone){
        phoneField.sendKeys(phone);
    }

    public void typeName(String name){
        nameField.sendKeys(name);
    }

    public void clickSelect(){
        selectButton.click();
    }

    public void clickSelectCanada(){
        selectButtonCanada.click();
    }

    public void clickSendPayment(){
        sendPaymentButton.click();
    }
}
