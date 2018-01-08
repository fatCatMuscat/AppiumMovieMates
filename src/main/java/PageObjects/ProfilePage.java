package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;

public class ProfilePage extends BaseTest {
    private MobileElement nameEdit;

    public ProfilePage() {
        this.nameEdit = (MobileElement) driver.findElementById("ivName");
        waitForElementToLoad(nameEdit);
    }

    public EditNamePage clickEditName() {
        this.nameEdit.click();
        return new EditNamePage();
    }

}
