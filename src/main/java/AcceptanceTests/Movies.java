package AcceptanceTests;

import ScreenObjects.LoginScreen;
import ScreenObjects.MovieDetailsScreen;
import ScreenObjects.MoviesScreen;
import Utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Utils.Hints.getRandomInt;

public class Movies extends BaseTest {

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

    @AfterMethod(groups = "Acceptance2")
    public void afterEachTest() {
        System.out.println("Resetting App");
        driver.resetApp();
    }

    @Test(groups = "Acceptance")
    public void markMovieInterested() {
        MoviesScreen moviesScreen = new MoviesScreen();
        moviesScreen.clickInterested(1);
        Assert.assertTrue(!elementIsNotPresent(By.id("iv_movie_date_active_select")));
    }

    @Test(dataProvider = "intProvider", groups = "Acceptance")
    public void verifyInterestedInMovieDetails(int[] ints) {
        MoviesScreen moviesScreen = new MoviesScreen();
        moviesScreen.clickInterested(ints[0]);
        MovieDetailsScreen movieDetailScreen = moviesScreen.clickMovieNode(ints[0]);
        if (movieDetailScreen.isMarkedInterested()) System.out.println("**** IT IS MARKED ****");
        else System.out.println("MOVIE IS NOT MARKED INTERESTED, BRO");
    }

    @Test(groups = "Acceptance")
    public void verifyCurrentDateDisplayedFirst() {
        MoviesScreen moviesScreen = new MoviesScreen();
        Assert.assertTrue(moviesScreen.verifyCurrentDate(0));
    }

    @Test(groups = "Acceptance")
    public void verifyTitleOfMovieOnMoviesScreenAndMovieDetails() {
        MoviesScreen moviesScreen = new MoviesScreen();
        int movie =  getRandomInt();
        System.out.println("************************////////" + movie + ">>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<");
        String title1 = moviesScreen.getMovieTitle(movie);
        MovieDetailsScreen mds = moviesScreen.clickOnMovieTitle(movie);


        Assert.assertEquals(mds.getMovieTitle().toLowerCase(), title1.toLowerCase());
    }



}
