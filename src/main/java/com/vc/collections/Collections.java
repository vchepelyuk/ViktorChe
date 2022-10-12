package com.vc.collections;

public interface Collections<T> {

    boolean add(T element);

    boolean remove(T element);

    boolean contains(T element);

    int size();

    void clear();
}
