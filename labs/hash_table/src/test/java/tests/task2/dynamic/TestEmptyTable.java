package tests.task2.dynamic;

import hashtable.OAHashTable;
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
                    var tableEmpty = new OAHashTable(3);

                    assertEquals(0, tableEmpty.size());
                    assertTrue(tableEmpty.isEmpty());

                    var rectangle = new Rectangle(
                            new Point2D.Double(45.4, 567.6),
                            new Point2D.Double(576.354, 13.45));

                    assertFalse(tableEmpty.remove(rectangle));
                    assertEquals(0, tableEmpty.size());
                    assertFalse(tableEmpty.contains(rectangle));
                })
        );
    }
}