package com.project.list.singly;

import com.project.list.List;
import com.project.list.Node;

public class SinglyLinkedList<E> extends List<E> {
    public SinglyLinkedList() {
    }

    public Node<E> createNode(Node<E> prev, E item, Node<E> next) {
        return new SNode<>(item, (SNode<E>) next);
    }

    public void addFirst(E item) {
        head = new SNode<>(item, (SNode<E>) head);
    }
}