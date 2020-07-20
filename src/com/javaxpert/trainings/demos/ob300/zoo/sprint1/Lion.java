package com.javaxpert.trainings.demos.ob300.zoo.sprint1;

public class Lion extends Animal {
    public Lion(String name, int weightPounds, int ageYears) {
        super(name, weightPounds, ageYears);
    }

    public String crier(){
        return "Wouargh!!!";
    }
}
