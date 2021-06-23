package ru.ais;

import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class GameHelper {
    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        Collections.sort(list, Comparator.nullsLast(Comparator.naturalOrder()));

          for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i) == list.get(i + 1)) {
                    list.set(i + 1, list.get(i) * 2);
                    list.remove(i);
                    list.add(list.lastIndexOf(null), null);
                }
            }



            return list;
        }
    }
