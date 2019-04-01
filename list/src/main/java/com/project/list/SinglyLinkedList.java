package com.project.list;

import com.project.list.singlyLinkedList.Node;

public class SinglyLinkedList<E> {
    private Node<E> head;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(E head) {
        this.head = new Node<>(head, null);
    }

    public void addFirst(E node) {
        head = new Node<>(node, head);
    }
}