package com.example.simpleconverter;
import java.lang.Math;
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
    public static String reducFrac(String frac){
        return "";
    }
    public static String reduceFrac(int numerator, int denominator){
        return "";
    }
    public static boolean isRightTriangle(Triangle a){
        //Check sides, valid if pythagorean theorem
        //Check angles, valid if both angles input and equal 90
        return false;
    }
    public static void calculateAngles(Triangle a){
        if (a.getAngleA()>0) {
            a.setAngleB(90 - a.getAngleA());
        }
        else if (a.getAngleB()>0) {
            a.setAngleA(90 - a.getAngleB());
        }
        else if (a.getSide_a()>0 && a.getSide_b()>0){
            a.setAngleA(Math.toDegrees(Math.atan (a.getSide_a()/a.getSide_b())));
            a.setAngleB(Math.toDegrees(Math.atan (a.getSide_b()/a.getSide_a())));
        }
        else if (a.getSide_a()>0 && a.getSide_c()>0){
            a.setAngleA(Math.toDegrees(Math.asin (a.getSide_a()/a.getSide_c())));
            a.setAngleB(Math.toDegrees(Math.acos (a.getSide_a()/a.getSide_c())));
        }
        else if (a.getSide_b()>0 && a.getSide_c()>0){
            a.setAngleA(Math.toDegrees(Math.acos (a.getSide_b()/a.getSide_c())));
            a.setAngleB(Math.toDegrees(Math.asin (a.getSide_b()/a.getSide_c())));
        }
        if (a.getAngleA()>0 && a.getAngleB()>0){
            //all angles calculated
        }
        else {
            //not enough information
        }
    }
    public static void calculateSides(Triangle a){

    }
}
