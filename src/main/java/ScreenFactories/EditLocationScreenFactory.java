package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EditLocationScreenFactory {

    @AndroidFindBy(id = "etEnterPosition")
    public MobileElement locationTextfield;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement okButton;

    @AndroidFindBy(id ="switchLocation")
    public MobileElement switchLocation;

}
