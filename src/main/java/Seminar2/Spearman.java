package Seminar2;

public class Spearman extends BaseUnit {

    public Spearman(){
        super(4, 5, new int[]{1, 3}, 10, 4);
    }

    @Override
    public String getInfo() {
        return  "Spearman -" +
                "Atc: " + attack +
                " Dfn: " + defence +
                " Dmg: " + (damage[0] + damage[1]) / 2 +
                " Hlt: " + health +
                " Sp: " + speed;
    }
}
