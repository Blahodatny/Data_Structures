package tests.task1.dynamic;

import hashtable.HashTable;
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
                    var table = new HashTable(9, 0.34);
                    var rec = new Rectangle(
                            new Point2D.Double(23.32, 45),
                            new Point2D.Double(-56.76, 345.55));

                    assertTrue(table.add(rec));
                    assertEquals(1, table.size());

                    assertTrue(table.remove(rec));
                    assertTrue(table.isEmpty());
                }),

                DynamicTest.dynamicTest("Test adding several elements!!!", () -> {
                    var hashtable = new HashTable(20);
                    var rec = new Rectangle(
                            new Point2D.Double(-123.321, -56.34),
                            new Point2D.Double(68.08, 132.756));
                    hashtable.add(rec);

                    assertTrue(hashtable.contains(
                            new Rectangle(
                                    new Point2D.Double(-123.321, -56.34),
                                    new Point2D.Double(68.08, 132.756))));
                    assertTrue(hashtable.contains(rec));

                    var x = 23.32;
                    var y = 56.54;
                    var x1 = 67.54;
                    var y1 = 89.45;
                    var size = 1;

                    for (var i = 0; i < 10; i++) {
                        if (hashtable.add(
                                new Rectangle(
                                        new Point2D.Double(x, y),
                                        new Point2D.Double(x1, y1))))
                            size++;
                        if (i % 2 == 0) {
                            x += 10;
                            y += 10;
                            x1 += 10;
                            y1 += 10;
                        }
                    }
                    assertEquals(size, hashtable.size());
                    assertFalse(hashtable.isEmpty());
                })
        );
    }
}