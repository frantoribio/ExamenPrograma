package com.company.Models;

public class Droide {

    private int energy;
    private final TipoDroide TYPE;

    public Droide(int energy, TipoDroide type) {
        this.energy = energy;
        this.TYPE = type;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void loseHealth(int amount){
        if(energy >= amount) {
            this.energy -= amount;
        } else {
            energy = 0;
        }
    }

    public TipoDroide getTYPE() {
        return TYPE;
    }
}
