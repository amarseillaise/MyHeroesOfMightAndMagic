package Seminar2;

import Seminar2.Characters.*;

import javax.swing.plaf.PanelUI;
import java.util.*;

public class Main {

    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseUnit> lightGang;
    public static ArrayList<BaseUnit> darkGang;

    public static void main(String[] args) {

        init();
        Scanner scanner = new Scanner(System.in);

        while (true){
            Visual.output();
            turnMove();
            scanner.nextLine();
        }
    }

    private static void init(){
        darkGang = new ArrayList<>();
        lightGang = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            int index = new Random().nextInt(4);
            switch (index){
                case 0, 1 -> lightGang.add(new Spearman(lightGang, darkGang, x, y++));
                //case 1 -> lightGang.add(new CrossBowMan(lightGang, darkGang, x, y++));
                case 2 -> lightGang.add(new Monk(lightGang, darkGang, x, y++));
                default -> lightGang.add(new Peasant(lightGang, darkGang, x, y++));
            }
        }

        x = GANG_SIZE;
        y = 1;
        for (int j = 0; j < GANG_SIZE; j++) {
            int index = new Random().nextInt(4);
            switch (index){
                case 0, 1 -> darkGang.add(new Robber(darkGang, lightGang, x, y++));
                //case 1 -> darkGang.add(new Sniper(darkGang, lightGang, x, y++));
                case 2 -> darkGang.add(new Wizard(darkGang, lightGang, x, y++));
                default -> darkGang.add(new Peasant(darkGang, lightGang, x, y++));
            }
        }

    }

    public static void selectTypeUnit(List<BaseUnit> list, String type ){
        for (BaseUnit unit : list) {
            if (unit.toString().split(" ")[0].equals(type)) System.out.println(unit);
        }
    }

    private static void turnMove(){
        ArrayList<BaseUnit> unionGang = new ArrayList<>(lightGang);
        unionGang.addAll(darkGang);
        unionGang.sort(new Comparator<BaseUnit>() {
            @Override
            public int compare(BaseUnit o1, BaseUnit o2) {
                return o2.getSpeed() - o1.getSpeed();
            }
        });
        unionGang.forEach(BaseUnit::step);
    }
}