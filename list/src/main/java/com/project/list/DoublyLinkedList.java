package com.project.list;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        if (head == null)
            return;
        if (head.equals(node))
            head = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        if (node.prev != null)
            node.prev.next = node.next;
    }

    public int size() {
        var cur = head;
        var count = 0;

        while (cur != null) {
            cur = cur.next;
            count++;
        }

        return count;
    }

    public String toString() {
        return Stream
                .iterate(head, Objects::nonNull, cur -> cur.next)
                .map(cur -> cur.item + " ")
                .collect(Collectors.joining("", "List: [ ", "]"));
    }

    private static class Node<E> {
        private Node<E> prev;
        private E item;
        private Node<E> next;

        private Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            var node = (Node<?>) o;
            return Objects.equals(prev, node.prev) &&
                    Objects.equals(item, node.item) &&
                    Objects.equals(next, node.next);
        }

        public int hashCode() {
            return Objects.hash(prev, item, next);
        }
    }
}