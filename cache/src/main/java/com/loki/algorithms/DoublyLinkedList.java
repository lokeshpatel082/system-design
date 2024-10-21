package com.loki.algorithms;

public class DoublyLinkedList<E> {
    DoublyLinkedListNode<E> dummyHead;
    DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList(){
        this.dummyHead = new DoublyLinkedListNode<>(null);
        this.dummyTail = new DoublyLinkedListNode<>(null);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void addNodeAtFirst(DoublyLinkedListNode<E> node){
        DoublyLinkedListNode headNext = this.dummyHead.next;
        node.next = headNext;
        headNext.prev = node;
        node.prev = this.dummyHead;
        this.dummyHead.next = node;
    }

    public DoublyLinkedListNode<E> addElementAtFirst(E element){
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addNodeAtFirst(newNode);
        return newNode;
    }
    public void detachNode(DoublyLinkedListNode<E> node){
        if(node == null) return ;
        DoublyLinkedListNode nodePrev = node.prev;
        DoublyLinkedListNode nodeNext = node.next;

        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
    }
    public boolean isEmpty(){
        return this.dummyHead.next == this.dummyTail;
    }

    public DoublyLinkedListNode getFirstNode(){
        if(isEmpty()){
            return null;
        }
        return this.dummyHead.next;
    }

    public DoublyLinkedListNode getLastNode(){
        if(isEmpty()){
            return null;
        }
        return this.dummyTail.prev;
    }


}
