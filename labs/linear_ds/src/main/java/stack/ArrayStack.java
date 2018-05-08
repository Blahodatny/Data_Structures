package stack;

import java.util.Arrays;
import java.util.stream.IntStream;

class ArrayStack {
    private double[] stack;
    private final static int defaultCapacity = 2;
    private int top;

    private boolean isEmpty() {
        return top == 0;
    }

    private ArrayStack() {
        stack = new double[defaultCapacity];
    }

    private double pop() {
        if (isEmpty()) {
            System.err.println("Unable to delete element(STACK IS EMPTY)");
            return -1;
        }

        var delItem = stack[--top];
        stack[top] = 0.0;
        return delItem;
    }

    private void push(double item) {
        if (top == stack.length) stretch();
        stack[top++] = item;
    }

    private double top() {
        if (isEmpty()) {
            System.err.println("Unable to get element(STACK IS EMPTY)");
            return -1;
        }
        return stack[top - 1];
    }

    private int size() {
        return top;
    }

    private void stretch() {
        stack = Arrays.copyOf(stack, top + 16);
    }

    public static void main(String[] args) {
        var stack = new ArrayStack();
        double[] numbers = {1, 2, 3, 4, 5.0, -32.2, 3.2, 56.7, -1, 2};
        stack.top();
        System.out.print("\nStack: ");
        IntStream.range(0, 2).forEach(i -> {
            stack.push(numbers[i]);
            System.out.print(numbers[i] + " ");
        });

        System.out.println("\nTop: " + stack.top());
        System.out.println("Size: " + stack.size());
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.print("\nDELETE: ");

        while (!stack.isEmpty()) stack.pop();
        System.out.println("\nisEmpty: " + stack.isEmpty());
        System.out.print("\nNewStack: ");
        Arrays.stream(numbers).forEach(number -> {
            stack.push(number);
            System.out.print(number + " ");
        });

        System.out.println("\nSize: " + stack.size());
        System.out.println("SizeArray: " + stack.stack.length);
        System.out.print("\nDELETE: ");
        while (!stack.isEmpty()) stack.pop();
        System.out.println("\nisEmpty: " + stack.isEmpty());
        stack.pop();
    }
}