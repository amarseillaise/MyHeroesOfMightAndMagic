package Seminar2;

public class Peaceant extends BaseUnit {

    private final boolean delivery;

    public Peaceant(){
        super(1, 1, new int[]{1, 1}, 1, 3);
        delivery = true;
    }

    @Override
    public String getInfo() {
        return  "Peaceant -" +
                " Atc: " + attack +
                " Dfn: " + defence +
                " Dmg: " + (damage[0] + damage[1]) / 2 +
                " Hlt: " + health +
                " Sp: " + speed +
                " Dlv: " + delivery;
    }
}
