package ScreenObjects;

import ScreenFactories.ProfileScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProfileScreen extends BaseTest {
    private ProfileScreenFactory profileScreenFactory = new ProfileScreenFactory();

     public ProfileScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), profileScreenFactory);
        waitForElementToLoad(profileScreenFactory.nameEdit);
    }

    public EditNameScreen clickEditName() {
        profileScreenFactory.nameEdit.click();
        return new EditNameScreen();
    }

    public String getCurrentName() {
        return profileScreenFactory.currentNameTextfield.getText();
    }

    public MoviesScreen clickMoviesButton() {
        profileScreenFactory.hamburger.click();
        return new MoviesScreen();
    }

    public void clickBirthdayField() {
        profileScreenFactory.profileScreenNodes.get(3).click();
    }

    public EditGenderScreen clickGenderNode() {
         profileScreenFactory.profileScreenNodes.get(4).click();
         return new EditGenderScreen();
    }

}
