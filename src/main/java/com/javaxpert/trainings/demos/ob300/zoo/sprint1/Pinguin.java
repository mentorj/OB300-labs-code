package com.javaxpert.trainings.demos.ob300.zoo.sprint1;

public class Pinguin extends Animal {

    public Pinguin(String name, int weightPounds, int ageYears) {
        super(name, weightPounds, ageYears);
    }

    @Override
    public String crier() {
        return "CoinCoin";
    }
}
