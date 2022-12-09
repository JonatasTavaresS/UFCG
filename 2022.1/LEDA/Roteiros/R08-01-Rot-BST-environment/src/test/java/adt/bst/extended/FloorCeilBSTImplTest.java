package adt.bst.extended;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class FloorCeilBSTImplTest {

    private FloorCeilBSTImpl implementation;

    @Before
    public void setUp() {
        implementation = new FloorCeilBSTImpl();
    }

    @Test
    public void testFloor01() {
        Integer[] array = null;
        assertNull(this.implementation.floor(array, 0));
        assertArrayEquals(new Integer[] {}, this.implementation.order());
    }

    @Test
    public void testFloor02() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertNull(this.implementation.floor(array, -41.3));
        Arrays.sort(array);
        assertArrayEquals(array, this.implementation.order());
    }

    @Test
    public void testFloor03() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertEquals((Integer) 232, this.implementation.floor(array, 2643.837));
        Arrays.sort(array);
        assertArrayEquals(array, this.implementation.order());
    }

    @Test
    public void testFloor04() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertEquals(Integer.valueOf("-40"), this.implementation.floor(array, -40));
        Arrays.sort(array);
        assertArrayEquals(array, this.implementation.order());
    }

    @Test
    public void testFloor05() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertEquals((Integer) 12, this.implementation.floor(array, 12.752));
        Arrays.sort(array);
        assertArrayEquals(array, this.implementation.order());
    }

    @Test
    public void testCeil01() {
        Integer[] array = null;
        assertNull(this.implementation.ceil(array, 0));
        assertArrayEquals(new Integer[] {}, this.implementation.order());
    }

    @Test
    public void testCeil02() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertEquals(Integer.valueOf("-40"), this.implementation.ceil(array, -41.3));
        Arrays.sort(array);
        assertArrayEquals(array, this.implementation.order());
    }

    @Test
    public void testCeil03() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertNull(this.implementation.ceil(array, 2643.837));
        Arrays.sort(array);
        assertArrayEquals(array, this.implementation.order());
    }

    @Test
    public void testCeil04() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertEquals(Integer.valueOf("-40"), this.implementation.ceil(array, -40));
        Arrays.sort(array);
        assertArrayEquals(array, this.implementation.order());
    }

    @Test
    public void testCeil05() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertEquals((Integer) 23, this.implementation.ceil(array, 12.752));
        Arrays.sort(array);
        assertArrayEquals(array, this.implementation.order());
    }
}
