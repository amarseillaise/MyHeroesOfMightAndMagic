package Seminar2.Characters;

import Seminar2.Coordinate;

import java.util.ArrayList;

public class Spearman extends BaseUnit {

    public Spearman(ArrayList<BaseUnit> gangSide, ArrayList<BaseUnit> enemyGangSide, int x, int y){
        super("Spearman", 4, 5, new int[]{1, 3}, 10, 4);
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
