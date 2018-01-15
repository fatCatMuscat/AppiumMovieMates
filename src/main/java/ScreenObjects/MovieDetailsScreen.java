package ScreenObjects;

import ScreenFactories.MovieDetailsScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MovieDetailsScreen extends BaseTest {

    public MovieDetailsScreenFactory movieDetailsScreenFactory = new MovieDetailsScreenFactory();

    public MovieDetailsScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), movieDetailsScreenFactory);
        waitForElementToLoad(movieDetailsScreenFactory.stars);
    }

    public boolean isMarkedInterested() {
        return movieDetailsScreenFactory.activeInterestedBtn.isDisplayed();
    }








}
