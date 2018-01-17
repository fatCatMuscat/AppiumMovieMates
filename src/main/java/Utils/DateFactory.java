package Utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateFactory {

    public String getCurrentWeekDay() {
        LocalDate today = LocalDate.now();
        return String.valueOf(today.getDayOfWeek());
    }

    public String getCurrentDayInt() {
        LocalDate today = LocalDate.now();
        return String.valueOf(today.getDayOfMonth());
    }

    public String getCurrentMonth() {
        LocalDate currentMonth = LocalDate.now();
        return String.valueOf(currentMonth.getMonth()).substring(0, 3);
    }

    public void currentDayPlusXdays(int days) {
        LocalDate today = LocalDate.now();
        LocalDate todayPlusDays = today.plus(days, ChronoUnit.DAYS);
        System.out.println(String.valueOf(todayPlusDays.getDayOfWeek()));
    }


}
