package com.vc.collections.set;

import com.vc.collections.model.Car;
import com.vc.collections.set.impl.HashSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarSetTest {

    private Set carSet;

    @Before
    public void setUp() throws Exception {
        carSet = new HashSet();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAddedThreeSameElementObjThanSizeIncreaseBy1() {
        assertEquals(100, carSet.size());
        assertTrue(carSet.add(new Car("N", 10)));
        assertFalse(carSet.add(new Car("N", 10)));
        assertFalse(carSet.add(new Car("N", 10)));
        assertEquals(101, carSet.size());
    }

    @Test
    public void whenSizeClearedThenSizeMustBe0() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    public void whenElementRemovedThenSizeDecreased() {
        assertTrue(carSet.remove(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
    }
}