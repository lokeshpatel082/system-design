package com.loki.cache.storage;

public interface Storage <K,V>{
    public void add(K key, V value);
    public void remove(K key);
    public V get(K key);
}
