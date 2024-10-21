package com.loki.cache.policies;

public interface EvictionPolicy<K> {
    public void keyAccessed(K key);
    public K evictKey();
}
