package Seminar2;

import java.util.ArrayList;

abstract public class BaseUnit implements BaseIUUnitInterface {
    protected int attack;
    protected int defence;
    protected int[] damage;
    protected float health;
    protected float maxHealth;
    protected int speed;
    protected ArrayList<BaseUnit> gangSide;

    public BaseUnit(int attack, int defence, int[] damage, float health, int speed) {
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.health = health / 2;
        this.maxHealth = health;
        this.speed = speed;
    }

    @Override
    public String getInfo() {
        return  "Atc: " + attack +
                "Dfn: " + defence +
                "Dmg: " + (damage[0] + damage[1]) / 2 +
                "Hlt: " + health +
                "Sp: " + speed;
    }

    @Override
    public void step() {

    }

}
