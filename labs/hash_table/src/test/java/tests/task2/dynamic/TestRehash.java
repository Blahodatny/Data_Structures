package tests.task2.dynamic;

import hashtable.OAHashTable;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import rectangle.Rectangle;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public interface TestRehash {
    @TestFactory
    default Collection<DynamicTest> rehash() {
        return Collections.singletonList(
                DynamicTest.dynamicTest("Test rehashing!!!", () -> {
                    int capacity = 5;
                    double loadFactor = 0.5;
                    OAHashTable table = new OAHashTable(capacity, loadFactor);
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

                    assertTrue(table.add(rec1));
                    assertTrue(table.add(rec2));
                    assertEquals(2, table.size());
                    assertTrue((table.size() + 1) / (double) capacity >= loadFactor);

                    assertTrue(table.add(rec3));
                    assertEquals(3, table.size());
                    assertTrue(table.add(rec4));
                    assertEquals(4, table.size());
                })
        );
    }
}