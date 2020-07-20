package com.javaxpert.trainings.demos.ob300.zoo.sprint1;

import java.util.ArrayList;
import java.util.List;

public class Zookeeper {
    private Zoo myZoo;
    private String[] refCris;
    private final static String[] DEFAULT_CRIS_DB= new String[]{"Wouargh", "Wouargh", "CoinCoin"};
    public Zookeeper(final Zoo zoo){
        myZoo=zoo;
        readReferenceDatabase();
    }

    private void readReferenceDatabase(){
        refCris=DEFAULT_CRIS_DB;
    }
    public boolean callAnimals(){
        boolean result =true;
        // get the list of animals in the zoo NOW !!
        List<Animal> animals_live  = myZoo.listAnimals();
        List<String> cris = new ArrayList<>();

        // asks each one to say who is it
        for (Animal a : animals_live){
            if(a!=null) {
                String cri = a.crier();
                System.out.println("Animal invoked" + cri);
                cris.add(cri);
            }
        }

        System.err.println(cris.size()+ " animals are  peesent");
        // now we have the list of crier() results

        // how to check it is equal to the expected list?
        if(cris.size()!= refCris.length){
            result=false;
        }
        // check the contents  too
        //@TODO

        return result;
    }
}
