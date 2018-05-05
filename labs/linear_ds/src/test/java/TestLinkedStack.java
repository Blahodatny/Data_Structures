import org.junit.jupiter.api.Test;
import stack.LinkedStack;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestLinkedStack {
    private static final int QUANTITY = 10;

    @Test
    void testPopPushMethods() {
        LinkedStack stack = new LinkedStack();
        final Random random = new Random();
        for (int i = 0; i < QUANTITY; i++)
            stack.push(random.nextInt(100));
        stack.print();

        System.out.println("\nAfter removing all elements:\n");
        int size = 9;
        for (int i = 0; stack.size() != 0; i++) {
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