package com.kristian.demo;

public class Player {

    private String name;
    private int strength;
    private int intelligence;
    private int agility;
    private int health;
    private int experience;
    private int level;
    private int baseDamage;

    public Player(int strength, int intelligence, int agility, int health, int level, int baseDamage) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.health = health;
        this.level = level;
        this.baseDamage = baseDamage;
    }

    // Raden under kan finnas i iCombat också,kske bättre tom.
    public void takeDamage(int damage) {

        setHealth(getHealth() - damage );

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
        System.out.printf("Health: %d %n", health);
        System.out.printf("Experience: %d %n", experience);
        System.out.printf("Level: %d %n", level);
        System.out.printf("BaseDamage: %d %n", baseDamage);


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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
}
