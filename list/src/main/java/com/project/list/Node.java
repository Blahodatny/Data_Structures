package com.project.list;

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
}