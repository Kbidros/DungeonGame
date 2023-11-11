package com.kristian.demo;

import java.util.Random;

public class Player {
    private String name;
    private int strength;
    private int intelligence;
    private int agility;
    private int maxHP;
    private int experience;
    private int level;
    private int baseDamage;
    private int currentHP;

    public Player(int strength, int intelligence, int agility, int maxHP, int level, int baseDamage, int currentHP) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.maxHP = maxHP;
        this.level = level;
        this.baseDamage = baseDamage;
        this.currentHP = currentHP;
    }

    public int calculateAttackDamage() {
        return (getBaseDamage() + getStrength());
    }


    public void takeDamageFromMonster(int damage) {
        currentHP -= damage;
        if (currentHP <0) {
            currentHP= 0;
        }
    }

    public void experienceToLevelUp(int amountOfExp) {

        experience += amountOfExp;
        if (experience >= 100) {
        }
    }
        private void levelingUp() {
            // Level up att 100
            if (getExperience() == 100) {
                setLevel(getLevel() +1);
                setExperience(-100);
                setMaxHP(getMaxHP() +15);
                setCurrentHP(getMaxHP());
                setStrength(getStrength() +10);
                setBaseDamage(getBaseDamage() +5);
                setIntelligence(getIntelligence() +5);
                setAgility(getLevel() +5);
                System.out.println("Congratulations! You've reached a new level " + getName() + ". " + "Your level is now " + getLevel() + "!");

            }

        }


    public void getStatus() {
        System.out.printf("Name: %s %n", name);
        System.out.printf("Strength: %d %n", strength);
        System.out.printf("Intelligence: %d %n", intelligence);
        System.out.printf("Agility: %d %n", agility);
        System.out.printf("Health: %d %n", maxHP);
        System.out.printf("Experience: %d %n", experience);
        System.out.printf("Level: %d %n", level);
        System.out.printf("BaseDamage: %d %n", baseDamage);
        System.out.printf("Current HP: %d %n", currentHP);



    }
    public boolean playerIsAlive() {
        return currentHP > 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
    public int getCurrentHP () {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

}
