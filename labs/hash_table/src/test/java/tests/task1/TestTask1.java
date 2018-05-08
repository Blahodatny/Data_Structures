package tests.task1;

import hashtable.HashTable;
import org.junit.jupiter.api.Test;
import rectangle.Rectangle;
import tests.task1.dynamic.TestAdding;
import tests.task1.dynamic.TestEmptyTable;

import java.awt.geom.Point2D;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestTask1 implements TestEmptyTable, TestAdding {
    @Test
    void testRehashRemove() {
        var table = new HashTable(5, 0.78);
        final var random = new Random();
        while (table.size() < 40)
            table.add(
                    new Rectangle(
                            new Point2D.Double(
                                    random.nextInt(100) - 50 + random.nextDouble(),
                                    random.nextInt(100) - 50 + random.nextDouble()),
                            new Point2D.Double(
                                    random.nextInt(100) - 50 + random.nextDouble(),
                                    random.nextInt(100) - 50 + random.nextDouble())));

        assertFalse(table.isEmpty());
        assertFalse(table.contains(null));
        assertFalse(table.remove(null));

        var rec = new Rectangle(
                new Point2D.Double(444.4, 567.321),
                new Point2D.Double(-56.34, 567.432));
        if (table.add(rec))
            assertTrue(table.remove(rec));
        else
            assertFalse(table.contains(rec));
    }
}