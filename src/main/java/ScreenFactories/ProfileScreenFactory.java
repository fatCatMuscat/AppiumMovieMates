package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class ProfileScreenFactory {

    @AndroidFindBy(id = "ivName")
    public MobileElement nameEdit;

    @AndroidFindBy(id = "tvNameValue")
    public MobileElement currentNameTextfield;

    @AndroidFindBy(id = "llHamburger")
    public MobileElement hamburger;

    @AndroidFindBy (className = "android.widget.RelativeLayout")
    public List<MobileElement> profileScreenNodes;

    @AndroidFindBy (id = "tvGenderValue")
    public MobileElement genderValue;

    @AndroidFindBy (id = "tvLocationValue")
    public MobileElement currentLocation;


}
