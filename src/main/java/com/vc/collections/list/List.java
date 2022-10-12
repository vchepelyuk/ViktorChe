package com.vc.collections.list;

import com.vc.collections.Collections;

public interface List<T> extends Collections<T> {
    T get(int index);

    boolean add(T element);

    boolean add(T element, int index);

    boolean remove(T element);

    boolean removeAt(int index);

    int size();

    void clear();
}
