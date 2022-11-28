package Seminar2.Characters;

import Seminar2.Coordinate;

import java.util.ArrayList;

public class Sniper extends BaseUnit {

    private int shots;

    public Sniper(ArrayList<BaseUnit> gangSide, int x, int y){
        super("Sniper", 12, 10, new int[]{8, 10}, 15, 9, false,false);
        shots = 32;
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