package com.example.simpleconverter;
import java.lang.Math;
public class utils {
    public static String decToFrac(double input, int d) {
        //pass it a number in decimal and it will convert it to the nearest fraction with d as the denominator
        //d > 0
        String r = Integer.toString((int) input);
        double x = input;
        double err = 1 / (d * 2.0); //err is halfway between units
        x = x - (int) x;
        int i = 0;
        while (x > err && x > 0) {
            i++;
            x = x - (1.0 / d);
        }
        String reduced = reduceFrac(i,d);
        if(reduced.toCharArray()[0]=='1'&&reduced.toCharArray()[2]=='1'&&reduced.length()==3)
            //if 1/1 add one
            r=Integer.toString((int) input+1);
        else if(reduced.toCharArray()[0]!='0')
            //if not 0/x add the fraction
            r = r + " " + reduced;
        return r;
    }
    public static String reduceFrac(String frac){
        int numerator=0;
        int denominator=0;
        int slash_pos=0;
        for(int i = 0; i<frac.length();i++){
            //find numerator
            if(frac.toCharArray()[i]=='/'){
                slash_pos=i;
                break;
            }
            numerator*=10;
            numerator+=frac.toCharArray()[i]-48;
        }
        for(int i = slash_pos+1; i<frac.length();i++){
            //find denominator
            denominator*=10;
            denominator+=frac.toCharArray()[i]-48;
        }
        return reduceFrac(numerator,denominator);
    }
    public static String reduceFrac(int numerator, int denominator){
        int x=2;
        try {
            while((numerator&1)==0&&(denominator&1)==0){//Even numbers only
                //x=2;
                numerator=numerator/x;
                denominator=denominator/x;
            }
        	/*while(denominator%numerator==0 && numerator>1&&x!=1){
        		x=denominator/numerator;
        		numerator=numerator/x;
        		denominator=denominator/x;
        	}*/
        }catch (Exception e) {
            //you probably divided by 0
        }
        return Integer.toString(numerator)+"/"+Integer.toString(denominator);
    }
    public static boolean isRightTriangle(Triangle a){
        //Check sides, valid if pythagorean theorem
        //Check angles, valid if both angles input and equal 90
        if(a.getAngleA()+a.getAngleB()!=90)
            return false;
        double sum = a.getSide_a()*a.getSide_a()+a.getSide_b()*a.getSide_b();
        double err = 1/16;
        if(Math.abs((a.getSide_c()*a.getSide_c())-sum)>err){
            return false;
        }
        return true;
    }
    public static void calculateAngles(Triangle a){
        if (a.getAngleA()>0) {
            a.setAngleB(90 - a.getAngleA());
        }
        else if (a.getAngleB()>0) {
            a.setAngleA(90 - a.getAngleB());
        }
        else if (a.getSide_a()>0 && a.getSide_b()>0){
            a.setAngleA(Math.toDegrees(Math.atan(a.getSide_a()/a.getSide_b())));
            a.setAngleB(Math.toDegrees(Math.atan(a.getSide_b()/a.getSide_a())));
        }
        else if (a.getSide_a()>0 && a.getSide_c()>0){
            a.setAngleA(Math.toDegrees(Math.asin (a.getSide_a()/a.getSide_c())));
            a.setAngleB(Math.toDegrees(Math.acos (a.getSide_a()/a.getSide_c())));
        }
        else if (a.getSide_b()>0 && a.getSide_c()>0){
            a.setAngleA(Math.toDegrees(Math.acos (a.getSide_b()/a.getSide_c())));
            a.setAngleB(Math.toDegrees(Math.asin (a.getSide_b()/a.getSide_c())));
        }
       /* if (a.getAngleA()>0 && a.getAngleB()>0){
            //all angles calculated
        }
        else {
            //not enough information
        }*/
    }
    public static void calculateSides(Triangle a){
        if (a.getSide_a()>0){
           a.setSide_b(a.getSide_a() / Math.tan(Math.toRadians(a.getAngleA())));
            a.setSide_c(a.getSide_a() / Math.sin(Math.toRadians(a.getAngleA())));
        }
        else if (a.getSide_b()>0){
            a.setSide_a(a.getSide_b() / Math.tan(Math.toRadians(a.getAngleB())));
            a.setSide_c(a.getSide_b() / Math.sin(Math.toRadians(a.getAngleB())));
        }

        else if (a.getSide_c()>0){
            a.setSide_a(a.getSide_c() * Math.sin(Math.toRadians(a.getAngleA())));
            a.setSide_b(a.getSide_c() * Math.cos(Math.toRadians(a.getAngleA())));
        }
        if (a.getSide_a()>0 && a.getSide_b()>0 && a.getSide_c()>0){

        }
        else {
            //Not enough information
        }
    }
}
