package org.ulco;

public class ID {
    private static ID instance = null;
    private int id = 0;
    public ID(){
    }

    public static ID getInstance(){
        if(instance == null){
            instance = new ID();
        }
        return instance;
    }

    public int generate(){
        id++;
        return id;
    }
}