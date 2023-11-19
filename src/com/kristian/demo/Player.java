package com.kristian.demo;

import java.util.Random;

import static com.kristian.demo.Colors.*;

public class Player implements ICombat {
    private String name;
    private int strength;
    private int intelligence;
    private int agility;
    private int maxHP;
    private int experience;
    private int level;
    private int baseDamage;
    private int currentHP;
    private boolean isDead = false;

    public Player(int strength, int intelligence, int agility, int maxHP, int level, int baseDamage, int currentHP) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.maxHP = maxHP;
        this.level = level;
        this.baseDamage = baseDamage;
        this.currentHP = currentHP;
    }

    //ICombat fight and dodge

    @Override
    public int calculateAttackDamage() { return getBaseDamage() + (getStrength() + 10);}

    @Override
    public boolean didDodge() {
        int dodgeHit = getAgility() * 2;
        int randomValue = new Random().nextInt(100) + getAgility();
        return randomValue <= dodgeHit;
    }

    // Player taking damage from monster
    public void takeDamageFromMonster(int damage) {
        currentHP -= damage;
        if (currentHP < 0) {
            currentHP = 0;
            isDead = true;
        }
    }

    // Experience needed to level up
    public void experienceToLevelUp(int amountOfExp) {

        experience += amountOfExp;
        if (experience >= 100) {
        }
    }

    // Leveling up method
    void levelingUp() {
        // Level up once you reach 100 exp.
        if (getExperience() == 100) {
            setLevel(getLevel() + 1);
            setExperience(0);
            setMaxHP(getMaxHP() + 15);
            setCurrentHP(getMaxHP());
            setStrength(getStrength() + 10);
            setBaseDamage(getBaseDamage() + 5);
            setIntelligence(getIntelligence() + 5);
            setAgility(getLevel() + 5);
            System.out.println(CYAN + "Congratulations! You've reached a new level " + getName() + ". " + "Your level is now " + getLevel() + "!" + RESET);
        }
    }

    // Chance to double your hit based on your intelligence level
    public boolean doubleHit() {
        int doubleHitChance = getIntelligence() * 2;
        int randomValue = new Random().nextInt(100) + getIntelligence();
        return randomValue <= doubleHitChance;
    }

    // Get the current stats
    public void getStatus() {
        System.out.printf(CYAN + "Name: %s %n", name);
        System.out.printf(RED + "Current HP: %d/%d %n", currentHP, maxHP);
        System.out.printf(PURPLE + "Strength: %d %n", strength);
        System.out.printf(PURPLE + "Intelligence: %d %n", intelligence);
        System.out.printf(PURPLE + "Agility: %d %n", agility);
        System.out.printf(CYAN + "Experience: %d %n", experience);
        System.out.printf(CYAN + "Level: %d %n", level);
        System.out.printf(YELLOW + "BaseDamage: %d %n" + RESET, baseDamage);
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

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public boolean isDead() {
        return isDead;
    }
}
