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

    private Date firstDay;
    private Date lastDay;
    private Date day242;


    @Before
    public void setUp()
    {
        firstDay = new Date(2017,1,1);
        lastDay = new Date(2017,12,31);
        day242 = new Date(2017,8,30);
    }


    @Test
    public void timeToString()
    {
        assertThat(firstDay.toString(), is("2017-01- 1"));
        assertThat(lastDay.toString(), is("2017-12-31"));
        assertThat(day242.toString(), is("2017-08-30"));
    }

    @Test
    public void dayNumber()
    {
        assertThat(firstDay.getDayOfYear(), is(1));
        assertThat(lastDay.getDayOfYear(), is(365));
        assertThat(day242.getDayOfYear(), is(242));
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


}
