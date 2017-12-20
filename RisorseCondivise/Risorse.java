package com.simone;

import java.util.concurrent.Semaphore;

public class Risorse {
    protected Semaphore semaforo;
    private String name;

    public Risorse (String name){
        this.name = name;
        this.semaforo = new Semaphore(1, true);
    }

    public String getName(){
        return name;
    }

}