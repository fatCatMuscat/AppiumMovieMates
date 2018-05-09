
package AcceptanceTests;

import ScreenObjects.EditLocationScreen;
import ScreenObjects.LoginScreen;
import ScreenObjects.MoviesScreen;
import ScreenObjects.ProfileScreen;
import Utils.BaseTest;
import org.openqa.selenium.By;
import Networking.ServerManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserProfile extends BaseTest {

    @DataProvider(name = "validNamesProvider")
    public Object[][] getValidNames() {
        return new Object[][] {
                {"Hruysha", "Filya"},
                {"Karkusha Polikarpovna", "Polikarp Himself"},
        };
    }

    @DataProvider(name = "longNamesProvider")
    public Object[][] getLongNames() {
        return new Object[][] {
                {"Randolph Sherman Thomas Uncas Victor William Xerxes"},
                {"YancyWolfeschlegelsteinhausenbergerdorffSeniorwholivedinPhiladelphia"}
        };
    }

    @DataProvider(name = "intProvider")
    public Object[][] getInt() {
        return new Object[][] {
                {1},
                {3}
        };
    }

    //                                  *******  UI  ********


    @BeforeMethod(groups = "Acceptance")
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

    // verifying valid name input saves in user name in profile settings
    @Test(dataProvider = "validNamesProvider", groups = "Acceptance")
    public void changeValidName(String[] validNames) {
        MoviesScreen moviesScreen = new MoviesScreen();
        String newName = validNames[0];
        MoviesScreen secondMoviesScreen = moviesScreen.clickProfileButton()
                .clickEditName().removeName().enterName(newName)
                .clickOkButton().clickMoviesButton();
        String currentName = secondMoviesScreen.clickProfileButton().getCurrentName();
        System.out.println(currentName);
        Assert.assertEquals(currentName, newName);
    }

    // verifying that user name > 50 chars gets truncated to 50 chars
    @Test(dataProvider = "longNamesProvider", groups = "Acceptance")
    public void nameMorethan50Char(String[] longNames) {
        MoviesScreen moviesScreen = new MoviesScreen();
        String newName = longNames[0];
        MoviesScreen secondMoviesScreen = moviesScreen.clickProfileButton()
                .clickEditName().removeName().enterName(newName)
                .clickOkButton().clickMoviesButton();
        String currentName = secondMoviesScreen.clickProfileButton().getCurrentName();

        Assert.assertEquals(currentName, newName.substring(0, 50));
    }

    @Test(groups = "Acceptance")
    public void changeGenderToMale() {
        MoviesScreen moviesScreen = new MoviesScreen();
        ProfileScreen pfs = moviesScreen.clickProfileButton();
        String currentGender = pfs.getGenderValue();
        String newGender = "";

        if (currentGender.equals("Male")) { newGender = new ProfileScreen().clickGenderNode().checkFemale().clickOK().getGenderValue(); }
        else { newGender = new ProfileScreen().clickGenderNode().checkMale().clickOK().getGenderValue(); }
        Assert.assertFalse(currentGender.equalsIgnoreCase(newGender));
    }

    @Test(groups = "Acceptance")
    public void changeLocation(){
        MoviesScreen moviesScreen = new MoviesScreen();
        String city = "Sunnyvale";
        String state = "CA";

        EditLocationScreen edls = moviesScreen.clickProfileButton().clickLocationNode();
        ProfileScreen ps = edls.enterNewLocation(city, state);

        ps.waitForServerToLoadLocation((city + ", " + state));

        String location = ps.getCurrentLocation();

        Assert.assertEquals(location, city + ", " + state);
    }

    @Test(groups = "Acceptance")
    public void testMyApi() throws IOException {
        ServerManager sm = new ServerManager();
        //System.out.println(sm.getMovies());
        System.out.println(sm.getUserDetails());
    }

}
