package com.project.list.doubly;

import com.project.list.List;
import com.project.list.Node;

public class DoublyLinkedList<E> extends List<E> {
    public DoublyLinkedList() {
    }

    public Node<E> createNode(Node<E> prev, E item, Node<E> next) {
        return new DNode<>((DNode<E>) prev, item, (DNode<E>) next);
    }

    public void addFirst(E item) {
        head = new DNode<>(null, item, (DNode<E>) head);
        if (head.getNext() != null)
            head.getNext().setPrev(head);
    }

    private void delete(DNode<E> node) {
        if (head == null)
            return;
        if (head.equals(node))
            head = node.getNext();
        if (node.getNext() != null)
            node.getNext().setPrev(node.getPrev());
        if (node.getPrev() != null)
            node.getPrev().setNext(node.getNext());
    }

    public void delete(int position) {
        var i = 0;
        for (var cur = head; cur != null; cur = cur.getNext())
            if (i++ == position)
                delete((DNode<E>) cur);
    }
}