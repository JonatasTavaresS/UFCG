package orderStatistic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class QuickSelectTest {

    private QuickSelect<Integer> implementation;
    private Integer[] array;

    @Before
    public void setUp() {
        this.implementation = new QuickSelect<>();
        this.array = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
    }

    @Test
    public void testQuickSelect01() {
        assertEquals((Integer) 4, this.implementation.quickSelect(this.array, 1));
    }

    @Test
    public void testQuickSelect02() {
        assertEquals((Integer) 7, this.implementation.quickSelect(this.array, 2));
    }

    @Test
    public void testQuickSelect03() {
        assertEquals((Integer) 31, this.implementation.quickSelect(this.array, 10));
    }

    @Test
    public void testQuickSelect04() {
        assertNull(this.implementation.quickSelect(null, 1));
    }

    @Test
    public void testQuickSelect05() {
        assertNull(this.implementation.quickSelect(this.array, 11));
    }

    @Test
    public void testQuickSelect06() {
        assertNull(this.implementation.quickSelect(this.array, 0));
    }

    @Test
    public void testQuickSelect07() {
        assertNull(this.implementation.quickSelect(new Integer[] {}, 1));
    }
}
