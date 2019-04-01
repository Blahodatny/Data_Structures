package com.project.list;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoublyLinkedList<E> {
    private Node<E> head;

    public DoublyLinkedList(E head) {
        this.head = new Node<>(null, head, null);
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

    private void delete(Node<E> node) {
        if (head == null)
            return;
        if (head.equals(node))
            head = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        if (node.prev != null)
            node.prev.next = node.next;
    }

    public void delete(int position) {
        var i = 0;
        for (var cur = head; cur != null; cur = cur.next)
            if (i++ == position)
                delete(cur);
    }

    public int size() {
        return (int) Stream.iterate(head, Objects::nonNull, cur -> cur.next).count();
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
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DoublyLinkedList.Node)) return false;
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