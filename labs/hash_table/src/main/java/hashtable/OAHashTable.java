package hashtable;

import interfaces.FigureSet;
import rectangle.Rectangle;

import java.awt.geom.Point2D;
import java.util.stream.IntStream;

public class OAHashTable implements FigureSet {

    private Rectangle[] table;
    private int size;
    private static final int initialCapacity = 11;
    private double loadFactor = 0.75;
    private final static DelRectangle DELL = DelRectangle.getInstance();

    public OAHashTable() {
        this.table = new Rectangle[initialCapacity];
        this.size = 0;
    }

    public OAHashTable(int capacity) {
        if (capacity < 0) capacity = 1;
        this.table = new Rectangle[capacity];
        this.size = 0;
    }

    public OAHashTable(int capacity, double loadFac) {
        if (capacity < 0) capacity = 1;
        if (loadFac <= 0.0 || loadFac > 1.0) loadFac = 1;
        this.table = new Rectangle[capacity];
        this.loadFactor = loadFac;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    private int hash(Rectangle rectangle) {
        return Math.abs(rectangle.hashCode() % table.length);
    }

    public boolean add(Rectangle rectangle) {
        if (rectangle != null && !contains(rectangle)) {

            var hash = hash(rectangle);
            var hashCode = Math.abs(rectangle.hashCode() / 7);

            for (var i = 0; i != table.length; i++) {
                var index = (hash + i * hashCode) % table.length;
                if (table[index] == DELL || table[index] == null) {
                    this.table[index] = rectangle;
                    this.size++;
                    if (((size + 1) / (double) table.length) >= loadFactor) new HashTable().rehash();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean contains(Rectangle rectangle) {
        if (rectangle == null) return false;

        var hash = hash(rectangle);
        var hashCode = Math.abs(rectangle.hashCode() / 7);
        var index = hash;

        for (var i = 0; table[index] != null && i != table.length; i++) {
            index = (hash + i * hashCode) % table.length;
            if (rectangle.equals(table[index]))
                return true;
        }
        return false;
    }

    public boolean remove(Rectangle rectangle) {
        if (rectangle == null || !contains(rectangle)) return false;

        var hash = hash(rectangle);
        var hashCode = Math.abs(rectangle.hashCode() / 7);
        var index = hash;

        for (var i = 0; i != table.length && table[index] != null; i++) {
            index = (hash + i * hashCode) % table.length;
            if (table[index].equals(rectangle)) {
                this.table[index] = DELL;
                --this.size;
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.size == 0;
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

class DelRectangle extends Rectangle {
    private static DelRectangle delRectangle = null;

    private DelRectangle() {
        super(new Point2D.Double(0.0, 0.0),
                new Point2D.Double(-0.0001, -0.0001));
    }

    static DelRectangle getInstance() {
        if (delRectangle == null) delRectangle = new DelRectangle();
        return delRectangle;
    }

    public String toString() {
        return "deleted element";
    }
}