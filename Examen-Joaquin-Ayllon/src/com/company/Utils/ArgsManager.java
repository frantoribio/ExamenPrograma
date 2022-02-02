package com.company.Utils;

public class ArgsManager {

    public static int[] get(String[] args){

        if(args.length != 2){
            throw new IllegalArgumentException("Not allowed argument");
        }
        return new int[] {colNum(args[0]), botNum(args[1])};
    }

    public static int botNum(String arg){
        int num = Integer.parseInt(arg);

        if(num < 5 || num > 30){
            throw new IllegalArgumentException("Not allowed argument");
        }
        return num;
    }

    public static int colNum(String arg){
        int num = Integer.parseInt(arg);

        if(num < 5 || num > 9){
            throw new IllegalArgumentException("Not allowed argument");
        }
        return num;
    }
}
