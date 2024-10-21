package com.loki.algorithms;

import lombok.Getter;

@Getter
public class DoublyLinkedListNode<E> {
    E element;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(E element){
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
