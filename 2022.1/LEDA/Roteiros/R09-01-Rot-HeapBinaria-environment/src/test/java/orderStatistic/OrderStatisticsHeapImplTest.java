package orderStatistic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class OrderStatisticsHeapImplTest {

    OrderStatisticsHeapImpl<Integer> implementation;

    @Before
    public void setUp() {
        implementation = new OrderStatisticsHeapImpl<>();
    }

    @Test
    public void test01() {
        assertNull(implementation.getOrderStatistics(null, 0));
    }

    @Test
    public void test02() {
        assertNull(implementation.getOrderStatistics(new Integer[] {}, 0));
    }

    @Test
    public void test03() {
        assertNull(implementation.getOrderStatistics(new Integer[] { 1, 3, 2 }, 0));
    }

    @Test
    public void test04() {
        assertNull(implementation.getOrderStatistics(new Integer[] { 1, 3, 2 }, 4));
    }

    @Test
    public void test05() {
        assertEquals((Integer) 1, implementation.getOrderStatistics(new Integer[] { 1, 3, 2 }, 1));
        assertEquals((Integer) 1, implementation.getOrderStatistics(new Integer[] { 2, 1, 3 }, 1));
        assertEquals((Integer) 1, implementation.getOrderStatistics(new Integer[] { 2, 3, 1 }, 1));
    }

    @Test
    public void test06() {
        assertEquals((Integer) 3, implementation.getOrderStatistics(new Integer[] { 3, 1, -2 }, 3));
        assertEquals((Integer) 3, implementation.getOrderStatistics(new Integer[] { 2, 3, 1 }, 3));
        assertEquals((Integer) 3, implementation.getOrderStatistics(new Integer[] { 2, -1, 3 }, 3));
    }

    @Test
    public void test07() {
        assertEquals((Integer) 1, implementation.getOrderStatistics(new Integer[] { 1 }, 1));
    }

    @Test
    public void test08() {
        assertEquals((Integer) 1, implementation.getOrderStatistics(new Integer[] { 1 }, 1));
    }

}
