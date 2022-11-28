package Seminar2.Characters;

import Seminar2.Coordinate;

import java.util.ArrayList;

public class Peasant extends BaseUnit {

    public Peasant(ArrayList<BaseUnit> gangSide, int x, int y){
        super("Peasant", 1, 1, new int[]{1, 1}, 1, 3, false, true);
        super.position = new Coordinate(x, y);
        super.gangSide = gangSide;
    }
}
