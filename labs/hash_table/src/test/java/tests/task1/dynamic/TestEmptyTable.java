package tests.task1.dynamic;

import hashtable.HashTable;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import rectangle.Rectangle;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public interface TestEmptyTable {
    @TestFactory
    default Collection<DynamicTest> emptyTable() {
        return Collections.singletonList(
                DynamicTest.dynamicTest("Testing empty table!!!", () -> {
                    var tableEmpty = new HashTable(3);

                    assertEquals(0, tableEmpty.size());
                    assertTrue(tableEmpty.isEmpty());

                    var rectangle = new Rectangle(
                            new Point2D.Double(23.32, 45),
                            new Point2D.Double(-56.76, 345.55));

                    assertFalse(tableEmpty.remove(rectangle));
                    assertEquals(tableEmpty.size(), 0);
                    assertFalse(tableEmpty.contains(rectangle));
                })
        );
    }
}