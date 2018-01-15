
package AcceptanceTests;

import ScreenObjects.LoginScreen;
import ScreenObjects.MovieDetailsScreen;
import ScreenObjects.MoviesScreen;
import Utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserProfile extends BaseTest {

    @BeforeMethod
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

    @AfterMethod
    public void afterEachTest() {
        System.out.println("Resetting App");
        driver.resetApp();
    }

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


    // verifying valid name input saves in user name in profile settings
    @Test(dataProvider = "validNamesProvider")
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
    @Test(dataProvider = "longNamesProvider")
    public void nameMorethan50Char(String[] longNames) {
        MoviesScreen moviesScreen = new MoviesScreen();
        String newName = longNames[0];
        MoviesScreen secondMoviesScreen = moviesScreen.clickProfileButton()
                .clickEditName().removeName().enterName(newName)
                .clickOkButton().clickMoviesButton();
        String currentName = secondMoviesScreen.clickProfileButton().getCurrentName();

        Assert.assertEquals(currentName, newName.substring(0, 50));
    }

    @Test
    public void markMovieInterested() {
        MoviesScreen moviesScreen = new MoviesScreen();
        moviesScreen.clickInterested(1);
        Assert.assertTrue(!elementIsNotPresent(By.id("iv_movie_date_active_select")));
    }

    @Test(dataProvider = "intProvider")
    public void verifyInterestedInMovieDetails(int[] ints) {
        MoviesScreen moviesScreen = new MoviesScreen();
        moviesScreen.clickInterested(ints[0]);
        MovieDetailsScreen movieDetailScreen = moviesScreen.clickMovieNode(ints[0]);
        if (movieDetailScreen.isMarkedInterested()) System.out.println("**** IT IS MARKED ****");
        else System.out.println("MOVIE IS NOT MARKED INTERESTED BRO");
    }



}
