package AcceptanceTests;

import ScreenObjects.MovieDetailsScreen;
import ScreenObjects.MoviesScreen;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utils.Hints.getRandomInt;

public class Movies extends GoogleLogin {

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
