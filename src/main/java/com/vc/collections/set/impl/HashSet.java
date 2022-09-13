package com.vc.collections.set.impl;

import com.vc.collections.model.Car;
import com.vc.collections.model.Entry;
import com.vc.collections.set.Set;

public class HashSet implements Set {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPACITY];

    @Override
    public boolean add(Car car) {
        if (size >= (array.length * LOAD_FACTOR)) {
            increaseArray();
        }
        boolean added = add(car, array);
        if (added) {
            size++;
        }
        return added;
    }

    public boolean add(Car car, Entry[] dst) {
        int position = getElementPosition(car, dst.length);
        if (dst[position] == null) {
            Entry entry = new Entry(car, null);
            dst[position] = entry;
            return true;
        } else {
            Entry existedElement = dst[position];
            while (true) {
                if (existedElement.getValue().equals(car)) {
                    return false;
                } else if (existedElement.getNext() == null) {
                    existedElement.setNext(new Entry(car, null));
                    return true;
                } else {
                    existedElement = existedElement.getNext();
                }
            }
        }
    }



    @Override
    public boolean remove(Car car) {
        int position = getElementPosition(car, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.getNext();
        if (secondLast.getValue().equals(car)) {
            array[position] = last;
            size--;
            return true;
        } while (last != null) {
            if (last.getValue().equals(car)) {
                secondLast.setNext(last.getNext());
                size--;
                return true;
            } else {
                secondLast = last;
                last = last.getNext();
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    private int getElementPosition(Car car, int arrayLength) {
        return Math.abs(car.hashCode() % arrayLength);
    }

    private void increaseArray() {
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry entry : array) {
            Entry existedElement = entry;
            while (existedElement != null) {
                add(existedElement.getValue(), newArray);
                existedElement = existedElement.getNext();
            }
        }
    }
}


