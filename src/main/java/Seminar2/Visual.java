package Seminar2;

import java.util.ArrayList;
import java.util.Collections;

public class Visual {

    static int  step = 1;
    static private ArrayList<String> unitInfo = new ArrayList<>();
    private static final String top = formatDiv("a") + String.join("", Collections.nCopies(Main.GANG_SIZE - 1, formatDiv("-b"))) + formatDiv("-c");
    private static final String mid = formatDiv("d") + String.join("", Collections.nCopies(Main.GANG_SIZE - 1, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom = formatDiv("g") + String.join("", Collections.nCopies(Main.GANG_SIZE - 1, formatDiv("-h"))) + formatDiv("-i");

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c') // ┌
                .replace('b', '\u252c')  // ┬
                .replace('c', '\u2510') // ┐
                .replace('d', '\u251c') // ├
                .replace('e', '\u253c') // ┼
                .replace('f', '\u2524') // ┤
                .replace('g', '\u2514') // └
                .replace('h', '\u2534') // ┴
                .replace('i', '\u2518') // ┘
                .replace('-', '\u2500'); // ─
    }

    private static String getDeployment(Coordinate posit){
        String str = "| ";

        for (int i = 0; i < Main.GANG_SIZE; i++) {

            if (Main.lightGang.get(i).getPosition().isEqual(posit)) {
                str = "|" + AnsiColors.ANSI_BLUE + Main.lightGang.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
                unitInfo.add("| " + AnsiColors.ANSI_BLUE + Main.lightGang.get(i).getInfo() + AnsiColors.ANSI_RESET + " ");
            }

            if (Main.darkGang.get(i).getPosition().isEqual(posit)) {
                str = "|" + AnsiColors.ANSI_RED + Main.darkGang.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
                unitInfo.add("| " + AnsiColors.ANSI_RED + Main.darkGang.get(i).getInfo() + AnsiColors.ANSI_RESET + " ");
            }
        }
        return str;
    }

    public static void output(){
        System.out.println("Step №" + step);
        step++;

        System.out.println(top);

        for (int i = 1; i <= Main.GANG_SIZE - 1; i++) {
            unitInfo.clear();
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getDeployment(new Coordinate(j, i)));
            }
            if (unitInfo.size() > 0){
                unitInfo.forEach(System.out::print);
            }

            System.out.println("|");
            System.out.println(mid);
        }

        unitInfo.clear();
        for (int i = 1; i <= Main.GANG_SIZE; i++) {
            System.out.print(getDeployment(new Coordinate(i, Main.GANG_SIZE)));
        }
        if (unitInfo.size() > 0){
            unitInfo.forEach(System.out::print);
        }

        System.out.println("|");
        System.out.println(bottom);
        System.out.println("Press Enter");

    }
}
