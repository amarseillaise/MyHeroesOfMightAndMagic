package Seminar2;

import java.util.ArrayList;

public class QuickSort {

    public static ArrayList<BaseUnit> quickSort(ArrayList<BaseUnit> list){
        if (list.size() < 2) return list;
        else {
            BaseUnit pivot = list.get(0);
            ArrayList<BaseUnit> right = new ArrayList<>();
            ArrayList<BaseUnit> left = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).maxHealth - list.get(i).health > pivot.health) right.add(list.get(i));
                else left.add(list.get(i));
            }
            ArrayList<BaseUnit> tempResult = new ArrayList<>(quickSort(left));
            tempResult.add(pivot);
            tempResult.addAll(quickSort(right));

            return tempResult;
        }
    }
}
