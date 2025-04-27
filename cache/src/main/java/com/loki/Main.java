package com.loki;

import com.loki.algorithms.DoublyLinkedList;
import com.loki.cache.Cache;
import com.loki.cache.policies.EvictionPolicy;
import com.loki.cache.policies.LRUEvictionPolicy;
import com.loki.cache.storage.HashMapBasedStorage;
import com.loki.cache.storage.Storage;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to the Loki's Cache !!");

        EvictionPolicy<Integer> lruEvictionPolicy = new LRUEvictionPolicy<>();
        Storage<Integer, Integer> lruStorage = new HashMapBasedStorage<>(2);
        Cache<Integer, Integer> cache = new Cache<>(lruEvictionPolicy, lruStorage);

        cache.put(2,100);
        cache.put(1,600);
        System.out.println(cache.get(2));
        cache.put(4,90);

    }
}