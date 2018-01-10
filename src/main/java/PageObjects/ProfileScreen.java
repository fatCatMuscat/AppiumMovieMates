package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

public class ProfileScreen extends BaseTest {
    private MobileElement nameEdit;
    private MobileElement currentNameTextfield;
    private MobileElement hamburger;

    public ProfileScreen() {
        this.nameEdit = (MobileElement) driver.findElementById("ivName");
        this.currentNameTextfield = (MobileElement) driver.findElementById("tvNameValue");
        this.hamburger = (MobileElement) driver.findElementById("llHamburger");
        waitForElementToLoad(nameEdit);
    }

    public EditNameScreen clickEditName() {
        this.nameEdit.click();
        return new EditNameScreen();
    }

    public String getCurrentName() {
        return this.currentNameTextfield.getText();
    }

    public MoviesScreen clickMoviesButton() {
        hamburger.click();
        return new MoviesScreen();
    }

}
