package com.loki.cache.storage;

import com.loki.cache.exceptions.NotFoundException;
import com.loki.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<K, V> implements Storage<K,V>{

    private Map<K,V> storage;
    private int capacity;

    public HashMapBasedStorage(int capacity){
        this.capacity = capacity;
        this.storage = new HashMap<>();
    }
    @Override
    public void add(K key, V value) throws StorageFullException {
        if(isFull()){
            throw new StorageFullException("Capacity full...");
        }
        storage.put(key, value);
    }

    @Override
    public void remove(K key) throws NotFoundException {
        if(!storage.containsKey(key)){
            throw new NotFoundException(key + "doesn't exist in the cache!!");
        }
        storage.remove(key);
    }

    @Override
    public V get(K key) throws NotFoundException{
       if(!storage.containsKey(key)){
           throw new NotFoundException(key + "doesn't exist in the cache!!");
       }
       return storage.get(key);
    }

    private boolean isFull(){
        return this.storage.size() >= capacity;
    }
}
