package com.javaxpert.trainings.demos.ob300.zoo.sprint1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zookeeper {
    private Zoo myZoo;
    private Map<String,Integer> refCris;
    private final static String[] DEFAULT_CRIS_DB= new String[]{"Wouargh", "Wouargh", "CoinCoin"};
    public Zookeeper(final Zoo zoo){
        myZoo=zoo;
        readReferenceDatabase();
    }

    // now uses a map to store the crier() outputs with frequencies
    // {"wouargh":2,"coin":1}
    private void readReferenceDatabase(){
        refCris=new HashMap<>();
        for (String cri:DEFAULT_CRIS_DB){
            // increment counter for this type of cri
            if(refCris.containsKey(cri)){
                int counter = refCris.get(cri);
                refCris.put(cri,++counter);
            }
            // type not yet present
            else{
                refCris.put(cri,1);
            }
        }
        //refCris=DEFAULT_CRIS_DB;
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
        if(cris.size()!= refCris.size()){
            result=false;
        }
        // craetes a map with obtained strings to check against reference database
        Map<String,Integer> obtained = new HashMap();
        for(String cri:cris){
            if(obtained.containsKey(cri)){
                int counter = obtained.get(cri);
                obtained.put(cri,++counter);
            }
            else{
                obtained.put(cri,1);
            }
        }

        // now compares 2 maps
        result=(obtained.size()==refCris.size());
        System.err.println("Checking collections sizes: got "+ refCris.size() + " in refDb, got "+ obtained.size() + " from live animals");
        for(String cri:refCris.keySet()){
            if(!obtained.containsKey(cri)){
                result=false;
                System.err.println("Key =" + cri + " from ref database not found in live database");
            }
            result&=refCris.get(cri)==obtained.get(cri);
        }
        return result;
    }
}
