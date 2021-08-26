package com.example.simpleconverter;

public class utils {
    public static String decToFrac(double x, int d) {
        //pass it a number in decimal and it will convert it to the nearest fraction with d as the denominator
        //d > 0
        String r = Integer.toString((int) x) + "";
        double err = 1 / (d * 2.0); //err is halfway between units
        x = x - (int) x;
        int i = 0;
        while (x > err && x > 0) {
            i++;
            x = x - (1.0 / d);
        }
        r = r + " " + Integer.toString(i) + "/" + Integer.toString(d);
        return r;
    }
}
