package com.project.list;

public class SinglyLinkedList<E> {
    private SNode<E> head;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(E head) {
        this.head = new SNode<>(head, null);
    }

    public void addFirst(E node) {
        head = new SNode<>(node, head);
    }

    static class Node<E> {
        E item;

        Node(E element) {
            this.item = element;
        }
    }

    private static class SNode<E> extends Node<E> {
        private Node<E> next;

        private SNode(E element, Node<E> next) {
            super(element);
            this.next = next;
        }
    }
}