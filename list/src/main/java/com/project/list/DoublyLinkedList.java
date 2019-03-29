package com.project.list;

public class DoublyLinkedList<E> {
    private Node<E> head;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(Node<E> head) {
        this.head = head;
    }

    public void addFirst(E item) {
        head = new Node<>(null, item, head);
        head.next.prev = head;
    }

    public void add(E item) {

    }

    private static class Node<E> extends SinglyLinkedList.Node<E> {
        private Node<E> prev;
        private Node<E> next;

        private Node(Node<E> prev, E element, Node<E> next) {
            super(element);
            this.prev = prev;
            this.next = next;
        }
    }
}