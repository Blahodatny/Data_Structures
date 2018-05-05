import list.ArrayList;
import stack.LinkedStack;

import java.util.Random;

class Main {
    final private static int QUANTITY = 10;

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        final Random random = new Random();
        for (int i = 0; i < QUANTITY; i++) {
//			int k = random.nextInt(200);
//			if (k % 2 != 0 && k > 50) {
//				list.add(Integer.toString(k));
//			}
            list.add(Integer.toString(random.nextInt(200)));
        }
        System.out.print("The list is: ");
        list.printElements();

        LinkedStack stack = new LinkedStack();
        for (int i = 0; i < list.size(); i++)
            if (Integer.parseInt(list.get(i)) > 50 && Integer.parseInt(list.get(i)) % 2 != 0)
                stack.push(Integer.parseInt(list.remove(i--)));

        System.out.print("\nAfter deleting all odd elements > 50:\n\nArrayList: ");
        list.printElements();
        System.out.print("\nLinkedStack: ");
        stack.print();
    }
}