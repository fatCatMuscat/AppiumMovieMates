package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

public class MoviesScreen extends BaseTest {

    private MobileElement profileButton;

    public MoviesScreen() {
        this.profileButton = (MobileElement) driver.findElementById("btnHamburger");
        waitForElementToLoad(profileButton);
    }

    public ProfileScreen clickProfileButton() {
        this.profileButton.click();
        return new ProfileScreen();
    }


}
