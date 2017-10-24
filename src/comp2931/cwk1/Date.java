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
  public Date(int y, int m, int d)
  {
      if (y <= 0 )
      {
          throw new IllegalArgumentException("Year out of bounds");
      }
      else if (m <= 0 || m > MONTHS_PER_YEAR)
      {
          throw new IllegalArgumentException("Month out of bounds");
      }
      else if (d <= 0 || d > DAYS_PER_MONTH)
      {
          throw new IllegalArgumentException("Day out of bounds");
      }
      else
      {
          year = y;
          month = m;
          day = d;
      }

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





}
