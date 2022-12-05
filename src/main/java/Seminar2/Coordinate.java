package Seminar2;

public class Coordinate {

    public int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEqual(Coordinate opposite) {
        return x == opposite.x && y == opposite.y;
    }

    public double getDist(Coordinate opposite) {
        return Math.sqrt(Math.pow(opposite.x - this.x, 2) + Math.pow(opposite.y - this.y, 2));
    }
}
