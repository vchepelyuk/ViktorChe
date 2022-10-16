package com.vc.collections.list;

import com.vc.collections.Collections;
import com.vc.collections.model.Car;

public interface Queue<T> extends Collections<T> {
    boolean add(T element);

    T peek();

    T poll();
}
