package com.company;

import com.company.Models.Map;
import com.company.Utils.ArgsManager;
import com.company.Utils.Utils;

public class Main {

    static Map map;
    static int time = 0;
    static int MAX_TIME;

    public static void main(String[] args) {


        int[] arg = ArgsManager.get(args);
        map = new Map(arg[0], arg[1]);

        map.init();

        System.out.println("escribe el numero de segundos que quieres jugar[1/3]");
        MAX_TIME = Utils.tryNextInt(1, 3);


        while (keepPlaying()) {

            map.randomShoot();
            if ((time % 3) == 0) {
                map.changePos();
            }
            time += 100;
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
        }
        results();
    }

    public static boolean keepPlaying() {
        return (map.getDroides().length > 0) && (time <= MAX_TIME);
    }

    public static void results() {
        int initBots = map.getInitialDroids();
        int finalBots = map.getDroides().length;
        int botdeads = initBots - finalBots;
        int hits = map.getHits();
        int miss = map.getMiss();
        float percent = (float)hits/((float)(miss+hits)) * 100;

        System.out.println("bots iniciales:" + initBots + "\n" +
                "bots finales:" + finalBots + "\n" +
                "bots muertos:" + botdeads + "\n" +
                "disparos acertados:" + hits + "\n" +
                "disparos fallados:" + miss + "\n" +
                "porcentage de acirto:" + percent);
    }
}
