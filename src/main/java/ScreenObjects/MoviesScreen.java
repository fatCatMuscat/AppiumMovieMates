package ScreenObjects;

import ScreenFactories.MoviesScreenFactory;
import Utils.BaseTest;
import Utils.DateFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MoviesScreen extends BaseTest {

    public MoviesScreenFactory moviesScreenFactory = new MoviesScreenFactory();

    public MoviesScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), moviesScreenFactory);
        waitForElementToLoad(moviesScreenFactory.profileButton);
    }

    public ProfileScreen clickProfileButton() {
        moviesScreenFactory.profileButton.click();
        return new ProfileScreen();
    }

    public void clickInterested (int buttonIndex) {
        moviesScreenFactory.interestedBtns.get(buttonIndex).click();
    }

    public void clickInterested() {
        moviesScreenFactory.interestedButton.click();
    }

    public MovieDetailsScreen clickMovieNode(int nodeIndex) {
        moviesScreenFactory.movieNodes.get(nodeIndex).click();
        return new MovieDetailsScreen();
    }

    public boolean verifyCurrentDate(int node) {
        DateFactory dateFactory = new DateFactory();
        String monthName = moviesScreenFactory.month.get(node).getText();
        String currentDayOfMonth = moviesScreenFactory.dayOfMonth.get(node).getText();
        String currentDayOfWeek = moviesScreenFactory.dayOfWeek.get(node).getText();

        String trueMonth = dateFactory.getCurrentMonth();
        String trueDay = dateFactory.getCurrentDayInt();
        String trueWeekDay = dateFactory.getCurrentWeekDay();

        return monthName.equals(trueMonth) && currentDayOfMonth.equals(trueDay) && currentDayOfWeek.equals(trueWeekDay);
    }

    public String getMovieTitle(int movieIndex) {
        return moviesScreenFactory.movieTitles.get(movieIndex + 2).getText();
    }

    public MovieDetailsScreen clickOnMovieTitle (int movieIndex) {
        moviesScreenFactory.movieTitles.get(movieIndex + 2).click();
        return new MovieDetailsScreen();
    }



}
