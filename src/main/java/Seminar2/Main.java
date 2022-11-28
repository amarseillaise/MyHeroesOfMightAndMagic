package Seminar2;

import Seminar2.Characters.*;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseUnit> lightGang;
    public static ArrayList<BaseUnit> darkGang;

    public static void main(String[] args) {

        init();
        Scanner scanner = new Scanner(System.in);

        while (true){
            Visual.output();
            lightGang.forEach(baseUnit -> baseUnit.step(lightGang));
            darkGang.forEach(baseUnit -> baseUnit.step(darkGang));
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
                case 0 -> lightGang.add(new Spearman(lightGang, x, y++));
                case 1 -> lightGang.add(new CrossBowMan(lightGang, x, y++));
                case 2 -> lightGang.add(new Monk(lightGang, x, y++));
                default -> lightGang.add(new Peasant(lightGang, x, y++));
            }
        }

        x = GANG_SIZE;
        y = 1;
        for (int j = 0; j < GANG_SIZE; j++) {
            int index = new Random().nextInt(4);
            switch (index){
                case 0 -> darkGang.add(new Robber(lightGang, x, y++));
                case 1 -> darkGang.add(new Sniper(lightGang, x, y++));
                case 2 -> darkGang.add(new Wizard(lightGang, x, y++));
                default -> darkGang.add(new Peasant(lightGang, x, y++));
            }
        }

    }

    public static void selectTypeUnit(List<BaseUnit> list, String type ){
        for (BaseUnit unit : list) {
            if (unit.toString().split(" ")[0].equals(type)) System.out.println(unit);
        }
    }
}
