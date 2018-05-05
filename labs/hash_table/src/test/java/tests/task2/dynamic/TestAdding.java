package tests.task2.dynamic;

import hashtable.OAHashTable;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import rectangle.Rectangle;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public interface TestAdding {
    @TestFactory
    default Collection<DynamicTest> add() {
        return Arrays.asList(
                DynamicTest.dynamicTest("Test adding one element!!!", () -> {
                    OAHashTable table = new OAHashTable(4);
                    Rectangle rectangle = new Rectangle(
                            new Point2D.Double(4, 5),
                            new Point2D.Double(465.78, -142.45));

                    assertTrue(table.add(rectangle));
                    assertFalse(table.isEmpty());
                    assertEquals(1, table.size());

                    assertTrue(table.contains(rectangle));

                    assertTrue(table.remove(rectangle));
                    assertTrue(table.isEmpty());
                }),

                DynamicTest.dynamicTest("Test adding several not unique elements!!!", () -> {
                    OAHashTable table = new OAHashTable(10);
                    Rectangle rec1 = new Rectangle(
                            new Point2D.Double(4.33, 5.5),
                            new Point2D.Double(4.6, 78.6));
                    Rectangle rec2 = new Rectangle(
                            new Point2D.Double(45.5, -345.5),
                            new Point2D.Double(-12.2, -67.6));
                    Rectangle rec3 = new Rectangle(
                            new Point2D.Double(4.33, 5.5),
                            new Point2D.Double(4.6, 78.6));
                    Rectangle rec4 = new Rectangle(
                            new Point2D.Double(45.5, -345.5),
                            new Point2D.Double(-12.2, -67.6));

                    assertTrue(rec1.equals(rec3) && rec2.equals(rec4));

                    assertTrue(table.add(rec1));
                    assertTrue(table.add(rec2));

                    assertFalse(table.add(rec3));
                    assertFalse(table.add(rec4));

                    assertEquals(2, table.size());
                }),

                DynamicTest.dynamicTest("Test adding several unique elements!!!", () -> {
                    OAHashTable table = new OAHashTable();
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
                    assertTrue(table.add(rec3));
                    assertTrue(table.add(rec4));

                    assertEquals(4, table.size());

                    assertFalse(table.add(rec1));
                    assertFalse(table.add(rec2));
                    assertFalse(table.add(rec3));
                    assertFalse(table.add(rec4));
                })
        );
    }
}