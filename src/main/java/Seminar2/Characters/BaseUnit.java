package Seminar2.Characters;

import Seminar2.Coordinate;

import java.util.ArrayList;

abstract public class BaseUnit implements BaseIUUnitInterface {
    protected String name;
    protected int attack;
    protected int defence;
    protected int[] damage;
    protected float health;
    protected float maxHealth;
    protected int speed;
    protected ArrayList<BaseUnit> gangSide;
    protected ArrayList<BaseUnit> enemyGangSide;
    protected Coordinate position;
    protected String status;

    public BaseUnit(String name, int attack, int defence, int[] damage, float health, int speed) {
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.health = health;
        this.maxHealth = health;
        this.speed = speed;
        this.name = name;
        this.status = "Stand";
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public float getHealth() {
        return health;
    }

    public Coordinate getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getSpeed() {
        return speed;
    }

    protected float calcDamage(BaseUnit unit){
        if (unit.defence - this.attack == 0) return this.damage[0] + this.damage[1] / 2.0f;
        if (unit.defence - this.attack > 0) return this.damage[0];
        return this.damage[1];
    }

    public void hitDamage(BaseUnit unit, float damageValue){
        unit.health -= damageValue;
        if (unit.health <= 0){
            unit.status = "Dead";
            unit.health = 0;
        }
    }

    @Override
    public String getInfo() {
        return   name + " -" +
                " Atc: " + attack +
                " Dfn: " + defence +
                " Dmg: " + (damage[0] + damage[1]) / 2 +
                " Hlt: " + health +
                " Sp: " + speed +
                " Sts: " + status;
    }

    @Override
    public void step() {

    }
}
