package ScreenObjects;

import ScreenFactories.EditGenderScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class EditGenderScreen extends BaseTest {

    private EditGenderScreenFactory editGenderScreenFactory = new EditGenderScreenFactory();

    public EditGenderScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), editGenderScreenFactory);
        waitForElementToLoad(editGenderScreenFactory.okButton);
    }

    public EditGenderScreen checkMale() {
        editGenderScreenFactory.maleRadioButton.click();
        return new EditGenderScreen();
    }

    public EditGenderScreen checkFemale() {
        editGenderScreenFactory.femaleRadioButton.click();
        return new EditGenderScreen();
    }

    public ProfileScreen clickOK() {
        editGenderScreenFactory.okButton.click();
        return new ProfileScreen();
    }

    public ProfileScreen clickCancel() {
        editGenderScreenFactory.cancelButton.click();
        return new ProfileScreen();
    }


}
