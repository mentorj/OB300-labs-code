package com.javaxpert.trainings.demos.ob300.zoo.sprint1;

public abstract class Animal {
    public String getName() {
        return name;
    }

    public Animal(String name, int weightPounds, int ageYears) {
        this.name = name;
        this.weightPounds = weightPounds;
        this.ageYears = ageYears;
    }

    protected String name;
    protected int weightPounds;
    protected int ageYears;

    public int getWeightPounds() {
        return weightPounds;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public abstract String crier();
}
