import list.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class TestLinkedList {
    private static int QUANTITY = 10;

    @Test
    void testGetters() {
        var list = new LinkedList();
        IntStream.range(0, QUANTITY).mapToObj(i -> Integer.toString(i * 3)).forEach(list::add);
        assertEquals(10, list.size());
        assertEquals("3", list.next.get());
        assertEquals("1", list.get(0));

        assertEquals("27", list.get(list.size() - 1));
        assertNull(list.get(list.size()));
    }

    @Test
    void testSetters() {
        var list = new LinkedList();
        IntStream.range(0, QUANTITY).mapToObj(i -> Integer.toString(i * 3)).forEach(list::add);
        assertEquals("1", list.set("24"));
        assertNull(list.set("ghgh"));
        assertEquals("24", list.set(0, "56"));

        assertEquals("27", list.set(list.size() - 1, "67"));
        assertNull(list.set(list.size(), "45"));
        assertNull(list.set(3, "ji"));
    }

    @Test
    void testAddMethod() {
        var list = new LinkedList();
        final var random = new Random();
        IntStream.range(0, QUANTITY).mapToObj(i -> Integer.toString(random.nextInt() % 100 + 101)).forEach(list::add);
        assertFalse(list.add("gh"));
        assertFalse(list.add("-345"));

        assertFalse(list.add(list.size(), "45"));
        assertTrue(list.add(0, "132"));
        assertTrue(list.add(list.size() - 1, "978"));

        assertEquals(list.size(), 13);
    }

    @Test
    void testRemoveMethod() {
        var list = new LinkedList();
        final var random = new Random();
        IntStream.range(0, QUANTITY).mapToObj(i -> Integer.toString(random.nextInt() % 100 + 101)).forEach(list::add);
        assertEquals(list.get(list.size() - 1), list.remove(list.size() - 1));
        assertEquals(list.get(0), list.remove(0));
        assertEquals(list.get(1), list.remove(1));
        assertEquals(list.size(), 8);

        assertTrue(list.remove(list.get(list.size() - 1)));
        assertTrue(list.remove(list.get(0)));
        assertTrue(list.remove(list.get(5)));
        assertFalse(list.remove("-345"));
        assertFalse(list.remove(list.get(list.size())));
    }
}