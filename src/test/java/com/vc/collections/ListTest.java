package com.vc.collections;

import com.vc.collections.list.List;
import com.vc.collections.list.impl.ArrayList;
import com.vc.collections.list.impl.LinkedList;
import com.vc.collections.model.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {

    private List<Car> carList;

    @Before
    public void setUp() {
        carList = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsSizeMustBe100  () {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThanSizeMustBeDecreased () {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThanSizeMustBeDecreased () {
        Car car = new Car("T", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistElementRemovedThenReturnFalse () {
        Car car = new Car("B", 12);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0 () {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrowException () {
        carList.get(100);
    }

    @Test
    public void methodGetReturnRightValue () {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle () {
        Car car = new Car("Brand", 1);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("Brand", carFromList.getBrand());
    }

    @Test
    public void insertIntoBegin () {
        Car car = new Car("R", 3);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("R", carFromList.getBrand());
    }

    @Test
    public void insertIntoEnd () {
        Car car = new Car("Brand", 1);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        assertEquals("Brand", carFromList.getBrand());
    }
}