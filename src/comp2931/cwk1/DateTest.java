package comp2931.cwk1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


/**
 * Unit tests for the Date class.
 */

public class DateTest {

    private Date firstDay;
    private Date lastDay;


  @Before
  public void setUp() {
    firstDay = new Date(2017,1,1);
    lastDay = new Date(2017,12,31);
  }





  @Test
  public void timeToString() {
    assertThat(firstDay.toString(), is("2017-01- 1"));
    assertThat(lastDay.toString(), is("2017-12-31"));
  }
}
