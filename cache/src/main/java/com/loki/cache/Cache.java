package com.loki.cache;

import com.loki.cache.exceptions.NotFoundException;
import com.loki.cache.exceptions.StorageFullException;
import com.loki.cache.policies.EvictionPolicy;
import com.loki.cache.storage.Storage;

public class Cache<K,V> {
    private EvictionPolicy<K> evictionPolicy;
    private Storage<K,V> storage;

    public Cache(EvictionPolicy evictionPolicy, Storage storage){
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(K key, V val){
        try{
            storage.add(key,val);
            evictionPolicy.keyAccessed(key);
        }
        catch (StorageFullException e){
            System.out.println("Storage Capacity Full, will try to evict key..");
            K keyToRemove = evictionPolicy.evictKey();
            storage.remove(keyToRemove);
            System.out.println("Creating space by evicting item..." + keyToRemove);
            put(key,val);
        }
    }

    public V get(K key){
        try {
            V val = storage.get(key);
            evictionPolicy.keyAccessed(key);
            return val;
        } catch (NotFoundException e) {
            System.out.println("tried to access non existing key !");
            return null;
        }
    }
}
