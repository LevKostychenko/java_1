package Logic;

import com.sun.istack.internal.NotNull;

public class CalculateLogic implements ICalculateLogic
{
    public String GetWeekDay(int year, int dayNumber)
    {
        int firstYearDay = GetFirstYearDay(year);
        int day = dayNumber - ((int)(dayNumber / 7)) * 7;

        int actualWeekDay = (day + firstYearDay) >= 7 ? day + firstYearDay - 7 : day + firstYearDay;

        try
        {
            return GetDayName(actualWeekDay);
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }

    private int GetFirstYearDay(int year)
    {
        int leapYears, years, days;

        years = year-1900;
        leapYears = (years-1)/4;
        days = years*365+leapYears;

        return days%7;
    }

    @NotNull
    private String GetDayName (int weekDayNumber) throws Exception {
        String actualWeekDayName = "";

        switch (weekDayNumber)
        {
            case 0 :
            {
                actualWeekDayName = "Воскресенье";
                break;
            }
            case 1 :
            {
                actualWeekDayName = "Понедельник";
                break;
            }
            case 2 :
            {
                actualWeekDayName = "Вторник";
                break;
            }
            case 3 :
            {
                actualWeekDayName = "Среда";
                break;
            }
            case 4 :
            {
                actualWeekDayName = "Четверг";
                break;
            }
            case 5 :
            {
                actualWeekDayName = "Пятница";
                break;
            }
            case 6 :
            {
                actualWeekDayName = "Суббота";
                break;
            }
        }

        if (actualWeekDayName.isEmpty())
        {
            throw new Exception("Day cannot ne defined");
        }

        return actualWeekDayName;
    }
}
