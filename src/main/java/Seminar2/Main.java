package Seminar2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static BaseUnit getRandomUnit(int minIndex, ArrayList<BaseUnit> side){
        int unit = new Random().nextInt(minIndex,minIndex + 4);
        return switch(unit) {
            case 0 -> new Robber();
            case 1 -> new Sniper();
            case 2 -> new Wizard(side);
            case 3 -> new Peaceant();
            case 4 -> new Spearman();
            case 5 -> new CrossBowMan();
            default -> new Monk(side);
        };
    }

    public static void selectTypeUnit(List<BaseUnit> list, String type ){
        for (BaseUnit unit : list) {
            if (unit.toString().split(" ")[0].equals(type)) System.out.println(unit);
        }
    }
    
    public static void main(String[] args) {
        
    //List<BaseUnit> gang = new ArrayList<>();
    //while (gang.size()< 50) gang.add(getRandomUnit());
    //selectTypeUnit(gang, "Robber");

        ArrayList<BaseUnit> lightGang = new ArrayList<>();
        ArrayList<BaseUnit> darkGang = new ArrayList<>();

        while (lightGang.size() < 10) {
            lightGang.add(getRandomUnit(3, lightGang));
            darkGang.add(getRandomUnit(0, darkGang));
        }

        QuickSort.quickSort(lightGang).forEach(baseUnit -> System.out.println(baseUnit.getInfo()));
        System.out.println("______________________________________________");
        QuickSort.quickSort(darkGang).forEach(baseUnit -> System.out.println(baseUnit.getInfo()));

        lightGang.forEach(BaseUnit::step);
        darkGang.forEach(BaseUnit::step);

        System.out.println("______________________________________________");

        QuickSort.quickSort(lightGang).forEach(baseUnit -> System.out.println(baseUnit.getInfo()));
        System.out.println("______________________________________________");
        QuickSort.quickSort(darkGang).forEach(baseUnit -> System.out.println(baseUnit.getInfo()));

    }
}
