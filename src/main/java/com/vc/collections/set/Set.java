package com.vc.collections.set;

import com.vc.collections.Collections;


public interface  Set<T> extends Collections<T> {
    boolean add(T element);

    boolean remove(T element);

    int size();

    void clear();
}
