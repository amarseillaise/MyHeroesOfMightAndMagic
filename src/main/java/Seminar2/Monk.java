package Seminar2;

import java.util.ArrayList;

public class Monk extends BaseUnit{

    private final boolean magic;

    public Monk(ArrayList<BaseUnit> gangSide){
        super(17, 12, new int[]{-5, -5}, 30, 9);
        magic = true;
        super.gangSide = gangSide;
    }

    @Override
    public String getInfo() {
        return  "Monk -" +
                " Atc: " + attack +
                " Dfn: " + defence +
                " Dmg: " + (damage[0] + damage[1]) / 2 +
                " Hlt: " + health +
                " Sp: " + speed +
                " Mgc: " + magic;
    }

    @Override
    public void step() {
        gangSide = QuickSort.quickSort(gangSide);
        BaseUnit unit = gangSide.get(gangSide.size() - 1);
        if (unit.health - damage[0] > unit.maxHealth) gangSide.get(gangSide.size() - 1).health = gangSide.get(gangSide.size() - 1).maxHealth;
        else gangSide.get(gangSide.size() - 1).health -= damage[0];
    }
}
