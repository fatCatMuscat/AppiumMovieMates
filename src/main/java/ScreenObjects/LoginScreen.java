package ScreenObjects;

import ScreenFactories.LoginScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen extends BaseTest {

    public LoginScreenFactory loginScreenFactory = new LoginScreenFactory();

    public LoginScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginScreenFactory);
        waitForElementToLoad(loginScreenFactory.loginGoogleBtn);
    }

    public void clickLoginGoogleBtn() {
        loginScreenFactory.loginGoogleBtn.click();
    }

    public void clickFirstAccountRadioBtn() {
        loginScreenFactory.accountRadioBtn.click();
    }

    public void clickOkBtn() {
        loginScreenFactory.okBtn.click();
    }

}
