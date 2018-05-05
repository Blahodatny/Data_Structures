package interfaces;

public interface Deque {
    boolean addFirst(int e);

    boolean addLast(int e);

    int removeFirst();

    int removeLast();

    int getFirst();

    int getLast();

    int size();

    boolean isEmpty();
}