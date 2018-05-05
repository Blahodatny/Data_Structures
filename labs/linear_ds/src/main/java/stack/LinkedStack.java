package stack;

import interfaces.Stack;

import java.util.Arrays;

public class LinkedStack implements Stack {
    private SLNode top;

    public boolean isEmpty() {
        return this.top == null;
    }

    public int pop() {
        if (this.isEmpty()) throw new NullPointerException("Error in method this.pop().");
        int item = top.data;
        top = top.next;
        return item;
    }

    public void push(int item) {
        this.top = new SLNode(item, top);
    }

    public int top() {
        if (this.isEmpty()) throw new NullPointerException("Error in method this.top().");
        return top.data;
    }

    public int size() {
        int size = 0;
        SLNode cur = this.top;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }

    public void print() {
        SLNode cur = this.top;
        String[] str = new String[this.size()];
        int i = 0;
        while (cur != null) {
            str[i] = Integer.toString(cur.data);
            cur = cur.next;
            i++;
        }
        System.out.println(Arrays.toString(str));
    }
}