package Seminar2;

public class Robber extends BaseUnit {

    public Robber(){
        super(8, 3, new int[]{2, 4}, 10, 6);
    }

    @Override
    public String getInfo() {
        return  "Robber - " +
                "Atc:" + attack +
                " Dfn: " + defence +
                " Dmg: " + (damage[0] + damage[1]) / 2 +
                " Hlt: " + health +
                " Sp: " + speed;
    }
}
