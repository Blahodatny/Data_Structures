package interfaces;

import rectangle.Rectangle;

public interface FigureSet {
    boolean add(Rectangle rectangle);

    boolean contains(Rectangle rectangle);

    boolean isEmpty();

    boolean remove(Rectangle rectangle);

    void print();

    int size();
}