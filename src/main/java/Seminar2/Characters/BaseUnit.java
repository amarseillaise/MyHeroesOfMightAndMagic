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
    protected boolean magic;
    protected boolean delivery;
    protected ArrayList<BaseUnit> gangSide;
    protected Coordinate position;

    public BaseUnit(String name, int attack, int defence, int[] damage, float health, int speed, boolean magic, boolean delivery) {
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.health = health / 2;
        this.maxHealth = health;
        this.speed = speed;
        this.magic = magic;
        this.delivery = delivery;
        this.name = name;
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

    @Override
    public String getInfo() {
        return   name + " -" +
                " Atc: " + attack +
                " Dfn: " + defence +
                " Dmg: " + (damage[0] + damage[1]) / 2 +
                " Hlt: " + health +
                " Sp: " + speed +
                " magic: " + magic +
                " delivery: " + delivery;
    }

    @Override
    public void step(ArrayList<BaseUnit> gang) {
        position.x++;
    }
}
