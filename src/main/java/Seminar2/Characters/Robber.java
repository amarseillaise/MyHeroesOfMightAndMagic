package Seminar2.Characters;

import Seminar2.Coordinate;

import java.util.ArrayList;

public class Robber extends BaseUnit {

    public Robber(ArrayList<BaseUnit> gangSide, ArrayList<BaseUnit> enemyGangSide, int x, int y){
        super("Robber", 8, 3, new int[]{2, 4}, 10, 6);
        super.position = new Coordinate(x, y);
        super.gangSide = gangSide;
        super.enemyGangSide = enemyGangSide;
    }
}
