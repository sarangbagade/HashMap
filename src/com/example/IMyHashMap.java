package com.example;

public interface IMyHashMap<K, V> {

    V get(K key);
    void put(K key, V value);// this will create new pair if key is absent or updates value
    void remove(K key);
    int size();
}
