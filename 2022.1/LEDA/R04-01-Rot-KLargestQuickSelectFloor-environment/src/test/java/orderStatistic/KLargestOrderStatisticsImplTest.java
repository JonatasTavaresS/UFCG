package orderStatistic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

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
    public void testGetKLargest01() {
        assertArrayEquals(new Integer[] { 31 }, this.implementation.getKLargest(this.array, 1));
    }

    @Test
    public void testGetKLargest02() {
        assertArrayEquals(new Integer[] { 30, 31 }, this.implementation.getKLargest(this.array, 2));
    }

    @Test
    public void testGetKLargest03() {
        assertArrayEquals(new Integer[] { 29, 30, 31 }, this.implementation.getKLargest(this.array, 3));
    }

    @Test
    public void testGetKLargest04() {
        assertFalse(
                Arrays.deepEquals(new Integer[] { 28, 29, 30, 31 }, this.implementation.getKLargest(this.array, 4)));
    }

    @Test
    public void testGetKLargest05() {
        assertArrayEquals(new Integer[] {}, this.implementation.getKLargest(this.array, 11));
    }

    @Test
    public void testGetKLargest06() {
        assertArrayEquals(new Integer[] {}, this.implementation.getKLargest(new Integer[] {}, 1));
    }

    @Test
    public void testGetKLargest07() {
        assertArrayEquals(new Integer[] {}, this.implementation.getKLargest(null, 1));
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
