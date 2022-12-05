package Seminar2.Characters;

import Seminar2.Coordinate;

import java.util.ArrayList;

public class CrossBowMan extends BaseUnit {

    private int shots;

    public CrossBowMan(ArrayList<BaseUnit> gangSide, ArrayList<BaseUnit> enemyGangSide, int x, int y){
        super("Crossbowman", 6, 3, new int[]{2, 3}, 10, 4);
        shots = 16;
        super.position = new Coordinate(x, y);
        super.gangSide = gangSide;
        super.enemyGangSide = enemyGangSide;
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
                " Sts: " + status;
    }

    @Override
    public void step() {
        if (!this.status.equals("Dead")) {
            for (BaseUnit u : gangSide
            ) {
                if (u.name.equals("Peasant") && u.status.equals("Stand")) {
                    this.shots++;
                    u.status = "Busy";
                    break;
                }
            }

            if (this.shots > 0) {
                int index = -1;
                double minDist = Double.MAX_VALUE;
                for (int i = 0; i < enemyGangSide.size(); i++) {
                    if (enemyGangSide.get(i).status.equals("Dead")) continue;
                    double actDist = position.getDist(enemyGangSide.get(i).position);
                    if (actDist < minDist){
                        index = i;
                        minDist = actDist;
                    }
                }
                if (index > -1) {
                    this.hitDamage(enemyGangSide.get(index), this.speed > minDist ? calcDamage(enemyGangSide.get(index)) : calcDamage(enemyGangSide.get(index / 2)));
                    this.status = "Shooting";
                    this.shots--;
                }
            }
        }
    }
}