package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MovieDetailsScreenFactory {

    @AndroidFindBy(id = "ivActors")
    public MobileElement stars;

    @AndroidFindBy(id = "ivShadowInterested")
    public MobileElement activeInterestedBtn;


}
