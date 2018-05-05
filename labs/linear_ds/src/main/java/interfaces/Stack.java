package interfaces;

public interface Stack {
    boolean isEmpty();

    int pop();

    void push(int item);

    int top();

    int size();
}