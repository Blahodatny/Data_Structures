package com.project.list.singly;

import com.project.list.Node;

class SNode<E> extends Node<E> {
    SNode(E item, SNode<E> node) {
        setItem(item);
        setNext(node);
    }
}