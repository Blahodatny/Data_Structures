package hashtable;

import interfaces.FigureSet;
import rectangle.Rectangle;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class HashTable implements FigureSet {

    private Rectangle[] table;
    private static final int initialCapacity = 11;
    private int size;
    private double loadFactor = 0.75;

    public HashTable() {
        this.table = new Rectangle[initialCapacity];
        this.size = 0;
    }

    public HashTable(int capacity) {
        if (capacity < 0) capacity = 1;
        this.table = new Rectangle[capacity];
        this.size = 0;
    }

    public HashTable(int capacity, double loadFactor) {
        if (capacity < 0) capacity = 1;
        if (loadFactor <= 0.0 || loadFactor > 1.0) loadFactor = 1;
        this.table = new Rectangle[capacity];
        this.loadFactor = loadFactor;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    private int hash(Rectangle rectangle) {
        return Math.abs(rectangle.hashCode() % table.length);
    }

    void rehash() {
        var rectangle = table;
        var newSize = table.length + 16;
        this.table = new Rectangle[newSize];
        this.size = 0;
        Arrays.stream(rectangle).filter(Objects::nonNull).forEach(this::add);
    }

    public boolean add(Rectangle rectangle) {
        if (rectangle != null) {
            var index = hash(rectangle);
            if (table[index] == null) {
                this.table[index] = rectangle;
                this.size++;
                if (((size + 1) / (double) table.length) >= loadFactor) this.rehash();
                return true;
            }
        }
        return false;
    }

    public boolean contains(Rectangle rectangle) {
        if (rectangle == null) return false;
        var index = hash(rectangle);
        return (table[index] != null && table[index].equals(rectangle));
    }

    public boolean remove(Rectangle rectangle) {
        if (rectangle == null) return false;
        if (contains(rectangle)) {
            this.table[hash(rectangle)] = null;
            --this.size;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        IntStream.range(0, table.length).forEach(i -> {
            if (table[i] != null)
                System.out.println(i + " || " + table[i].toString());
            else
                System.out.println(i + " || The slot is empty!");
        });
    }
}