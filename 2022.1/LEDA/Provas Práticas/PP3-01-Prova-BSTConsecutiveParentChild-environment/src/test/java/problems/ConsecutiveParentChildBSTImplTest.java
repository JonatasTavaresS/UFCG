package problems;

import static org.junit.Assert.assertArrayEquals;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class ConsecutiveParentChildBSTImplTest {

    private ConsecutiveParentChildBSTImpl implementation;

    @Before
    public void setUp() {
        this.implementation = new ConsecutiveParentChildBSTImpl();
    }

    @Test
    public void test01() {
        Set<Pair> expected = new TreeSet<>();
        assertArrayEquals(expected.toArray(), this.implementation.findConsecutives().toArray());
    }

    @Test
    public void test02() {
        Set<Pair> expected = new TreeSet<>();
        this.implementation.insert(-1);
        assertArrayEquals(expected.toArray(), this.implementation.findConsecutives().toArray());
    }

    @Test
    public void test03() {
        Set<Pair> expected = new TreeSet<>();
        this.implementation.insert(-45);
        this.implementation.insert(-73);
        assertArrayEquals(expected.toArray(), this.implementation.findConsecutives().toArray());
    }

    @Test
    public void test04() {
        Integer[] elements = new Integer[] { 2, 1, 3 };
        for (Integer element : elements) {
            this.implementation.insert(element);
        }
        Set<Pair> expected = new TreeSet<>();
        expected.add(new Pair(2, 1));
        expected.add(new Pair(2, 3));
        Set<Pair> result = this.implementation.findConsecutives();
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void test05() {
        Integer[] elements = new Integer[] { 3, 7, 6, 8 };
        for (Integer element : elements) {
            this.implementation.insert(element);
        }
        Set<Pair> expected = new TreeSet<>();
        expected.add(new Pair(7, 6));
        expected.add(new Pair(7, 8));
        Set<Pair> result = this.implementation.findConsecutives();
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void test06() {
        Integer[] elements = new Integer[] { 3, 7, 5, 6, 2, 9 };
        for (Integer element : elements) {
            this.implementation.insert(element);
        }
        Set<Pair> expected = new TreeSet<>();
        expected.add(new Pair(3, 2));
        expected.add(new Pair(5, 6));
        Set<Pair> result = this.implementation.findConsecutives();
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void test07() {
        Integer[] elements = new Integer[] { 3, 7, 5, 6, 2, 9 };
        for (Integer element : elements) {
            this.implementation.insert(element);
        }
        Set<Pair> expected = new TreeSet<>();
        expected.add(new Pair(3, 2));
        expected.add(new Pair(5, 6));
        Set<Pair> result = this.implementation.findConsecutives();
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void test08() {
        Integer[] elements = new Integer[] { 0, 1, -1 };
        for (Integer element : elements) {
            this.implementation.insert(element);
        }
        Set<Pair> expected = new TreeSet<>();
        expected.add(new Pair(0, 1));
        expected.add(new Pair(0, -1));
        Set<Pair> result = this.implementation.findConsecutives();
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void test09() {
        Integer[] elements = new Integer[] { -1, -2, 0 };
        for (Integer element : elements) {
            this.implementation.insert(element);
        }
        Set<Pair> expected = new TreeSet<>();
        expected.add(new Pair(-1, -2));
        expected.add(new Pair(-1, 0));
        Set<Pair> result = this.implementation.findConsecutives();
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void test10() {
        Integer[] elements = new Integer[] { -2, -1, 0, 1, 2 };
        for (Integer element : elements) {
            this.implementation.insert(element);
        }
        Set<Pair> expected = new TreeSet<>();
        expected.add(new Pair(-2, -1));
        expected.add(new Pair(-1, 0));
        expected.add(new Pair(0, 1));
        expected.add(new Pair(1, 2));
        Set<Pair> result = this.implementation.findConsecutives();
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void test11() {
        Integer[] elements = new Integer[] { 2, 1, 0, -1, -2 };
        for (Integer element : elements) {
            this.implementation.insert(element);
        }
        Set<Pair> expected = new TreeSet<>();
        expected.add(new Pair(2, 1));
        expected.add(new Pair(1, 0));
        expected.add(new Pair(0, -1));
        expected.add(new Pair(-1, -2));
        Set<Pair> result = this.implementation.findConsecutives();
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void test12() {
        Integer[] elements = new Integer[] { 0, -3, 2, 1, 3 };
        for (Integer element : elements) {
            this.implementation.insert(element);
        }
        Set<Pair> expected = new TreeSet<>();
        expected.add(new Pair(2, 1));
        expected.add(new Pair(2, 3));
        Set<Pair> result = this.implementation.findConsecutives();
        assertArrayEquals(expected.toArray(), result.toArray());
    }
}
