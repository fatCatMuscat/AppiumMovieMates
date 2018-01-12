package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginScreenFactory {

    @AndroidFindBy(id = "btnGoogleLogin")
    public MobileElement loginGoogleBtn;

    @AndroidFindBy(id = "android:id/text1")
    public MobileElement accountRadioBtn;

    @AndroidFindBy (id = "android:id/button1")
    public MobileElement okBtn;

}
