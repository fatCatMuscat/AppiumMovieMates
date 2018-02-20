package Utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateFactory {

    public String getCurrentWeekDay() {
        LocalDate today = LocalDate.now();
        return String.valueOf(today.getDayOfWeek());
    }

    public String currentDayPlusXDays(int days) {
        LocalDate today = LocalDate.now();
        LocalDate next2Week = today.plus(days, ChronoUnit.DAYS);
        return String.valueOf(next2Week.getDayOfMonth());
    }

    public String getCurrentDayInt() {
        LocalDate today = LocalDate.now();
        return String.valueOf(today.getDayOfMonth());
    }

    public String getCurrentMonth() {
        LocalDate currentMonth = LocalDate.now();
        return String.valueOf(currentMonth.getMonth()).substring(0, 3);
    }


}
