package Seminar2;

import Seminar2.Characters.BaseUnit;

import java.util.*;

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
        int distX = Math.abs(this.x - target.x);
        int distY = Math.abs(this.y - target.y);

        return (distX < 2 && distY < 2) && !(distX == 1 & distY == 1);
    }

    public boolean isOccupied(ArrayList<BaseUnit> UnitsPositions) {
        for (BaseUnit xy : UnitsPositions) {
            if (this.equals(xy.getPosition())) return true;
        }
        return false;
    }

    public void goAhead(Coordinate target, ArrayList<BaseUnit> UnitsPositions){
        int distX = this.x - target.x;
        int distY = this.y - target.y;

        if (Math.abs(distX) > Math.abs(distY)){
            if (distX < 0) {
                if(isOccupied(UnitsPositions))
            }

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
