package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

public class MoviesPage extends BaseTest {

    private MobileElement profileButton;

    public MoviesPage() {
        this.profileButton = (MobileElement) driver.findElementById("btnHamburger");
        waitForElementToLoad(profileButton);
    }

    public ProfilePage clickOnProfileButton() {
        this.profileButton.click();
        return new ProfilePage();
    }


}
