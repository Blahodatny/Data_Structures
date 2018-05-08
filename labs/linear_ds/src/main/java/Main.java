import list.ArrayList;
import stack.LinkedStack;

import java.util.Random;
import java.util.stream.IntStream;

class Main {
    final private static int QUANTITY = 10;

    public static void main(String[] args) {
        var list = new ArrayList();
        final var random = new Random();
        IntStream.range(0, QUANTITY).mapToObj(i -> Integer.toString(random.nextInt(200))).forEach(list::add);
        System.out.print("The list is: ");
        list.printElements();

        var stack = new LinkedStack();
        for (var i = 0; i < list.size(); i++)
            if (Integer.parseInt(list.get(i)) > 50 && Integer.parseInt(list.get(i)) % 2 != 0)
                stack.push(Integer.parseInt(list.remove(i--)));

        System.out.print("\nAfter deleting all odd elements > 50:\n\nArrayList: ");
        list.printElements();
        System.out.print("\nLinkedStack: ");
        stack.print();
    }
}