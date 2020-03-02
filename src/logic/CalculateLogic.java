package logic;

import com.sun.istack.internal.NotNull;
import java.time.LocalDate;

public class CalculateLogic implements ICalculateLogic {
    public String getWeekDay(int year, int dayNumber) {
        if (dayNumber > 365) {
            if (!(dayNumber == 366 && isYearLeap(year))) {
                while (dayNumber > 365) {
                    if (isYearLeap(year)) {
                        if (dayNumber <= 366) {
                            break;
                        }

                        dayNumber -= 366;
                    }
                    else {
                        dayNumber -= 365;
                    }

                    year++;
                }
            }
        }

        try {
            int dayOfWeekNumber = LocalDate.ofYearDay( year, dayNumber ).getDayOfWeek().getValue();
            return getDayName(dayOfWeekNumber);
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    private boolean isYearLeap(int year) {
        if (year % 4 == 0) {
            if ((year % 100 != 0) || (year % 400 == 0)) {
                return true;
            }
        }

        return false;
    }

    @NotNull
    private String getDayName (int weekDayNumber) throws Exception {
        String actualWeekDayName = "";

        switch (weekDayNumber) {
            case 1 : {
                actualWeekDayName = "Понедельник";
                break;
            }
            case 2 : {
                actualWeekDayName = "Вторник";
                break;
            }
            case 3 : {
                actualWeekDayName = "Среда";
                break;
            }
            case 4 : {
                actualWeekDayName = "Четверг";
                break;
            }
            case 5 : {
                actualWeekDayName = "Пятница";
                break;
            }
            case 6 : {
                actualWeekDayName = "Суббота";
                break;
            }
            case 7 : {
                actualWeekDayName = "Воскресенье";
                break;
            }
        }

        if (actualWeekDayName.isEmpty()) {
            throw new Exception("Day cannot ne defined");
        }

        return actualWeekDayName;
    }
}
