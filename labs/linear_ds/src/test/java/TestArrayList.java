import list.ArrayList;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TestArrayList {
    private static int QUANTITY = 10;

    @Test
    void testAddMethods() {
        ArrayList list = new ArrayList();
        final Random random = new Random();
        for (int i = 0; i < QUANTITY; ++i)
            list.add(Integer.toString(random.nextInt() % 100 + 101));
        list.print();
        assertFalse(list.add("-345"));
        assertFalse(list.add("0"));
        assertFalse(list.add("%$%gh"));
        assertFalse(list.add(""));
        assertFalse(list.add(null));

        assertTrue(list.add("6766"));
        System.out.println("\nThe list after adding an element \"6766\":");
        list.printElements();

        assertFalse(list.add(list.size(), "645"));
        assertFalse(list.add(5, "-67"));

        assertTrue(list.add(0, "3445"));
        System.out.println("\nThe list after adding:\n -an element \"3445\" at first position");
        list.printElements();
        assertTrue(list.add(list.size() - 1, "6477"));
        System.out.println("\n -an element \"6477\" at list.size() - 1");
        list.printElements();
        assertTrue(list.add(5, "46599"));
        System.out.println("\n -an element \"46599\" at fifth position");
        list.printElements();
    }

    @Test
    void testRemoveMethods() {
        ArrayList list = new ArrayList();
        final Random random = new Random();
        for (int i = 0; i < QUANTITY; ++i)
            list.add(Integer.toString(random.nextInt() % 100 + 101));
        System.out.println("\n");
        list.print();

        assertNull(list.remove(list.size()));

        String temp = list.get(0);
        assertEquals(temp, list.remove(0));
        System.out.print("Removing from 0 position: ");
        list.printElements();
        assertEquals(list.get(list.size() - 1), list.remove(list.size() - 1));
        System.out.print("Removing from last position: ");
        list.printElements();

        assertFalse(list.remove("34344"));
        assertTrue(list.remove(list.get(5)));
        System.out.print("Removing from 5-th position: ");
        list.printElements();
        assertTrue(list.remove(list.get(0)));
        System.out.print("Removing from 0 position: ");
        list.printElements();
        assertTrue(list.remove(list.get(list.size() - 1)));
        System.out.print("Removing from last position: ");
        list.printElements();

        for (int i = 0; i < QUANTITY; i++)
            assertEquals(list.get(0), list.remove(0));
        list.print();
        assertTrue(list.isEmpty());
    }
}