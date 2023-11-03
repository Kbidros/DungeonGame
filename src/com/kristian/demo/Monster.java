package com.kristian.demo;

public class Monster {

    private int strength;
    private int health;
    private int baseDamage;

    public Monster(int strength, int health, int baseDamage) {
        this.strength = strength;
        this.health = health;
        this.baseDamage = baseDamage;
    }

    public void takeDamage(int damage) {
        setHealth(getHealth() - damage );
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
}
