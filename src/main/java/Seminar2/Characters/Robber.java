package Seminar2.Characters;

import Seminar2.Coordinate;

import java.util.ArrayList;

public class Robber extends BaseUnit {

    public Robber(ArrayList<BaseUnit> gangSide, ArrayList<BaseUnit> enemyGangSide, int x, int y){
        super("Robber", 8, 3, new int[]{2, 4}, 10, 6);
        super.position = new Coordinate(x, y);
        this.gangSide = gangSide;
        this.enemyGangSide = enemyGangSide;
    }

    @Override
    public void step() {
        if (!this.status.equals("Dead")) {

            int index = -1;
            double minDist = Double.MAX_VALUE;
            for (int i = 0; i < enemyGangSide.size(); i++) {
                if (enemyGangSide.get(i).status.equals("Dead")) continue;
                double actDist = position.getDist(enemyGangSide.get(i).position);
                if (actDist < minDist) {
                    index = i;
                    minDist = actDist;
                }
            }
            if (index > -1) {
                BaseUnit target = enemyGangSide.get(index);
                if (this.position.isNear(target.position)) {
                    this.hitDamage(target, calcDamage(target));
                    this.status = "Attacking " + target.id;
                }
                else {
                    this.position.goAhead(target.position, this.gangSide);
                    this.status = "Going to " + target.id;
                }
            }
            else this.status = "No target";
        }
    }
}
