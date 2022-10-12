package com.vc.collections.model;

public class Entry<T> {
    private T value;
    private Entry<T> next;

    public Entry() {
    }

    public Entry(T value, Entry<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Entry<T> getNext() {
        return next;
    }

    public void setNext(Entry<T> next) {
        this.next = next;
    }
}
