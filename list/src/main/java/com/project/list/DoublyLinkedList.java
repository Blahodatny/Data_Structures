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
        if (head.next != null)
            head.next.prev = head;
    }

    public void add(E item) {
        if (head == null)
            addFirst(item);

        var cur = head;
        while (cur.next != null)
            cur = cur.next;

        cur.next = new Node<>(cur, item, null);
    }

    public void delete(Node<E> node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private static class Node<E> extends SinglyLinkedList.Item<E> {
        private Node<E> prev;
        private Node<E> next;

        private Node(Node<E> prev, E item, Node<E> next) {
            super(item);
            this.prev = prev;
            this.next = next;
        }
    }
}