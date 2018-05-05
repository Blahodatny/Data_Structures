package deque;

import interfaces.Deque;

public class ArrayDeque implements Deque {
    private int[] queue;
    private int capacity;
    private int head;
    private int tail;
    private static final int defaultCapacity = 8;

    public ArrayDeque() {
        queue = new int[defaultCapacity];
        capacity = defaultCapacity;
        head = tail = 0;
    }

    public boolean addFirst(int e) {
        this.tail++;
        if (size() == this.capacity - 1)
            this.capacity *= 2;

        int[] B = new int[this.capacity];
        System.arraycopy(this.queue, 0, B, 0, size() - 1);
        this.queue = B;

        System.arraycopy(this.queue, this.head, this.queue, this.head + 1, size() + 1 - this.head);
        this.queue[this.head] = e;
        this.head = this.head % this.capacity;
        return true;
    }

    public boolean addLast(int e) {
        if (size() == capacity - 1) {
            capacity *= 2;
            queue[tail++] = e;
        } else
            queue[tail] = e;
        tail++;
        return true;
    }

    public int removeFirst() {
        if (size() == 0)
            try {
                throw new Exception("Deque is empty.");
            } catch (Exception e) {
                e.printStackTrace();
            }

        if (capacity >= 8 && size() < capacity / 4)
            capacity /= 2;
        int[] B = new int[capacity];
        System.arraycopy(queue, 1, B, 0, size() - 1);
        queue = B;
        return queue[head];
    }

    public int removeLast() {
        if (size() == 0) {
            try {
                throw new Exception("Deque is empty.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (capacity >= 8 && size() < capacity / 4)
            capacity /= 2;
        int[] B = new int[capacity];
        System.arraycopy(queue, head, B, head, size() - 1 - head);
        queue = B;
        tail--;
        return queue[tail];
    }

    public int getFirst() {
        if (isEmpty())
            try {
                throw new Exception("Deque is empty.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return queue[head % capacity];
    }

    public int getLast() {
        if (isEmpty())
            try {
                throw new Exception("Deque is empty.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return queue[(head + tail - 1) % capacity];
    }

    public int size() {
        return tail - head;
    }

    public boolean isEmpty() {
        return tail == head;
    }
}