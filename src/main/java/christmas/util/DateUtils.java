package christmas.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtils {

    public static boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY;
    }

    public static boolean isSpecialDiscountDay(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY
                || date.getDayOfMonth() == Constants.CHRISTMAS_DAY;
    }

    public static boolean isWithinPeriod(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }
}
