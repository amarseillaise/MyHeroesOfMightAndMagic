package Seminar2;

import Seminar2.Characters.BaseUnit;

import java.util.ArrayList;

public class QuickSort {

    public static BaseUnit quickSort(ArrayList<BaseUnit> buList){
        //sort(buList).forEach(unit -> System.out.println(unit.getInfo()));
        //System.out.println("____________________________");
        return sort(buList).get(0);
    }

    private static ArrayList<BaseUnit> sort(ArrayList<BaseUnit> list){
        if (list.size() < 2) return list;
        else {
            BaseUnit pivot = list.get(0);
            ArrayList<BaseUnit> right = new ArrayList<>();
            ArrayList<BaseUnit> left = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) {
                double currentPercent = list.get(i).getHealth() == 0.0 ? Double.MAX_VALUE : list.get(i).getHealth() / list.get(i).getMaxHealth();
                double pivotPercent = pivot.getHealth() == 0.0 ? Double.MAX_VALUE : pivot.getHealth() / pivot.getMaxHealth();

                if (currentPercent > pivotPercent) right.add(list.get(i));
                else left.add(list.get(i));
            }
            ArrayList<BaseUnit> tempResult = new ArrayList<>(sort(left));
            tempResult.add(pivot);
            tempResult.addAll(sort(right));

            return tempResult;
        }
    }
}
