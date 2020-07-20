package com.javaxpert.trainings.demos.ob300.zoo.sprint1;

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
        Animal[] animals_live  = myZoo.listAnimals();
        String[] cris = new String[animals_live.length];
        int counter=0;
        // asks each one to say who is it
        for (Animal a : animals_live){
            if(a!=null) {
                String cri = a.crier();
                System.out.println("Animal invoked" + cri);
                cris[counter++] = cri;
            }
        }

        System.err.println(counter + " animals are  peesent");
        // now we have the list of crier() results

        // how to check it is equal to the expected list?
        if(counter != refCris.length){
            result=false;
            System.err.println("Bad check arrays length is wrong");
        }
        // check the contents  too
        //@TODO

        return result;
    }
}
