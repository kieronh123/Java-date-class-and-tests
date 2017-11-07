package comp2931.cwk1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


/**
 * Unit tests for the Date class.
 */

public class DateTest
{

    private Date firstDayOfYear;
    private Date lastDay;
    private Date day242;
    private Date feb29LeapYear;
    private Date lastDayOfLeapYear;
    private Date currentDate;


    @Before
    public void setUp()
    {
        firstDayOfYear = new Date(2017,1,1);
        lastDay = new Date(2017,12,31);
        day242 = new Date(2017,8,30);
        feb29LeapYear = new Date(2004,2,29);
        lastDayOfLeapYear = new Date(2008,12,31);
        currentDate = new Date();
    }


    @Test
    public void timeToString()
    {
        assertThat(firstDayOfYear.toString(), is("2017-01-01"));
        assertThat(lastDay.toString(), is("2017-12-31"));
        assertThat(day242.toString(), is("2017-08-30"));
        assertThat(feb29LeapYear.toString(), is("2004-02-29"));
        assertThat(lastDayOfLeapYear.toString(), is("2008-12-31"));
        //assertThat(currentDate.toString(), is("2017-10-26"));
    }

    @Test
    public void dayNumber()
    {
        assertThat(firstDayOfYear.getDayOfYear(), is(1));
        assertThat(lastDay.getDayOfYear(), is(365));
        assertThat(day242.getDayOfYear(), is(242));
        assertThat(feb29LeapYear.getDayOfYear(), is(60));
        assertThat(lastDayOfLeapYear.getDayOfYear(), is(366));
    }

    @Test
    public void equality() {
      assertTrue(firstDayOfYear.equals(firstDayOfYear));
      assertTrue(firstDayOfYear.equals(new Date(2017, 1, 1)));
      assertFalse(firstDayOfYear.equals(new Date(2017, 1, 2)));
      assertFalse(firstDayOfYear.equals(new Date(2017, 2, 1)));
      assertFalse(firstDayOfYear.equals("2017-01-01"));
    }


    @Test(expected=IllegalArgumentException.class)
    public void yearTooLow()
    {
        new Date(-1,1,1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void monthTooLow()
    {
        new Date(2017,-1,10);
    }

    @Test(expected=IllegalArgumentException.class)
    public void monthTooHigh()
    {
        new Date(2017,13,15);
    }

    @Test(expected=IllegalArgumentException.class)
    public void dayTooLow()
    {
        new Date(2017,3,-1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void dayTooHigh()
    {
        new Date(2017,5,32);
    }

    @Test(expected=IllegalArgumentException.class)
    public void invalidDate()
    {
        new Date(2017,4,31);
    }

    @Test(expected=IllegalArgumentException.class)
    public void invalidLeapDate()
    {
        new Date(2011,2,29);
    }

}
