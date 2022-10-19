package com.vc.collections.map;

import com.vc.collections.map.impl.HashMap;
import com.vc.collections.model.Car;
import com.vc.collections.model.CarOwner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {

    private Map<CarOwner, Car> map;

    @Before
    public void setUp() throws Exception {
        map = new HashMap<>();
    }

    @Test
    public void whenPut100ElementsThenSizeBecome100() {
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "lastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
        assertEquals(100, map.size());
    }

    @Test
    public void whenPut100ElementsWith10KeysThenSize10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            CarOwner carOwner = new CarOwner(index, "Name" + index, "lastName" + index);
            Car car = new Car("Brand" + index, index);
            map.put(carOwner, car);
        }
        assertEquals(10, map.size());
    }

    @Test
    public void removeReturnTrueOnlyOnce() {
        for (int i = 0; i < 10; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
        assertEquals(10, map.size());

        CarOwner elementForDeleting = new CarOwner(5, "Name5", "LastName5");
        assertTrue(map.remove(elementForDeleting));
        assertEquals(9, map.size());
        assertFalse(map.remove(elementForDeleting));
    }

    @Test
    public void countOfKeysMustBeEqualsToCountOfValues() {
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
        assertEquals(100, map.size());
        assertEquals(100, map.keySet().size());
        assertEquals(100, map.values().size());
    }


    @Test
    public void methodGetReturnRightValue() {
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "lastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
        CarOwner key = new CarOwner(50, "Name50", "lastName50");
        Car value = (Car) map.get(key);
        String expectedCarBrand = "Brand50";
        assertEquals(expectedCarBrand, value.getBrand());
    }
}