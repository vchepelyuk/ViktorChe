package com.vc.collections;

import com.vc.collections.list.impl.ArrayList;
import com.vc.collections.list.impl.LinkedList;
import com.vc.collections.model.Car;
import com.vc.collections.set.impl.HashSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollectionsTest {

    private Collections<Car> collections;

    @Before
    public void setUp() throws Exception {
        collections = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            collections.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void contains() {
        assertTrue(collections.contains(new Car("Brand20", 20)));
        assertFalse(collections.contains(new Car("Brand200", 20)));
    }
}