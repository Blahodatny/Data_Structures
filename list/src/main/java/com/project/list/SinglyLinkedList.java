package com.project.list;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SinglyLinkedList<E> {
    private Node<E> head;

    public SinglyLinkedList(E head) {
        this.head = new Node<>(head, null);
    }

    public void addFirst(E node) {
        head = new Node<>(node, head);
    }

    public void add(E node) {

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
        private E item;
        private Node<E> next;

        private Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            var node = (Node<?>) o;
            return Objects.equals(item, node.item) &&
                    Objects.equals(next, node.next);
        }

        public int hashCode() {
            return Objects.hash(item, next);
        }
    }
}