import org.junit.jupiter.api.Test;
import queue.ArrayQueue;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestArrayQueue {
    @Test
    void testArrayQueue() {
        var q1 = new ArrayQueue();
        var q2 = new ArrayQueue(10);

        test(q1, true, 0);
        test(q2, true, 0);

        IntStream.range(0, 12).forEach(i -> {
            assertEquals(i % 20 == 8, q1.enqueue(i));
            assertEquals(i % 20 == 10, q2.enqueue((int) Math.pow(i, 2)));
        });

        test(q1, false, 12);
        test(q2, false, 12);

        IntStream.range(0, 5).forEach(i -> {
            assertEquals(i, q1.dequeue());
            assertEquals((int) Math.pow(i, 2), q2.dequeue());
        });

        IntStream.range(0, 7).forEach(i -> {
            assertEquals(i + 5, q1.dequeue());
            assertEquals((int) Math.pow(i + 5, 2), q2.dequeue());
        });

        test(q1, true, 0);
        test(q2, true, 0);
    }

    private static void test(ArrayQueue q, boolean expectedIsEmpty, int expectedSize) {
        assertEquals(expectedIsEmpty, q.isEmpty());
        assertEquals(expectedSize, q.size());
        assertEquals(0, q.head());
    }
}