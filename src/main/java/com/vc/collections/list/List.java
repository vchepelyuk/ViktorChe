package com.vc.collections.list;

public interface List<T> {
    T get(int index);

    void add(T element);

    void add(T element, int index);

    boolean remove(T element);

    boolean removeAt(int index);

    int size();

    void clear();
}
