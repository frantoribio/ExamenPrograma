package com.company.Models;

import javax.net.ssl.SSLEngine;

public class Spot {

    private Droide[] droids;
    private int length;
    private int droidNum;

    public Spot(int length){
        this.length = length;
        droids = new Droide[length];
        droidNum = 0;
    }

    public Droide[] getDroids() {
        return droids;
    }

    public void removeDead(){
        for (int i = 0; i < droids.length; i++) {
            if(droids[i] == null){

            }else if(droids[i].getEnergy() == 0){
                droids[i] = null;
                droidNum--;
            }
        }
    }

    public void clear(){
        for (int i = 0; i < droidNum; i++) {
            droids[i] = null;
        }
        droidNum = 0;
    }

    public int getLength() {
        return length;
    }

    public void add(Droide d) {
        droids[droidNum] = d;
        droidNum++;
    }

    public int getDroidNum() {
        return droidNum;
    }

    public void damage(int damage){
        for(int i = 0; i < droidNum; i++){
            if(droids[i] != null) droids[i].loseHealth(damage);
        }
        removeDead();
    }
}
