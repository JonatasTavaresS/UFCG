package problems;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FloorBinarySearchImplTest {

    private Floor implementation;
    private Integer[] vetor1;
    private Integer[] vetor2;

    @Before
    public void setUp() {
        this.implementation = new FloorBinarySearchImpl();
        this.vetor1 = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
        this.vetor2 = new Integer[] { -30, -28, 7, 29, 11, 26, 4, 22, 23, -31 };
    }

    @Test
    public void testFloorArrayNulo() {
        assertNull(this.implementation.floor(null, 7));
    }

    @Test
    public void testFloorXNulo() {
        assertNull(this.implementation.floor(vetor1, null));
    }

    @Test
    public void testFloorProprioElemento() {
        assertEquals((Integer) 7, this.implementation.floor(vetor1, 7));
    }

    @Test
    public void testFloorProprioElementoMaisProximo() {
        assertEquals((Integer) 23, this.implementation.floor(vetor1, 25));
    }

    @Test
    public void testFloorInexistente() {
        assertNull(this.implementation.floor(vetor1, 3));
    }

    @Test
    public void testFloorNegativoExistente() {
        assertEquals(Integer.valueOf("-28"), this.implementation.floor(vetor2, -28));
    }

    @Test
    public void testFloorNegativomaisProximo() {
        assertEquals(Integer.valueOf("-30"), this.implementation.floor(vetor2, -29));
    }

    @Test
    public void testFloorUnitarioExistente() {
        assertEquals((Integer) 2, this.implementation.floor(new Integer[] { 2 }, 2));
    }

    @Test
    public void testFloorUnitarioMaisProximo() {
        assertNull(this.implementation.floor(new Integer[] { 2 }, 1));
    }

    @Test
    public void testFloorVazio() {
        assertNull(this.implementation.floor(new Integer[] {}, 1));
    }
}
