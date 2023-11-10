package com.kristian.demo;

public class Monster {

    private int strength;
    private int maxHP;
    private int currentHP;
    private int baseDamage;

    public Monster(int strength, int maxHP, int currentHP, int baseDamage) {
        this.strength = strength;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.baseDamage = baseDamage;
    }

    public void takeDamage(int damage) {
        setCurrentHP(Math.max(0, getCurrentHP() - damage ));

        if (getCurrentHP() == 0) {
            System.out.println("Monster is dead!");
        } else {
            System.out.println("Monster took " + damage + " damage. Remaining health: " + getCurrentHP());
        }

    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
}


