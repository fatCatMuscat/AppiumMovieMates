package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

public class EditNamePage extends BaseTest {

    private MobileElement okButton;
    private MobileElement nameTextfield;


    public EditNamePage() {
        this.okButton = (MobileElement) driver.findElementById("android:id/button1");
        this.nameTextfield = (MobileElement) driver.findElementById("edit_text");
        waitForElementToLoad(okButton);
    }

    public EditNamePage removeName() {
        this.nameTextfield.clear();
        return this;
    }

    public EditNamePage enterName(String name) {
        this.nameTextfield.sendKeys(name);
        return this;
    }

    public void clickOkButton() {
       this.okButton.click();
    }


}
