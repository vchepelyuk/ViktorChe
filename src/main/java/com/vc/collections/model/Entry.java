package com.vc.collections.model;

public class Entry {
    private Car value;
    private Entry next;

    public Entry() {
    }

    public Entry(Car value, Entry next) {
        this.value = value;
        this.next = next;
    }

    public Car getValue() {
        return value;
    }

    public void setValue(Car value) {
        this.value = value;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }
}
