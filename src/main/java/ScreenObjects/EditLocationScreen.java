package ScreenObjects;

import ScreenFactories.EditLocationScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class EditLocationScreen extends BaseTest {

    private EditLocationScreenFactory elsf = new EditLocationScreenFactory();

    public EditLocationScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), elsf);
        waitForElementToLoad(elsf.switchLocation);
    }

    public ProfileScreen enterNewLocation(String city, String state) {
        elsf.locationTextfield.clear();
        elsf.locationTextfield.sendKeys(city + ", " + state);
        elsf.okButton.click();


        return new ProfileScreen();
    }




}
