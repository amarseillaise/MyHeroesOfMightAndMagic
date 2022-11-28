package Seminar2.Characters;

import Seminar2.Coordinate;

import java.util.ArrayList;

public class CrossBowMan extends BaseUnit {

    private int shots;

    public CrossBowMan(ArrayList<BaseUnit> gangSide, int x, int y){
        super("Crossbowman", 6, 3, new int[]{2, 3}, 10, 4, false, false);
        shots = 16;
        super.position = new Coordinate(x, y);
        super.gangSide = gangSide;
    }

    @Override
    public String getInfo() {
        return   super.name + " -" +
                " Atc: " + attack +
                " Dfn: " + defence +
                " Dmg: " + (damage[0] + damage[1]) / 2 +
                " Hlt: " + health +
                " Sp: " + speed +
                " Sht: " + shots +
                " magic: " + magic +
                " delivery: " + delivery;

    }
}