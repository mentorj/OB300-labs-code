package com.javaxpert.trainings.demos.ob300.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionIntro {
    public static void main(String[] args) {
        File f = new File("~/.zshrc");
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(f);
            System.out.println("Tout va bien je vais bien");
            // fais qqch d'utile avec ce fichier...
        }catch(IOException e){
            // oops il y a eut un souci avec le fichier
        }
        finally{
            // quoi qu'il en soit erreur ou pas
            // fais quelque chose ici...
        }

    }
}
