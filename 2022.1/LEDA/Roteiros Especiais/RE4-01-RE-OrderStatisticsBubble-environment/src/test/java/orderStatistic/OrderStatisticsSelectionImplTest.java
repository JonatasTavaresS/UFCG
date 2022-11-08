package orderStatistic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class OrderStatisticsSelectionImplTest {

    private OrderStatistics<Integer> implementation;
    private Integer[] array;

    @Before
    public void setUp() {
        this.implementation = new OrderStatisticsSelectionImpl<>();
        this.array = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
    }

    @Test
    public void testGetOrderStatistics01() {
        assertEquals((Integer) 4, this.implementation.getOrderStatistics(this.array, 1));
    }

    @Test
    public void testGetOrderStatistics02() {
        assertEquals((Integer) 7, this.implementation.getOrderStatistics(this.array, 2));
    }

    @Test
    public void testGetOrderStatistics04() {
        assertEquals((Integer) 31, this.implementation.getOrderStatistics(this.array, 10));
    }

    @Test
    public void testGetOrderStatistics06() {
        assertNull(this.implementation.getOrderStatistics(null, 1));
    }

    @Test
    public void testGetOrderStatistics07() {
        assertNull(this.implementation.getOrderStatistics(this.array, 11));
    }

    @Test
    public void testGetOrderStatistics08() {
        assertNull(this.implementation.getOrderStatistics(this.array, 0));
    }

    @Test
    public void testGetOrderStatistics09() {
        assertNull(this.implementation.getOrderStatistics(new Integer[] {}, 1));
    }
}
