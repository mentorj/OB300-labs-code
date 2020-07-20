package com.javaxpert.trainings.demos.ob300.zoo.sprint1;

public class Zoo {
    private Animal[] liveAnimals;
    private int maxSize=10;
    private int addedAnimals;

    public Zoo(){
        System.out.println("Zoo is up & ready  but empty\n Please add animalss..");
        liveAnimals=new Animal[maxSize];
        assert (liveAnimals[0]==null && liveAnimals.length==maxSize);
    }

    public void addAnimal(Animal a){
        System.out.println("adding into the zoo : " + a.toString());
        if(addedAnimals==maxSize){
            System.out.println("Sorry but zoo is already full...");
        }
        else{
            liveAnimals[addedAnimals++]=a;
            System.out.println("Added animal = "+ a);
        }
    }

    public Animal[] listAnimals(){
        return liveAnimals;
    }


}
