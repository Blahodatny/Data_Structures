package queue;

import java.util.stream.IntStream;

class LinkedQueue {
    private SLNode head;
    private SLNode tail;
    private int size;

    private LinkedQueue() {
        head = tail = null;
        size = 0;
    }

    private boolean enqueue(String item) {
        if (!isCorrectData(item)) return false;
        var newNode = new SLNode(item);
        if (isEmpty())
            head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    private boolean isCorrectData(String item) {
        return !item.equals("") && IntStream.range(0, item.length()).noneMatch(i -> "01234567".indexOf(item.charAt(i)) == -1);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void dequeue() {
        if (isEmpty()) {
            System.err.println("Unable to delete element(QUEUE IS EMPTY)");
            return;
        }
        head = head.next;
        if (head == null) tail = null;
        size--;
    }

    private String head() {
        if (isEmpty()) {
            System.err.println("Unable to get element(QUEUE IS EMPTY)");
            return null;
        }
        return head.data;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        var queue = new LinkedQueue();
        String[] numbers = {"8", "17", "-32", "360", "77", "7.7", "100", "24", ""};
        System.out.println("Queue: ");
        System.out.println("Head: " + queue.head());
        System.out.println("Size: " + queue.size());
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.print("\nQueue: ");
        for (var number : numbers)
            if (queue.enqueue(number))
                System.out.print(number + " ");
        System.out.println("\nHead: " + queue.head());
        System.out.println("Size: " + queue.size());
        System.out.println("isEmpty: " + queue.isEmpty());
        while (!queue.isEmpty()) queue.dequeue();
        System.out.println("\nDELETE:");
        System.out.println("isEmpty: " + queue.isEmpty());
        queue.dequeue();
    }
}