package tests.task2.dynamic;

import hashtable.OAHashTable;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import rectangle.Rectangle;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public interface TestRemove {
    @TestFactory
    default Collection<DynamicTest> remove() {
        return Collections.singletonList(
                DynamicTest.dynamicTest("Test removing!!!", () -> {
                    OAHashTable table = new OAHashTable(10);
                    Rectangle rec1 = new Rectangle(
                            new Point2D.Double(4.33, 5.5),
                            new Point2D.Double(4.6, 78.6));
                    Rectangle rec2 = new Rectangle(
                            new Point2D.Double(4.5, -435.87),
                            new Point2D.Double(-12.2, -67.6));
                    Rectangle rec3 = new Rectangle(
                            new Point2D.Double(67.21, -98.12),
                            new Point2D.Double(32.76, 98.56));
                    Rectangle rec4 = new Rectangle(
                            new Point2D.Double(-45.5, -345.5),
                            new Point2D.Double(-56.9, -918.47));

                    assertFalse(rec1.equals(rec2) && rec1.equals(rec3) && rec1.equals(rec4));

                    assertTrue(table.add(rec1));
                    assertTrue(table.add(rec2));
                    assertTrue(table.add(rec3));
                    assertTrue(table.add(rec4));

                    assertEquals(4, table.size());

                    assertTrue(table.remove(rec1));
                    assertFalse(table.contains(rec1));

                    assertTrue(table.remove(rec2));
                    assertFalse(table.contains(rec2));

                    assertTrue(table.remove(rec3));
                    assertFalse(table.contains(rec3));

                    assertTrue(table.remove(rec4));
                    assertFalse(table.contains(rec4));

                    assertFalse(table.remove(rec1));
                    assertFalse(table.remove(rec2));
                    assertTrue(table.isEmpty());
                })
        );
    }
}