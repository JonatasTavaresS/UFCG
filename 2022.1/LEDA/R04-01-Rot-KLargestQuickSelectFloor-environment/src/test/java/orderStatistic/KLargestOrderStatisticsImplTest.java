package orderStatistic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class KLargestOrderStatisticsImplTest {

    private KLargestOrderStatisticsImpl<Integer> implementation;
    private Integer[] array;

    @Before
    public void setUp() {
        this.implementation = new KLargestOrderStatisticsImpl<>();
        this.array = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
    }

    @Test
    public void testGetKLargest() {

    }

    @Test
    public void testOrderStatistics01() {
        assertEquals((Integer) 4, this.implementation.orderStatistics(this.array, 1));
    }

    @Test
    public void testOrderStatistics02() {
        assertEquals((Integer) 7, this.implementation.orderStatistics(this.array, 2));
    }

    @Test
    public void testOrderStatistics04() {
        assertEquals((Integer) 31, this.implementation.orderStatistics(this.array, 10));
    }

    @Test
    public void testOrderStatistics06() {
        assertNull(this.implementation.orderStatistics(null, 1));
    }

    @Test
    public void testOrderStatistics07() {
        assertNull(this.implementation.orderStatistics(this.array, 11));
    }

    @Test
    public void testOrderStatistics08() {
        assertNull(this.implementation.orderStatistics(this.array, 0));
    }

    @Test
    public void testOrderStatistics09() {
        assertNull(this.implementation.orderStatistics(new Integer[] {}, 1));
    }
}