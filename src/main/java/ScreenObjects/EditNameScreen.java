package ScreenObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

public class EditNameScreen extends BaseTest {

    private MobileElement okButton;
    private MobileElement nameTextfield;


    public EditNameScreen() {
        this.okButton = (MobileElement) driver.findElementById("android:id/button1");
        this.nameTextfield = (MobileElement) driver.findElementById("edit_text");
        waitForElementToLoad(okButton);
    }

    public EditNameScreen removeName() {
        this.nameTextfield.clear();
        return this;
    }

    public EditNameScreen enterName(String name) {
        this.nameTextfield.sendKeys(name);
        return this;
    }

    public ProfileScreen clickOkButton() {
        okButton.click();
        return new ProfileScreen();
    }


}
