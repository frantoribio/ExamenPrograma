package com.company.Utils;

import java.util.Scanner;

public class Utils {

    public static int randomNum(int min, int max){
        return (int)(Math.random()* (max - min + 1))+ min;
    }

    public static int tryNextInt(int min, int max){
        Scanner sc = new Scanner(System.in);
        int answer = min-1;

        while (answer < min || answer > max) {
            try {
                answer = sc.nextInt();
            } catch (Exception e) {
                System.out.println("not in range");
                sc.nextLine();
            }
        }

        return answer * 1000;
    }
}
