package Seminar2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Coordinate {

    public int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEqual(Coordinate opposite) {
        return x == opposite.x && y == opposite.y;
    }

    public boolean isNear(Coordinate target) {
        Set<Integer> nearXY = new HashSet<>();
        nearXY.add(1);
        nearXY.add(-1);
        return ((nearXY.contains(this.x - target.x) | nearXY.contains(this.y - target.y)) &
                !((nearXY.contains(this.x - target.x) & nearXY.contains(this.y - target.y))));
    }

    public void goAhead(Coordinate target){
        int distX = this.x - target.x;
        int distY = this.y - target.y;

        if (Math.abs(distX) > Math.abs(distY)){
            if (distX < 0) this.x++;
            else this.x--;
        }
        else {
            if (distY < 0) this.y++;
            else this.y--;
        }
    }

    public double getDist(Coordinate opposite) {
        return Math.sqrt(Math.pow(opposite.x - this.x, 2) + Math.pow(opposite.y - this.y, 2));
    }
}
