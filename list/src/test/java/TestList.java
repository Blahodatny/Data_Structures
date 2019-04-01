import com.project.list.doubly.DoublyLinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestList {
    private static final int SIZE = 15;
    private static final int MIN = -10;
    private static final int MAX = 10;
    private static final String FILENAME = "Random.csv";

    @BeforeAll
    static void randomize() {
        var random = new Random();
        new FileWorker().write(
                FILENAME,
                IntStream
                        .range(0, SIZE)
                        .map(i -> random.nextInt(MAX - MIN + 1) + MIN)
                        .toArray()
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = FILENAME)
    void test(String str) {
        System.out.print(str + "    dlkfvldkfnv    ");
    }
}