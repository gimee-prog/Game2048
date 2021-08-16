package ru.avd.core;

import java.util.ArrayList;
import java.util.List;

public class GameHelper {
    public List<Integer> moveAndMergeEqual(List<Integer> list) {

        List<Integer> list1 = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null){
                list1.add(null);
            } else {
                list1.add(k, list.get(i));
                k++;
            }
        }
        for (int i = 0; i < list1.size()-1; i++) {
            if (list1.get(i) != null) {
                if (list1.get(i) == list1.get(i + 1)) {
                    list1.set(i, list1.get(i) * 2);
                    list1.remove(i + 1);
                    list1.add(null);
                }
            }
        }

        list = list1;
        return list;
        }
    }
