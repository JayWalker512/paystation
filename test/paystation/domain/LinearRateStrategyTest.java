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

public class LinearRateStrategyTest {

    LinearRateStrategy rs;

    @Before
    public void setup() {
        rs = new LinearRateStrategy();
    }

    /**
     * Entering 5 cents should make the display report 2 minutes parking time.
     */
    @Test
    public void minutesPerCents() {
        assertEquals("0 minutes for 0 payment", 0, rs.calculateTime(0));
        assertEquals("10 cents gives 4 mins", 4, rs.calculateTime(10));
    }
}
