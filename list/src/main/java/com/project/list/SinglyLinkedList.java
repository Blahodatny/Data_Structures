package com.project.list;

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

    static class Item<E> {
        E item;

        Item(E item) {
            this.item = item;
        }
    }

    private static class Node<E> extends Item<E> {
        private Node<E> next;

        private Node(E element, Node<E> next) {
            super(element);
            this.next = next;
        }
    }
}