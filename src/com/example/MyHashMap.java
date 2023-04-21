package com.example;

public class MyHashMap<K, V> implements IMyHashMap<K, V> {
    
    static class Entry<K, V>
    {
        private K key;
        private V value;
        Entry<K, V> next;

        public Entry() {
        }
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }


    }
    private Entry[] table;
    private int size;
    
    MyHashMap()
    {
        this.table = new Entry[16];
    }
    MyHashMap(int capacity, float loadFactor)
    {
        this.table = new Entry[tableSizeFor(capacity)];
    }

    private int tableSizeFor(int cap)
    {
        int n = cap-1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n+1;
    }

    public V get(K key) {

        int hash = hash(key);
        Entry<K, V> entry = table[hash];
        while(entry != null)
        {
            if(entry.getKey().equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    // if key is null, hash value returned it 0. so null key is kept at 0th position in table array.
    // in this case hashCode function is never called avoiding null pointer exception
    private int hash(K key)
    {
        int h = (key==null) ? 0 : (h=key.hashCode()) ^ (h >>> 16);// this hashCode is between 0 and ar.size()-1
        return h & (table.length-1);
    }

    public void put(K key, V value) {

        int hash = hash(key);
        Entry<K, V> entry = table[hash];
        if(entry == null) {
            table[hash] = new Entry(key, value);
        } else {
            Entry<K, V> previousEntry = entry;
            while(entry != null) {
                if(entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }
                previousEntry = entry;
                entry = entry.next;
            }
            Entry<K, V> newEntry = new Entry<>(key, value);
            previousEntry.next = newEntry;
        }
    }

    public void remove(K key) {

        int hash = hash(key);
        Entry<K, V> entry = table[hash];
        if(entry.key.equals(key)) {
            table[hash] = entry.next;
            return;
        }
        Entry<K, V> startEntry = new Entry<>();
        startEntry.next = entry;
        Entry<K, V> pEntry = startEntry;
        while(entry != null)
        {
            if(entry.getKey().equals(key)) {
                pEntry.next = entry.next;
                break;
            }
            pEntry = entry;
            entry = entry.next;
        }
    }

    public int size()
    {
        return this.size;
    }
}
