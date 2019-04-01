package com.project.list;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class List<E> {
    protected Node<E> head;

    public abstract Node<E> createNode(Node<E> prev, E item, Node<E> next);

    public abstract void addFirst(E item);

    public void add(E item) {
        if (head == null)
            addFirst(item);

        var cur = head;
        while (cur.getNext() != null)
            cur = cur.getNext();

        cur.setNext(createNode(cur, item, null));
    }

    public int size() {
        return (int) Stream.iterate(head, Objects::nonNull, Node::getNext).count();
    }

    public String toString() {
        return Stream
                .iterate(head, Objects::nonNull, Node::getNext)
                .map(cur -> cur.getItem() + " ")
                .collect(Collectors.joining("", "List: [ ", "]"));
    }
}