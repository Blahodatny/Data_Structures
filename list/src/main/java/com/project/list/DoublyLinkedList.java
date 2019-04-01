package com.project.list;

public class DoublyLinkedList<E> extends List<E> {
    private DNode<E> head;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(DNode<E> head) {
        this.head = head;
    }

    public void addFirst(E item) {
        head = new DNode<E>(null, item, head);
        if (head.next != null)
            head.next.prev = head;
    }

    public void add(E item) {
        if (head == null)
            addFirst(item);

        var cur = head;
        while (cur.next != null)
            cur = cur.next;

        cur.next = new DNode<E>(cur, item, null);
    }

    public void delete(DNode<E> node) {
        if (head == null)
            return;
        if (head.equals(node))
            head = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        if (node.prev != null)
            node.prev.next = node.next;
    }

    private static class DNode<E> extends Item<E> {
        private DNode<E> prev;
        private DNode<E> next;

        private DNode(DNode<E> prev, E item, DNode<E> next) {
            super(item);
            this.next = next;
            this.prev = prev;
        }
    }
}