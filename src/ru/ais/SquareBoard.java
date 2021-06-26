package ru.ais;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SquareBoard<V> extends Board<Key,V> {
    public SquareBoard(int size) {
        super(size, size);
    }

    @Override
    void fillBoard(List<V> list) {
        Iterator<V> itr = list.iterator();
        do {
            for (int i = 0; i < weigh; i++) {
                for (int j = 0; j < height; j++) {
                    board.put(new Key(i, j), itr.next());
                }
            }
        } while (itr.hasNext());
    }




    @Override
    List<Key> availableSpace() {
        List<Key> keyList = new ArrayList<>();
        for (Key key : board.keySet()) {
            if (board.get(key) == null) {
                keyList.add(key);
            }
        }
        return keyList;
    }

    @Override
    void addItem(Key key, V v) {
    board.put(key, v);
    }

    @Override
    Key getKey(int i, int j) {
        for (Key key: board.keySet()
             ) {
            if (key.getI() == i && key.getJ() == j) {
                return key;
            }
        }
        return null;
    }

    @Override
    V getValue(Key key) {

        return board.get(key);
    }

    @Override
    List<Key> getColumn(int j) {
        List<Key> listOfColumns = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            listOfColumns.add(getKey(i,j));
          }
        return listOfColumns;
        }

    @Override
    List<Key> getRow(int i) {
        List<Key> listOfRows = new ArrayList<>();
        for (int j = 0; j < weigh; j++) {
            listOfRows.add(getKey(i,j));
        }
        return listOfRows;
    }

    @Override
    boolean hasValue(V v) {
        return board.containsValue(v);
    }

    @Override
    List<V> getValues(List<Key> keys) {
        List<V> listOfValues = new ArrayList<>();
        for (Key key: keys
             ) {
            listOfValues.add((board.get(key)));
        }
        return listOfValues;
    }
}
