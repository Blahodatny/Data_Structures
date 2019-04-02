package com.project.list;

import java.util.Objects;

public abstract class Node<E> {
    private E item;
    private Node<E> next;

    protected Node<E> getPrev() {
        return null;
    }

    public void setPrev(Node<E> prev) {
    }

    public final E getItem() {
        return item;
    }

    protected final void setItem(E item) {
        this.item = item;
    }

    public final Node<E> getNext() {
        return next;
    }

    public final void setNext(Node<E> next) {
        this.next = next;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        var node = (Node<?>) o;
        return Objects.equals(item, node.item) &&
                Objects.equals(next, node.next);
    }

    public int hashCode() {
        return Objects.hash(item, next);
    }
}