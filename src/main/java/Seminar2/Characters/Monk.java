package Seminar2.Characters;

import Seminar2.Coordinate;
import Seminar2.QuickSort;

import java.util.ArrayList;

public class Monk extends BaseUnit{

    public Monk(ArrayList<BaseUnit> gangSide, ArrayList<BaseUnit> enemyGangSide, int x, int y){
        super("Monk", 17, 12, new int[]{-5, -5}, 30, 9);
        super.position = new Coordinate(x, y);
        this.gangSide = gangSide;
        this.enemyGangSide = enemyGangSide;
    }

    @Override
    public void step() {
        if (!this.status.equals("Dead")){
            BaseUnit unit = QuickSort.quickSort(gangSide);
            if (!unit.getStatus().equals("Dead" ) && unit.health != unit.maxHealth) {
                unit.health = Math.min(unit.health - this.damage[0], unit.maxHealth);
                this.status = "healed " + unit.getId();
            }
        }
        else this.status = "Stand";
    }
}
