package Utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateFactory {

    public void getCurrentDay() {
        LocalDate today = LocalDate.now();
        System.out.println(String.valueOf(today.getDayOfWeek()));
    }

    public void currentDayPlusXdays(int days) {
        LocalDate today = LocalDate.now();
        LocalDate todayPlusDays = today.plus(days, ChronoUnit.DAYS);
        System.out.println(String.valueOf(todayPlusDays.getDayOfWeek()));
    }
}
