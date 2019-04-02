package com.project.list.doubly;

import com.project.list.Node;

class DNode<E> extends Node<E> {
    private DNode<E> prev;

    DNode(DNode<E> prev, E item, DNode<E> next) {
        this.prev = prev;
        setItem(item);
        setNext(next);
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = (DNode<E>) prev;
    }
}