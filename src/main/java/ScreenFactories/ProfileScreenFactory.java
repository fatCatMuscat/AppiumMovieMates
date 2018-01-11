package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfileScreenFactory {

    @AndroidFindBy(id = "ivName")
    public MobileElement nameEdit;

    @AndroidFindBy(id = "tvNameValue")
    public MobileElement currentNameTextfield;

    @AndroidFindBy(id = "llHamburger")
    public MobileElement hamburger;



}
