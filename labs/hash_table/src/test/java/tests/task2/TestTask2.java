package tests.task2;

import hashtable.OAHashTable;
import org.junit.jupiter.api.Test;
import rectangle.Rectangle;
import tests.task2.dynamic.TestAdding;
import tests.task2.dynamic.TestEmptyTable;
import tests.task2.dynamic.TestRehash;
import tests.task2.dynamic.TestRemove;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestTask2 implements TestEmptyTable, TestAdding, TestRehash, TestRemove {
    @Test
    void testContains() {
        OAHashTable table = new OAHashTable(10);
        Rectangle rec1 = new Rectangle(new Point2D.Double(-465.34, 0.7), new Point2D.Double(46.32, -0.7));
        Rectangle rec2 = new Rectangle(new Point2D.Double(-8.67, -45.87), new Point2D.Double(-12.2, -445.6));
        Rectangle rec3 = new Rectangle(new Point2D.Double(67.21, -96.6), new Point2D.Double(576.465, 78));
        Rectangle rec4 = new Rectangle(new Point2D.Double(56, -34.5), new Point2D.Double(-5.9, -9.47));

        assertTrue(table.add(rec1));
        assertTrue(table.add(rec2));
        assertTrue(table.add(rec3));
        assertTrue(table.add(rec4));

        assertTrue(table.contains(rec1));
        assertTrue(table.contains(rec2));
        assertTrue(table.contains(rec3));
        assertTrue(table.contains(rec4));

        assertTrue(table.remove(rec1));
        assertFalse(table.contains(rec1));

        assertTrue(table.remove(rec2));
        assertFalse(table.contains(rec2));
    }
}