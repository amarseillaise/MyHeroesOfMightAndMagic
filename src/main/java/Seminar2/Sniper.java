package Seminar2;

public class Sniper extends BaseUnit {

    private int shots;

    public Sniper(){
        super(12, 10, new int[]{8, 10}, 15, 9);
        shots = 32;
    }

    @Override
    public String getInfo() {
        return  "Sniper -" +
                " Atc: " + attack +
                " Dfn: " + defence +
                " Dmg: " + (damage[0] + damage[1]) / 2 +
                " Hlt: " + health +
                " Sp: " + speed +
                " Sht: " + shots;
    }
}