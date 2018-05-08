import org.junit.jupiter.api.Test;
import stack.LinkedStack;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestLinkedStack {
    private static final int QUANTITY = 10;

    @Test
    void testPopPushMethods() {
        var stack = new LinkedStack();
        final var random = new Random();
        IntStream.range(0, QUANTITY).map(i -> random.nextInt(100)).forEach(stack::push);
        stack.print();

        System.out.println("\nAfter removing all elements:\n");
        var size = 9;
        for (var i = 0; stack.size() != 0; i++) {
            assertEquals(stack.top(), stack.pop());
            assertEquals(stack.size(), size--);
            if (!stack.isEmpty())
                System.out.printf("Iteration: %d\nThe size is: %d   The top element is: %d\n\n", i, stack.size(), stack.top());
            else
                System.out.printf("Iteration: %d\nThe size is: %d\n\n", i, stack.size());
        }
        assertTrue(stack.isEmpty());
        stack.print();
    }
}