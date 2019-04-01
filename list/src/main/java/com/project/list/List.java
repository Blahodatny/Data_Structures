package com.project.list;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class List<E> {
    Node<E> head;

    public int size() {
        return (int) Stream.iterate(head, Objects::nonNull, cur -> cur.next).count();
    }

    public String toString() {
        return Stream
                .iterate(head, Objects::nonNull, cur -> cur.next)
                .map(cur -> cur.item + " ")
                .collect(Collectors.joining("", "List: [ ", "]"));
    }

    static class Item<E> {
        E item;

        Item(E item) {
            this.item = item;
        }
    }

    static class Node<E> extends Item<E> {
        Node<E> next;

        Node(E item, Node<E> next) {
            super(item);
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