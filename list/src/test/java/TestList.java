import com.project.list.doubly.DoublyLinkedList;
import com.project.list.singly.SinglyLinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestList {
    private static final int SIZE = 15;
    private static final int MIN = -10;
    private static final int MAX = 10;
    private static final String FILENAME = "Random.csv";
    private static int[] ARRAY;

    @BeforeAll
    static void randomize() {
        var random = new Random();
        var worker = new FileWorker();
        worker.write(
                FILENAME,
                IntStream
                        .range(0, SIZE)
                        .map(i -> random.nextInt(MAX - MIN + 1) + MIN)
                        .toArray()
        );
        ARRAY = worker.readFile(FILENAME, SIZE);
    }

    @Test
    @DisplayName("Test List!!!")
    void test() {
        var dList = new DoublyLinkedList<Integer>();

        assertNull(dList.delete(SIZE));

        Arrays.stream(ARRAY, 0, SIZE).forEach(dList::add);
        System.out.println(dList);

        assertEquals(SIZE, dList.size());

        dList.addFirst(dList.delete(0));

        assertNull(dList.get(-1));
        assertNull(dList.get(SIZE + 1));

        var sList = new SinglyLinkedList<Integer>();
        for (var i = 0; i < dList.size(); i++) {
            var cur = dList.get(i);
            if (cur < -5 || cur > 5) {
                dList.delete(i--);
                if (cur % 2 == 0)
                    sList.addFirst(cur);
                else
                    sList.add(cur);
            }
        }

        System.out.println(dList);
        System.out.println(sList);
    }
}