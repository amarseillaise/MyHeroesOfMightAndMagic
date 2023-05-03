package Seminar2.Characters;

import Seminar2.Coordinate;

import java.util.ArrayList;

public class Sniper extends BaseUnit {

    private int shots;

    public Sniper(ArrayList<BaseUnit> gangSide, ArrayList<BaseUnit> enemyGangSide, int x, int y){
        super("Sniper", 12, 10, new int[]{8, 10}, 15, 9);
        this.shots = 32;
        super.position = new Coordinate(x, y);
        this.gangSide = gangSide;
        this.enemyGangSide = enemyGangSide;
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
                " ID: " + id +
                " Sts: " + status;
    }

    @Override
    public void step() {
        if (!this.status.equals("Dead")) {
            for (BaseUnit u : gangSide
            ) {
                if (u.name.equals("Peasant") && u.status.equals("Stand")) {
                    this.shots++;
                    u.status = "Supplied " + this.id;
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
                    this.status = "Shooting to " + enemyGangSide.get(index).id;
                    this.shots--;
                }
                else this.status = "No target";
            }
        }
    }
}