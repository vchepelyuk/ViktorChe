package com.vc.collections.set.impl;
import com.vc.collections.model.Entry;
import com.vc.collections.set.Set;

public class HashSet<T> implements Set<T> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private Entry<T>[] array = new Entry[INITIAL_CAPACITY];

    @Override
    public boolean add(T element) {
        if (size >= (array.length * LOAD_FACTOR)) {
            increaseArray();
        }
        boolean added = add(element, array);
        if (added) {
            size++;
        }
        return added;
    }

    public boolean add(T element, Entry[] dst) {
        int position = getElementPosition(element, dst.length);
        if (dst[position] == null) {
            Entry entry = new Entry(element, null);
            dst[position] = entry;
            return true;
        } else {
            Entry existedElement = dst[position];
            while (true) {
                if (existedElement.getValue().equals(element)) {
                    return false;
                } else if (existedElement.getNext() == null) {
                    existedElement.setNext(new Entry(element, null));
                    return true;
                } else {
                    existedElement = existedElement.getNext();
                }
            }
        }
    }

    @Override
    public boolean remove(T element) {
        int position = getElementPosition(element, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.getNext();
        if (secondLast.getValue().equals(element)) {
            array[position] = last;
            size--;
            return true;
        } while (last != null) {
            if (last.getValue().equals(element)) {
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
    public boolean contains(T element) {
        int position = getElementPosition(element, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.getNext();
        if (secondLast.getValue().equals(element)) {
            return true;
        } while (last != null) {
            if (last.getValue().equals(element)) {
                return true;
            } else {
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

    private int getElementPosition(T element, int arrayLength) {
        return Math.abs(element.hashCode() % arrayLength);
    }

    private void increaseArray() {
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry entry : array) {
            Entry existedElement = entry;
            while (existedElement != null) {
                add((T) existedElement.getValue(), newArray);
                existedElement = existedElement.getNext();
            }
        }
    }
}


