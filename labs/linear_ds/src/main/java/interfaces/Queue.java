package interfaces;

public interface Queue {
    boolean enqueue(int e);

    int dequeue();

    int head();

    int size();

    boolean isEmpty();
}