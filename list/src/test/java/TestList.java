import com.project.list.doubly.DoublyLinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("Test")
    void test() {
        var dList = new DoublyLinkedList<>();
        Arrays.stream(ARRAY, 0, SIZE).forEach(dList::add);
        System.out.print(dList);

        assertEquals(SIZE, dList.size());


    }
}