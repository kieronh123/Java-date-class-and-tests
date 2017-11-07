// Class for COMP2931 Coursework 1


package comp2931.cwk1;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

/**
 * Simple representation of a date.
 */
public class Date {


    private static final int MAX_DAYS_PER_MONTH = 31;
    private static final int MONTHS_PER_YEAR = 12;

    private int year;
    private int month;
    private int day;

    /**
    * Creates a date using the given values for year, month and day.
    *
    * @param y Year
    * @param m Month
    * @param d Day
    */
    public Date(int y, int m, int d) throws IllegalArgumentException
    {
        if (!validDate(y, m, d))
        {
            throw new IllegalArgumentException("Invalid Date given");
        }
        else
        {
            year = y;
            month = m;
            day = d;
        }

    }

    public Date()
    {
        Calendar currentDate = Calendar.getInstance(); //Get the current date
        java.util.Date x = currentDate.getTime();
        SimpleDateFormat formatyear = new SimpleDateFormat("yyyy");
        this.year = Integer.parseInt(formatyear.format(x));
        SimpleDateFormat formatmonth = new SimpleDateFormat("MM");
        this.month = Integer.parseInt(formatmonth.format(x));
        SimpleDateFormat formatdd = new SimpleDateFormat("dd");
        this.day = Integer.parseInt(formatdd.format(x));

    }

    /**
    * Returns the year component of this date.
    *
    * @return Year
    */
    public int getYear()
    {
        return year;
    }

    /**
    * Returns the month component of this date.
    *
    * @return Month
    */
    public int getMonth()
    {
        return month;
    }

    /**
    * Returns the day component of this date.
    *
    * @return Day
    */
    public int getDay()
    {
        return day;
    }

    /**
    * Provides a string representation of this date.
    *
    * ISO 8601 format is used (YYYY-MM-DD).
    *
    * @return Date as a string
    */
    @Override
    public String toString()
    {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
    * Returns true or false depending on if the date is
    * valid or not
    *
    * @param y Year
    * @param m Month
    * @param d Date
    *
    * @return true if the date is valid, false if the date is not valid
    */
    public boolean validDate(int y, int m, int d)
    {
        if (y < 1)
        {
            return false;
        }

        if ((m < 1) || (m > MONTHS_PER_YEAR))
        {
            return false;
        }

        if ((d < 1) || (d > MAX_DAYS_PER_MONTH))
        {
            return false;
        }

        //taking into consideration the months with more or less than 30 days
        switch (m)
        {
            case 1:
                    return true;
            case 2:
                    return (isLeapYear(y) ? d < 30 : d < 29);
            case 3:
                    return true;
            case 4:
                    return d < 31;
            case 5:
                    return true;
            case 6:
                    return d < 31;
            case 7:
                    return true;
            case 8:
                    return true;
            case 9:
                    return d < 31;
            case 10:
                    return true;
            case 11:
                    return d < 31;
            case 12:
                    return true;
            default:
                    return true;
        }
    }

    /**
     * Tests whether this date is equal to another.
     *
     * <p>The two objects are considered equal if both are instances of
     * the date class <em>and</em> both represent exactly the same
     * date.</p>
     *
     * @return True if this Date object is equal to the other, false otherwise
     */
    @Override
    public boolean equals(Object other)
    {
      if (other == this)
      {
        // 'other' is same object as this one!
        return true;
      }
      else if (! (other instanceof Date))
      {
        // 'other' is not a Time object
        return false;
      }
      else
      {
        // Compare fields
        Date otherDate = (Date) other;
        return getYear() == otherDate.getYear()
            && getMonth() == otherDate.getMonth()
            && getDay() == otherDate.getDay();
      }
    }

    /**
     * Returns the day of the year as an integer
     *
     * <p> For example: if the given date is the 15th of january
     *     then this will return 15. If the date is the 31st of
     *     december then 365 will be returned.</p>
     *
     * @return Day of the year as an integer
     */
    public int getDayOfYear()
    {
        int dayNum = 0;
        switch(month)
        {
            /**
             * For january and february the day number does not depend on
             * the year being a leap year so just return the value
             */
            case 1:
                    return day;
            case 2:
                    return day + 31;
            case 3:
                    dayNum = day + 59;
                    break;
            case 4:
                    dayNum = day + 90;
                    break;
            case 5:
                    dayNum = day + 120;
                    break;
            case 6:
                    dayNum = day + 151;
                    break;
            case 7:
                    dayNum = day + 181;
                    break;
            case 8:
                    dayNum = day + 212;
                    break;
            case 9:
                    dayNum = day + 243;
                    break;
            case 10:
                    dayNum = day + 273;
                    break;
            case 11:
                    dayNum = day + 304;
                    break;
            case 12:
                    dayNum = day + 334;
                    break;
        }

        /**
         * If the year is a leap year and the month is not jan or feb, add 1 to the day number.
         * If not a leap year then just return the dayNum variable
         */
        if(isLeapYear(year)==true)
        {
            return dayNum+1;
        }
        else
        {
            return dayNum;
        }
    }


    /**
     * Method that returns a boolean that determines if the year given is
     * a leap yaer.
     *
     * <p>A year is given as a parameter. The calendar library is used to
     *    determine wether this year is a leap year by checking if the maximum
     *    day of the given year is larger than 365. If the maximum day is larger
     *    than 365 then the method returns true.</p>
     *
     * @param y - Year
     *
     * @return True if leap year, false if not.
     */
    public boolean isLeapYear(int y)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, y);
        if(cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365)
        {
            return true;
        }
        else
        {
            return false;
        }
    }




}
