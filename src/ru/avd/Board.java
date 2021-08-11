package ru.avd;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class Board<K,V> {
     int weigh;
     int height;
     Map<K, V> board = new HashMap<>();

    public Board(int weigh, int height) {
        this.weigh = weigh;
        this.height = height;
    }

    abstract void fillBoard(List<V> list);
    abstract List<K> availableSpace();
    abstract void addItem(K k, V v);
    abstract K getKey(int i, int j);
    abstract V getValue(K k);
    abstract List<K> getColumn(int j);
    abstract List<K> getRow(int i);
    abstract boolean hasValue(V v);
    abstract List<V> getValues(List<K> keys);
}
