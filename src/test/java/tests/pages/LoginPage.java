package tests.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {

    private AndroidDriver<AndroidElement> driver = null;

    public LoginPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)),this);
    }
    @AndroidFindBy(id="android:id/button1")
    private AndroidElement okButton;
    @AndroidFindBy(id="com.experitest.ExperiBank:id/usernameTextField")
    private AndroidElement usernameField;
    @AndroidFindBy(id="com.experitest.ExperiBank:id/passwordTextField")
    private AndroidElement passwordField;
    @AndroidFindBy(id="com.experitest.ExperiBank:id/loginButton")
    private AndroidElement loginButton;

    public void clickOK(){
        okButton.click();
    }

    public void typeUsername(String username){
        usernameField.sendKeys(username);
    }

    public void typePassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLogin(){
        loginButton.click();
    }
}
