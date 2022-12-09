package problems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class BitonicPointBinarySearchImplTest {

    private BitonicPointBinarySearch<Integer> implementation;

    @Before
    public void setUp() {
        this.implementation = new BitonicPointBinarySearchImpl<>();
    }

    @Test
    public void testBitonicPoint01() {
        assertNull(this.implementation.bitonicPoint(null));
    }

    @Test
    public void testBitonicPoint02() {
        assertNull(this.implementation.bitonicPoint(new Integer[] {}));
    }

    @Test
    public void testBitonicPoint04() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 7, 12, 16, 20, 7, 4, 2, 1 }));
    }

    @Test
    public void testBitonicPoint05() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 7, 12, 20, 8, 7, 4, 2, 1 }));
    }

    @Test
    public void testBitonicPoint06() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 7, 20, 9, 8, 7, 4, 2, 1 }));
    }

    @Test
    public void testBitonicPoint07() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 20, 9, 8, 7, 4, 2, 1 }));
    }

    @Test
    public void testBitonicPoint08() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 7, 12, 16, 17, 20, 4, 2, 1 }));
    }

    @Test
    public void testBitonicPoint09() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 7, 12, 16, 17, 18, 19, 20, 1 }));
    }

    @Test
    public void testBitonicPoint10() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 7, 12, 16, 17, 18, 19, 20 }));
    }

    @Test
    public void testBitonicPoint11() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 20 }));
    }

    @Test
    public void testBitonicPoint12() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 20, 7 }));
    }

    @Test
    public void testBitonicPoint13() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 17, 20 }));
    }

    @Test
    public void testBitonicPoint14() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 20, 17, 7 }));
    }

    @Test
    public void testBitonicPoint15() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 17, 20, 7 }));
    }

    @Test
    public void testBitonicPoint17() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 16, 17, 20 }));
    }

    @Test
    public void testBitonicPoint18() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 16, 17, 20, 7 }));
    }

    @Test
    public void testBitonicPoint19() {
        assertEquals((Integer) 20, this.implementation.bitonicPoint(new Integer[] { 16, 20, 8, 7 }));
    }
}
