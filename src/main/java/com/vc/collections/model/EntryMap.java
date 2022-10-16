package com.vc.collections.model;

public class EntryMap<K, T> {
    private K key;
    private T value;
    private EntryMap next;

    public EntryMap() {
    }

    public EntryMap(K key, T value, EntryMap next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public EntryMap getNext() {
        return next;
    }

    public void setNext(EntryMap next) {
        this.next = next;
    }
}
