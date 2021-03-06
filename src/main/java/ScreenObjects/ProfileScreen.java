package ScreenObjects;

import ScreenFactories.ProfileScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
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
         profileScreenFactory.profileScreenNodes.get(5).click();
         return new EditGenderScreen();
    }

    public String getGenderValue() {
         return profileScreenFactory.genderValue.getText();
    }

    public EditLocationScreen clickLocationNode() {
        profileScreenFactory.profileScreenNodes.get(7).click();
        return new EditLocationScreen();
    }

    public String getCurrentLocation(){
         return profileScreenFactory.currentLocation.getText();
    }

    public void waitForServerToLoadLocation(String location) {
        waitForAttributeToBeVisible(By.id("tvLocationValue"), "text", location);
    }

}
