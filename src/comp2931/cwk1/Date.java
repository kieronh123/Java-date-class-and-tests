// Class for COMP2931 Coursework 1

package comp2931.cwk1;


/**
 * Simple representation of a date.
 */
public class Date {


    private static final int DAYS_PER_MONTH = 31;
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

        year = y;
        month = m;
        day = d;
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
        return String.format("%04d-%02d-%2d", year, month, day);
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
        if (y < 0)
        {
            return false;
        }

        if ((m < 1) || (m > 12))
        {
            return false;
        }

        if ((d < 1) || (d > 31))
        {
            return false;
        }

        switch (m)
        {
            case 1: return true;
            case 2: return d < 29;
            case 3: return true;
            case 4: return d < 31;
            case 5: return true;
            case 6: return d < 31;
            case 7: return true;
            case 8: return true;
            case 9: return d < 31;
            case 10: return true;
            case 11: return d < 31;
            case 12: return true;
            default: return true;
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

}
