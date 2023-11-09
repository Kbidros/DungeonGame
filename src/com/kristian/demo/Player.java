package com.kristian.demo;

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

    // Raden under kan finnas i iCombat också,kske bättre tom.
    public void takeDamage(int damage) {

        setMaxHP(getCurrentHP() - damage );

    }

    public void calculateExperienceToLevel(int amountOfExp){

        // amountOfEXP = 100
        for (int i = amountOfExp; i > 0 ; i--) {
            setExperience(getExperience() + 1);

            // Level up att 100
            if (getExperience() == 100) {
                setLevel(getLevel() +1);
                setExperience(0);
            }
        }
        System.out.println("how much exp does player have?");
        System.out.println(getExperience());

        System.out.println("player level?");
        System.out.println(getLevel());

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
