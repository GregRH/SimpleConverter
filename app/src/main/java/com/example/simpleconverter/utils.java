package com.example.simpleconverter;
import android.util.Log;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Math;
public class utils {
    public static boolean checkValidinput(String text){
        //valid if input is mixed number formated as number 'space' numerator'/'denominator or number'.'number
        Pattern p1 =  Pattern.compile("^[0-9]+\\s[0-9]+/[0-9]+$");//Fraction
        Pattern p2 = Pattern.compile("^[0-9]*\\.[0-9]+$");//Decimal
        Pattern p3 = Pattern.compile("^[0-9]+$");//just a number
        Matcher m = p1.matcher(text);
        boolean rtrn = m.find();
        Log.d("patern1",Boolean.toString(rtrn));
        if (!rtrn){
            m = p2.matcher(text);
            rtrn = m.find();
            Log.d("patern2",Boolean.toString(rtrn));
            if(!rtrn){
                m=p3.matcher(text);
                rtrn = m.find();
                Log.d("pattern3",Boolean.toString(rtrn));
            }
        }
        return rtrn;
    }
    public static boolean isFrac(String text){
        if(checkValidinput(text))
            for(int i = 0; i<text.length();i++)
                if(text.toCharArray()[i]=='/')
                    return true;
        return false;
    }
    public static String decToFrac(double input, int d,boolean reduce) {
        //pass it a number in decimal and it will convert it to the nearest fraction with d as the denominator
        //d > 0
        String r = Integer.toString((int) input);
        String reduced;
        double x = input;
        double err = 1 / (d * 2.0); //err is halfway between units
        x = x - (int) x;
        int i = 0;
        while (x > err && x > 0) {
            i++;
            x = x - (1.0 / d);
        }
        if (reduce == true) {
            reduced = reduceFrac(i, d);//Reducing is optional
        }
        else
            reduced = ""+i+"/"+d;
        if (reduced.toCharArray()[0] == '1' && reduced.toCharArray()[2] == '1' && reduced.length() == 3)
            //if 1/1 add one to the whole number instead of the fraction
            r = Integer.toString((int) input + 1);
        else if (reduced.toCharArray()[0] != '0')
            //if not 0/x add the fraction to the whole number
            r = r + " " + reduced;
        if(r.toCharArray()[0]=='0')
            //if the number is less than 1 only use the fraction
            r=reduced;
        return r;
    }
    public static String decToFrac(double input, int d) {
        return decToFrac(input,d,true);//TODO function to preserve old functionality, remove eventually
    }
    public static double fracToDouble(String f){
        //TODO add support for only whole numbers(just return f)
        //TODO add support for fractions without whole numbers, ie less than 1 or improper fractions
        double result=0;
        int space=0,slash=0;
        double numerator=0;
        double denominator=0;
        for(int i =0;i<f.length();i++){
            //finds whole number
            if(f.toCharArray()[i]!=' '){
                result*=10;
                result+=f.toCharArray()[i]-48;
               // Log.d("fracToDouble whole number",Double.toString(result));
            }
            else {
                space=i;
                break;
            }
        }
        for(int i = space+1; i<f.length();i++){
            //find numerator
            if(f.toCharArray()[i]=='/'){
                slash=i;
                break;
            }
            numerator*=10;
            numerator+=f.toCharArray()[i]-48;
        }
        for(int i = slash+1; i<f.length();i++){
            //find denominator
            denominator*=10;
            denominator+=f.toCharArray()[i]-48;
        }
        //Log.d("WHAT",Double.toString(numerator));
        //Log.d("WHAT",Double.toString(denominator));
        return result+=numerator/denominator;
    }
    public static String reduceFrac(int numerator, int denominator){//TODO Add odd number support
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
    public static String reduceFrac(String frac){//utility accepts fraction as a string numerator/denominator
        //TODO change this to include mixed numbers
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

    //Todo Change these to the universal SSS SAS SSA AAS ASA, consider moving them to the triangle object instead
    /*
        SSS
            A=arccos((b^2+c^2-a^2)/2bc)
            B=arccos((a^2+c^2-b^2)/2ac)
        SAS(given aCb in this case)
            c=sqrt(a^2+b^2-2abcosC)
            A=arccos((b^2+c^2-a^2)/2bc)
            B=180-A-C
        SSA(in this case given bcB
            not always solvable
            works only if the adjacent side is shorter than the other
            D=(c/b)sinB
            D>1 not a triangle
            D=1 right triangle, works
            D<1 two possibilities
                b>=c then B>=C because no triangle can have two obtuse angles it must be unique
                b<c C maybe acute or obtuse therefore it is impossible to calculate
            sinC=(c/b)sinB
            A=180-C-B
            a=b*(sinA/sinB)
        ASA
            subtract angles from 180
            a=c(sinA/sinC)
            b=c(sinB/sinC)
        AAS
            same as ASA
     */
    public static boolean isRightTriangle(Triangle t){//TODO fix this, maybe remove?
        //Check sides, valid if pythagorean theorem
        //Check angles, valid if both angles input and equal 90
        int a,b,c,A,B;//Temp these should be final
        a=0;
        b=1;
        c=2;
        A=0;
        B=1;

        if(t.getAngle(A)+t.getAngle(B)!=90)
            return false;
        double sum = t.getSide(a)*t.getSide(a)+t.getSide(b)*t.getSide(b);
        double err = 1.0/64;
        if(Math.abs((t.getSide(c)*t.getSide(c))-sum)>err){
            return false;
        }
        return true;
    }
    public static void calculateAngles(Triangle t){//TODO consider making this a boolean to return success
        int a,b,c,A,B;//Temp these should be final
        a=0;
        b=1;
        c=2;
        A=0;
        B=1;
        if (t.getAngle(A)>0.0) {
            t.setAngle(B,90 - t.getAngle(A));
        }
        else if (t.getAngle(B)>0.0) {
            t.setAngle(A,90 - t.getAngle(B));
        }
        else if (t.getSide(a)>0.0 && t.getSide(b)>0.0){
            t.setAngle(A,Math.toDegrees(Math.atan(t.getSide(a)/t.getSide(b))));
            t.setAngle(B,Math.toDegrees(Math.atan(t.getSide(b)/t.getSide(a))));
        }
        else if (t.getSide(a)>0.0 && t.getSide(c)>0.0){
            t.setAngle(A,Math.toDegrees(Math.asin (t.getSide(a)/t.getSide(c))));
            t.setAngle(B,Math.toDegrees(Math.acos (t.getSide(a)/t.getSide(c))));
        }
        else if (t.getSide(b)>0.0 && t.getSide(c)>0.0){
            t.setAngle(A,Math.toDegrees(Math.acos (t.getSide(b)/t.getSide(c))));
            t.setAngle(B,Math.toDegrees(Math.asin (t.getSide(b)/t.getSide(c))));
        }
       /* if (t.getAngle(A)>0 && t.getAngle(B>0){
            //all angles calculated
        }
        else {
            //not enough information
        }*/
    }
    public static void calculateSides(Triangle t){//TODO consider making this a boolean to return success
        int a,b,c,A,B;//Temp these should be final
        a=0;
        b=1;
        c=2;
        A=0;
        B=1;
        if (t.getSide(a)>0){
           t.setSides(b,t.getSide(a) / Math.tan(Math.toRadians(t.getAngle(A))));
            t.setSides(c,t.getSide(a) / Math.sin(Math.toRadians(t.getAngle(A))));
        }
        else if (t.getSide(b)>0){
           t.setSides(a,t.getSide(b) / Math.tan(Math.toRadians(t.getAngle(B))));
            t.setSides(c,t.getSide(b) / Math.sin(Math.toRadians(t.getAngle(B))));
        }

        else if (t.getSide(c)>0){
            t.setSides(a,t.getSide(c) * Math.sin(Math.toRadians(t.getAngle(A))));
            t.setSides(b,t.getSide(c) * Math.cos(Math.toRadians(t.getAngle(A))));
        }
        if (t.getSide(a)>0 && t.getSide(b)>0 && t.getSide(c)>0){

        }
        else {
            //Not enough information
        }
    }
}
