package com.vc.collections.map;
import com.vc.collections.list.List;
import com.vc.collections.set.Set;

public interface Map<K, T> {

    void put(K key, T value);

     T get(K key);

     Set<K> keySet();

     List<T> values();

     boolean remove(K key);

     int size();

     void clear();
}
