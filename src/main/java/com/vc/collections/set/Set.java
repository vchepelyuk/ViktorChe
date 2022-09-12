package com.vc.collections.set;

import com.vc.collections.model.Car;

public interface Set {
    boolean add(Car car);

    boolean remove(Car car);

    int size();

    void clear();
}
