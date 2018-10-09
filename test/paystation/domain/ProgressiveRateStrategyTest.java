/**
 * Testcases for the Pay Station system.
 *
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 *
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
package paystation.domain;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ProgressiveRateStrategyTest {

    ProgressiveRateStrategy rs;

    @Before
    public void setup() {
        rs = new ProgressiveRateStrategy();
    }

    /**
     * Entering 5 cents should make the display report 2 minutes parking time.
     */
    @Test
    public void minutesPerCents() {
        assertEquals("0 minutes for 0 payment", 0, rs.calculateTime(0));
        assertEquals("10 cents gives 4 mins", 4, rs.calculateTime(10));
        assertEquals("100 cents gives 40 minutes", 40, rs.calculateTime(100));
        
        //now if we buy over an hour, we can see if it's being "progressive" for the 2nd hour
        assertEquals("150 cents gives 60 minutes", 60, rs.calculateTime(150));
        assertEquals("200 cents gives 75 minutes", 75, rs.calculateTime(200));
        
        //test if 3rd hour follows provided formula
        assertEquals("400 cents gives 130 minutes", 130, rs.calculateTime(400));
    }
}
