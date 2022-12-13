package adt.heap.extended;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import adt.heap.ComparatorMaxHeap;

public class FloorCeilMaxHeapImplTest {

    private FloorCeilHeapImpl implementation;

    @Before
    public void setUp() {
        Comparator<Integer> comparator = new ComparatorMaxHeap<>();
        implementation = new FloorCeilHeapImpl(comparator);
    }

    @Test
    public void testFloor01() {
        Integer[] array = null;
        assertNull(this.implementation.floor(array, 0));
    }

    @Test
    public void testFloor02() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertNull(this.implementation.floor(array, -41.3));
    }

    @Test
    public void testFloor03() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertEquals((Integer) 232, this.implementation.floor(array, 2643.837));
    }

    @Test
    public void testFloor04() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertEquals(Integer.valueOf("-40"), this.implementation.floor(array, -40));
    }

    @Test
    public void testFloor05() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertEquals((Integer) 12, this.implementation.floor(array, 12.752));
    }

    @Test
    public void testCeil01() {
        Integer[] array = null;
        assertNull(this.implementation.ceil(array, 0));
    }

    @Test
    public void testCeil02() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertEquals(Integer.valueOf("-40"), this.implementation.ceil(array, -41.3));
    }

    @Test
    public void testCeil03() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertNull(this.implementation.ceil(array, 2643.837));
    }

    @Test
    public void testCeil04() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertEquals(Integer.valueOf("-40"), this.implementation.ceil(array, -40));
    }

    @Test
    public void testCeil05() {
        Integer[] array = new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        assertEquals((Integer) 23, this.implementation.ceil(array, 12.752));
    }

}
