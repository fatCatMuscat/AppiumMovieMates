package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class MoviesScreenFactory {

    @AndroidFindBy(id = "btnHamburger")
    public MobileElement profileButton;

    @AndroidFindBy(id = "id/ivVisibleButtonInterested")
    public MobileElement interestedBtn;

    @AndroidFindBy(id = "iv_movie_date_active_select")
    public MobileElement dateCheckmark;

    @AndroidFindBy(id = "rlItemFilm")
    public MobileElement movieNode;

    @AndroidFindBy(id = "rlItemFilm")
    public List<MobileElement> movieNodes;

    @AndroidFindBy(id = "tbButtonInterested")
    public MobileElement interestedButton;

    @AndroidFindBy(id = "tbButtonInterested")
    public List<MobileElement> interestedBtns;

    @AndroidFindBy(id = "tv_date_picker_month_name")
    public MobileElement month;

    @AndroidFindBy(id = "tv_date_picker_day")
    public MobileElement dayOfMonth;

    @AndroidFindBy(id = "tv_date_picker_day_name")
    public MobileElement dayOfWeek;



}
