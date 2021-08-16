package ru.avd.core;


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

    public abstract void fillBoard(List<V> list);
    public abstract List<K> availableSpace();
    public abstract void addItem(K k, V v);
    public abstract K getKey(int i, int j);
    public abstract V getValue(K k);
    public abstract List<K> getColumn(int j);
    public abstract List<K> getRow(int i);
    public abstract boolean hasValue(V v);
    public abstract List<V> getValues(List<K> keys);
}
