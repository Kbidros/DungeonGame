package com.kristian.demo;

import java.util.Random;

public class Monster {

    private int strength;
    private int maxHP;
    private int currentHP;
    private int baseDamage;
    private String name;

    public Monster(int strength, int maxHP, int currentHP, int baseDamage, String name) {
        this.strength = strength;
        this.baseDamage = baseDamage;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.name = name;

    }

    public int calculateDamageToPlayer() {
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

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength () {
            return strength;
        }

        public void setStrength ( int strength){
            this.strength = strength;
        }

        public int getMaxHP () {
            return maxHP;
        }

        public void setMaxHP ( int maxHP){
            this.maxHP = maxHP;
        }

        public int getCurrentHP () {
            return currentHP;
        }

        public void setCurrentHP ( int currentHP){
            this.currentHP = currentHP;
        }

        public int getBaseDamage () {
            return baseDamage;
        }

        public void setBaseDamage ( int baseDamage){
            this.baseDamage = baseDamage;
        }
    }


