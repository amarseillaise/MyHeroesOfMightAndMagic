package Seminar2.Characters;

import Seminar2.Coordinate;

import java.util.ArrayList;

public class Wizard extends BaseUnit{

    public Wizard(ArrayList<BaseUnit> gangSide, ArrayList<BaseUnit> enemyGangSide, int x, int y){
        super("Wizard", 17, 12, new int[]{-5, -5}, 30, 9);
        super.position = new Coordinate(x, y);
        super.gangSide = gangSide;
        super.enemyGangSide = enemyGangSide;
    }
}
