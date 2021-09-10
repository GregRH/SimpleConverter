package com.example.simpleconverter;

public class Triangle extends Shape {
    public final int side_a =0;
    public final int side_b=1;
    public final int side_c=2;
    public final int angle_A=0;
    public final int angle_B=1;
    public final int angle_C=2;
    public Triangle(double a,double b,double c,double A, double B, double C){
        sides = new double[3];
        angles = new double[3];
        sides[0]=a;
        sides[1]=b;
        sides[2]=c;
        angles[0]=A;
        angles[1]=B;
        angles[2]=C;

    }
    public Triangle(double s[], double a[]){
        sides = new double[3];
        angles = new double[3];
        for (int i = 0; i<sides.length;i++){//zero out arrays
            sides[i]=0;
            angles[i]=0;
        }
        if(s.length>=3&&a.length>=3)
            for (int i = 0; i<sides.length;i++){
                sides[i]=s[i];
                angles[i]=a[i];
            }
        else{
            for (int i = 0; i<s.length;i++){
                sides[i]=s[i];
            }
            for (int i = 0; i<a.length;i++){
                angles[i]=a[i];
            }
        }

    }
    public Triangle(double s[]) {
        sides = new double[3];
        angles = new double[3];
        for (int i = 0; i < sides.length; i++) {//zero out arrays
            sides[i] = 0;
            angles[i] = 0;
        }
        for(int i =0; (i<s.length)&&i<3;i++) {
            sides[i] = s[i];
        }
        for(int i = 3;(i<s.length)&&i-3<3;i++){
            angles[i-3]=s[i];
        }
    }
    public Triangle(){
        this(0,0,0,0,0,0);
    }
    @Override
    public String getShape() {
        return "Triangle";
    }

    @Override
    public double getArea() {//todo add function
        return 0;
    }
}
