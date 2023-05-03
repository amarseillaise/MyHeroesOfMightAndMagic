package Seminar2;

import Seminar2.Characters.BaseUnit;

import java.util.*;

public class Coordinate {

    public int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private Coordinate coordinateOffSet (int x, int y) {
        Coordinate coordinateIn = new Coordinate(this.x, this.y);
        coordinateIn.x += x;
        coordinateIn.y += y;
        return coordinateIn;
    }

    public boolean isEqual(Coordinate opposite) {
        return x == opposite.x && y == opposite.y;
    }

    public boolean isNear(Coordinate target) {
        int distX = Math.abs(this.x - target.x);
        int distY = Math.abs(this.y - target.y);

        return (distX < 2 && distY < 2) && !(distX == 1 & distY == 1);
    }

    public boolean isFree(Coordinate ghostUnitXY,ArrayList<BaseUnit> UnitsPositions) {
        for (BaseUnit xy : UnitsPositions) {
            if (ghostUnitXY.isEqual(xy.getPosition())) return false;
        }
        return true;
    }

    public void goAhead(Coordinate target, ArrayList<BaseUnit> UnitsPositions){
        int distX = this.x - target.x;
        int distY = this.y - target.y;

        if (Math.abs(distX) > Math.abs(distY)){
            if (distX < 0) {
                if (isFree(this.coordinateOffSet(1, 0), UnitsPositions)) this.x++;
                else if (isFree(this.coordinateOffSet(0, 1), UnitsPositions)) this.y++;
                else if (isFree(this.coordinateOffSet(0, -1), UnitsPositions)) this.y--;
            }
            else {
                if (isFree(this.coordinateOffSet(-1, 0), UnitsPositions)) this.x--;
                else if (isFree(this.coordinateOffSet(0, -1), UnitsPositions)) this.y--;
                else if (isFree(this.coordinateOffSet(0, 1), UnitsPositions)) this.y++;
            }
        }

        else {
            if (distY < 0) {
                if (isFree(this.coordinateOffSet(0, 1), UnitsPositions)) this.y++;
                else if (isFree(this.coordinateOffSet(1, 0), UnitsPositions)) this.x++;
                else if (isFree(this.coordinateOffSet(-1, 0), UnitsPositions)) this.x--;
            }
            else {
                if (isFree(this.coordinateOffSet(0, -1), UnitsPositions)) this.y--;
                else if (isFree(this.coordinateOffSet(-1, 0), UnitsPositions)) this.x--;
                else if (isFree(this.coordinateOffSet(1, 0), UnitsPositions)) this.x++;
            }
        }
    }

    public double getDist(Coordinate opposite) {
        return Math.sqrt(Math.pow(opposite.x - this.x, 2) + Math.pow(opposite.y - this.y, 2));
    }
}
