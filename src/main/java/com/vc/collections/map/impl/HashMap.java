package com.vc.collections.map.impl;

import com.vc.collections.list.List;
import com.vc.collections.list.impl.ArrayList;
import com.vc.collections.map.Map;
import com.vc.collections.model.EntryMap;
import com.vc.collections.set.Set;
import com.vc.collections.set.impl.HashSet;

public class HashMap<K, T> implements Map<K, T> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private Object[] array = new Object[INITIAL_CAPACITY];

    @Override
    public void put(K key, T value) {
        if (size >= (array.length * LOAD_FACTOR)) {
            increaseArray();
        }
       boolean put = put(key, value, array);
       if (put) {
           size++;
       }
    }

    private boolean put(K key, T value, Object[] dst) {
        int position = elementPosition(key, dst.length);
        EntryMap existedElement = (EntryMap) dst[position];
        if (existedElement == null) {
            EntryMap entryMap = new EntryMap(key, value, null);
            dst[position] = entryMap;
            return true;
        } else {
            while (true) {
                if (existedElement.getKey().equals(key)) {
                    existedElement.setValue(value);
                    return false;
                }
                if (existedElement.getNext() == null) {
                    existedElement.setNext(new EntryMap(key, value, null));
                    return true;
                }
                existedElement = existedElement.getNext();
            }
        }
    }

    @Override
    public T get(K key) {
        int position = elementPosition(key, array.length);
        EntryMap existedElement = (EntryMap) array[position];
        while (existedElement != null) {
            if (existedElement.getKey().equals(key)) {
                return (T) existedElement.getValue();
            }
            existedElement = existedElement.getNext();
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> result = new HashSet<>();
        for (Object entryMap : array) {
            EntryMap existedElement = (EntryMap) entryMap;
            while (existedElement != null) {
                result.add((K) existedElement.getKey());
                existedElement = existedElement.getNext();
            }
        }
        return null;
    }

    @Override
    public List<T> values() {
        List<T> result = new ArrayList<>();
        for (Object entryMap : array) {
            EntryMap existedElement = (EntryMap) entryMap;
            while (existedElement != null) {
                result.add((T) existedElement.getValue());
                existedElement = existedElement.getNext();
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int position = elementPosition(key, array.length);
        EntryMap existedElement = (EntryMap) array[position];
        if (existedElement != null && existedElement.getKey().equals(key)) {
            array[position] = existedElement.getNext();
            size--;
            return true;
        } else {
            while (existedElement != null) {
                EntryMap nextElement = existedElement.getNext();
                if (nextElement == null) {
                    return false;
                }
                if (nextElement.getKey().equals(key)) {
                    existedElement.setNext(nextElement.getNext());
                    size--;
                    return true;
                }
                existedElement = existedElement.getNext();
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
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    private int elementPosition(K key, int arrayLength) {
        return Math.abs(key.hashCode() % arrayLength);
    }

    private void increaseArray() {
        Object[] newArray = new Object[array.length * 2];
        for (Object entryMap : array) {
            EntryMap existedElement = (EntryMap) entryMap;
            while (existedElement != null) {
                put(existedElement.getKey(), existedElement.getValue(), newArray);
                existedElement = existedElement.getNext();
            }
        }
        array = newArray;
    }
}
