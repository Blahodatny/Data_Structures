package com.project.list.doubly;

import com.project.list.Node;

import java.util.Objects;

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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DNode)) return false;
        if (!super.equals(o)) return false;
        var dNode = (DNode<?>) o;
        return Objects.equals(prev, dNode.prev);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), prev);
    }
}