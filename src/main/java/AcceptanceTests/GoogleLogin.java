package AcceptanceTests;


import ScreenObjects.LoginScreen;
import Utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class GoogleLogin extends BaseTest {

    @BeforeMethod(groups = "Acceptance2")
    private void successfulGoogleLoginWithValidCredential() {
        LoginScreen loginScreen = new LoginScreen();

        loginScreen.clickLoginGoogleBtn();
        loginScreen.clickFirstAccountRadioBtn();
        loginScreen.clickOkBtn();

        Boolean result = elementIsNotPresent(By.id("com.android.packageinstaller:id/permission_allow_button"));
        if (!result) {
            //driver.switchTo().alert().accept(); DOES NOT WORK!!!!
            driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        }
        Assert.assertTrue(driver.findElementById("btnHamburger").isDisplayed());
    }

    @AfterMethod(groups = "Acceptance")
    public void afterEachTest() {
        System.out.println("Resetting App");
        driver.resetApp();
    }
}
