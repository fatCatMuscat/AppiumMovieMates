package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

public class ProfilePage extends BaseTest {
    private MobileElement nameEdit;
    private MobileElement currentNameTextfield;
    private MobileElement hamburger;

    public ProfilePage() {
        this.nameEdit = (MobileElement) driver.findElementById("ivName");
        this.currentNameTextfield = (MobileElement) driver.findElementById("tvNameValue");
        this.hamburger = (MobileElement) driver.findElementById("llHamburger");
        waitForElementToLoad(nameEdit);
    }

    public EditNamePage clickEditName() {
        this.nameEdit.click();
        return new EditNamePage();
    }

    public String getCurrentName() {
        return this.currentNameTextfield.getText();
    }

    public MoviesPage clickMoviesButton() {
        hamburger.click();
        return new MoviesPage();
    }

}
