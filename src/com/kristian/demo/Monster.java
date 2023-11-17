package com.kristian.demo;

import java.util.Random;

public class Monster implements ICombat{

    private final int strength;
    private final int maxHP;
    private int currentHP;
    private final int baseDamage;
    private final String name;

    public Monster(int strength, int maxHP, int currentHP, int baseDamage, String name) {
        this.strength = strength;
        this.baseDamage = baseDamage;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.name = name;


    }
    @Override
    public void fighting() {


    }

    @Override
    public boolean didDodge() {
        return false;
    }

    public int calculateAttackDamage() {
        return (getBaseDamage() + getStrength());
    }

    public void takeDamageFromPlayer(int damage) {
        currentHP -= damage;
        if (currentHP < 0) {
            currentHP = 0;
        }
    }
    public boolean monsterIsAlive() {
        return currentHP > 0;
    }

    public String getName() {
        return name;
    }

    public int getStrength () {
            return strength;
        }

        public int getMaxHP () {
            return maxHP;
        }

        public int getCurrentHP () {
            return currentHP;
        }

        public int getBaseDamage () {
            return baseDamage;
        }

}


