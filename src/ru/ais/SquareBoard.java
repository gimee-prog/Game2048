package ru.ais;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SquareBoard extends Board {
    public SquareBoard(int size) {
        super(size, size);
    }

    @Override
    void fillBoard(List<Integer> list) {
        Iterator<Integer> itr = list.iterator();

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
    void addItem(Key key, Integer value) {
    board.put(key, value);
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
    Integer getValue(Key key) {

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
    boolean hasValue(Integer value) {
        return board.containsValue(value);
    }

    @Override
    List<Integer> getValues(List<Key> keys) {
        List<Integer> listOfValues = new ArrayList<>();
        for (Key key: keys
             ) {
            listOfValues.add((board.get(key)));
        }
        return listOfValues;
    }
}
