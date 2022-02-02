package com.company.Creator;

import com.company.Models.Droide;
import com.company.Models.TipoDroide;
import com.company.Utils.Utils;

public class DroideCreator {

    public static Droide random(){
        Droide d;
        int rNum = Utils.randomNum(0,100);
        if(rNum < 30){
            d = new Droide(50, TipoDroide.SW348);
        } else if(rNum < 80){
            d = new Droide(100, TipoDroide.SW447);
        } else {
            int energy = Utils.randomNum(100,150);
            d = new Droide(energy, TipoDroide.SW4421);
        }
        return d;
    }
}
