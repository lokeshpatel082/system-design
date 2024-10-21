package com.loki.cache.policies;

import com.loki.algorithms.DoublyLinkedList;
import com.loki.algorithms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K>{
    private DoublyLinkedList<K> dll;
    private Map<K, DoublyLinkedListNode<K>> mapper;

    public LRUEvictionPolicy(){
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(K key) {
        if(mapper.containsKey(key)){
            dll.detachNode(mapper.get(key));
            dll.addNodeAtFirst(mapper.get(key));
        }
        else{
            DoublyLinkedListNode newNode = dll.addElementAtFirst(key);
            mapper.put(key, newNode);
        }
    }

    @Override
    public K evictKey() {
        if(dll.isEmpty()){
            return null;
        }
        DoublyLinkedListNode<K> lastNode = dll.getLastNode();
        dll.detachNode(lastNode);

        return lastNode.getElement();
    }
}
