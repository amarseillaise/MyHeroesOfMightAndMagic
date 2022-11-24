package Seminar2;

public class CrossBowMan extends BaseUnit {

    private int shots;

    public CrossBowMan(){
        super(6, 3, new int[]{2, 3}, 10, 4);
        shots = 16;
    }

    @Override
    public String getInfo() {
        return  "Crossbowman -" +
                " Atc: " + attack +
                " Dfn: " + defence +
                " Dmg: " + (damage[0] + damage[1]) / 2 +
                " Hlt: " + health +
                " Sp: " + speed +
                " Sht: " + shots;
    }
}