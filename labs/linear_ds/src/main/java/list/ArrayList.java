package list;

import interfaces.List;

import java.util.Arrays;

public class ArrayList implements List {
    private String[] list;
    private static final int defaultCapacity = 10;
    private int capacity;
    private int size;

    private static boolean isInValid(String e) {
        if (e == null) return true;
        try {
            if (Integer.parseInt(e) <= 0) return true;
        } catch (NumberFormatException exception) {
            return true;
        }
        return false;
    }

    public ArrayList() {
        this.capacity = defaultCapacity;
        this.size = 0;
        this.list = new String[this.capacity];
    }

    public boolean add(String element) {
        if (isInValid(element)) return false;
        if (this.size == this.capacity) {
            this.capacity += 16;
            list = Arrays.copyOf(list, this.capacity);
        }
        this.list[this.size] = element;
        this.size++;
        return true;
    }

    public boolean add(int index, String e) {
        if (isInValid(e) || index < 0 || index >= this.size) return false;
        if (this.size == this.capacity) {
            this.capacity += 16;
            list = Arrays.copyOf(list, this.capacity);
        }

        System.arraycopy(this.list, index, this.list, index + 1, this.size - index);
        this.list[index] = e;
        this.size++;
        return true;
    }

    public String remove(int index) {
        if (index < 0 || index >= this.size) return null;
        String removed = this.list[index];
        System.arraycopy(this.list, index + 1, this.list, index, this.size - 1 - index);
        this.list[this.size - 1] = null;
        this.size--;
        return removed;
    }

    public boolean remove(String element) {
        if (isInValid(element)) return false;
        int i = 0;
        while (i < this.size) {
            if (this.list[i].equals(element)) {
                System.arraycopy(this.list, i + 1, this.list, i, this.size - 1 - i);
                this.list[this.size - 1] = null;
                this.size--;
                return true;
            }
            i++;
        }
        return false;
    }

    public String get(int index) {
        if (index < 0 || index >= this.size) return null;
        return this.list[index];
    }

    public String set(int index, String element) {
        if (isInValid(element) || index < 0 || index >= this.size) return null;
        String set = this.list[index];
        this.list[index] = element;
        return set;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void print() {
        System.out.println(Arrays.toString(this.list));
    }

    public void printElements() {
        System.out.println(Arrays.toString(Arrays.copyOf(this.list, this.size)));
    }
}