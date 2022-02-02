package com.company.Models;

import com.company.Creator.DroideCreator;
import com.company.Utils.Utils;

public class Map {

    Spot[] map;
    int length;
    int hits;
    int miss;
    int initialDroids;
    Droide[] droides;

    public Map(int length, int initialDroids) {
        this.initialDroids = initialDroids;
        this.length = length;
        map = new Spot[length];
    }

    public void init(){
        droides = new Droide[initialDroids];
        for (int i = 0; i < initialDroids; i++) {
            droides[i] = DroideCreator.random();
        }
        for (int i = 0; i < length; i++) {

            map[i] = new Spot(initialDroids);
        }

        randomDistribution();
    }

    private void randomDistribution() {
        for(Spot s: map){
            s.clear();
        }
        for(Droide d: droides){
            int rSpot = Utils.randomNum(0,length-1);
            map[rSpot].add(d);
        }
    }

    public void changePos(){
        for (Droide d : droides) {
            d = null;
        }
        for (Spot s: map) {
            Droide[] droids = s.getDroids();
            int num = s.getDroidNum();
            stack(droids, num);
        }
        randomDistribution();
    }

    private void stack(Droide[] droids, int num) {
        int count = 0;
        for (int i = 0; i < droides.length && count < num; i++) {
            if(droides[i] == null){
                droides[i] = droids[count];
                count ++;
            }
        }
    }


    public void randomShoot(){
        int damage = 0;
        int index = Utils.randomNum(0,length-1);
        if(map[index].getDroidNum() != 0){
            int rnum = Utils.randomNum(0,100);
            damage++;
            System.out.println("la nave enemiga ha sido golpeada");
            if(rnum < 15){
                damage += 4;
                System.out.println("golpe critico!!");
            }
            hits++;
            map[index].damage(damage);
        } else {
            System.out.println("no habia nada que disparar");
            miss++;
        }
    }

    public Droide[] getDroides() {
        return droides;
    }

    public int getHits() {
        return hits;
    }

    public int getMiss() {
        return miss;
    }

    public int getInitialDroids() {
        return initialDroids;
    }
}
