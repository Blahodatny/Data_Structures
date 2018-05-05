import list.DoublyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestDoublyLinkedList {
    @Test
    void testDoublyLinkedList() {
        DoublyLinkedList list = new DoublyLinkedList();
        ArrayList<Integer> testList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            testList.add(i);
            list.add(i);
        }

        assertArrayEquals(testList.stream().mapToInt(i -> i).toArray(), list.toArray());

        testList.remove(0);
        testList.remove(4);
        testList.remove(6);

        assertEquals(0, list.removeAt(0));
        assertEquals(5, list.removeAt(4));
        assertEquals(8, list.removeAt(6));
        assertEquals(0, list.removeAt(-1));

        testList.remove(1);
        assertTrue(list.remove(2));
        assertArrayEquals(testList.stream().mapToInt(i -> i).toArray(), list.toArray());

        assertEquals(testList.get(1).intValue(), list.get(1));
        assertEquals(testList.get(testList.size() - 1).intValue(), list.get(list.size() - 1));
        assertEquals(0, list.get(180));

        assertEquals(543, list.set(1, 543));
        assertEquals(0, list.set(-2, 543));
        testList.set(1, 543);

        assertTrue(list.add(4, 48));
        assertTrue(list.add(0, 50));

        assertFalse(list.add(-1, 90));
        assertFalse(list.add(1050, 90));

        testList.add(4, 48);
        testList.add(0, 50);

        assertArrayEquals(testList.stream().mapToInt(i -> i).toArray(), list.toArray());
    }
}