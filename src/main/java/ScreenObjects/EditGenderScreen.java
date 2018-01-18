package ScreenObjects;

import ScreenFactories.EditGenderScreenFactory;
import Utils.BaseTest;

public class EditGenderScreen extends BaseTest {

    private EditGenderScreenFactory editGenderScreenFactory = new EditGenderScreenFactory();

    public void checkMale() {
        editGenderScreenFactory.maleRadioButton.click();
    }

    public void checkFemale() {
        editGenderScreenFactory.femaleRadioButton.click();
    }

    public ProfileScreen clickOK() {
        editGenderScreenFactory.okButton.click();
        return new ProfileScreen();
    }

    public EditGenderScreen clickCancel() {
        editGenderScreenFactory.cancelButton.click();
        return new EditGenderScreen();
    }


}
