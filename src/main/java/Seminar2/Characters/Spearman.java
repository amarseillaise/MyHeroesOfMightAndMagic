package Seminar2.Characters;

import Seminar2.Coordinate;

import java.util.ArrayList;

public class Spearman extends BaseUnit {

    public Spearman(ArrayList<BaseUnit> gangSide, int x, int y){
        super("Spearman", 4, 5, new int[]{1, 3}, 10, 4, false, false);
        super.position = new Coordinate(x, y);
        super.gangSide = gangSide;

    }
}
