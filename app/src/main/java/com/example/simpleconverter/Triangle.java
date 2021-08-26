package com.example.simpleconverter;

public class Triangle {
    private double side_a,side_b,side_c;
    private double angleA, angleB,angleC;
    public Triangle(double a,double b,double c,double A, double B, double C){
        side_a=a;
        side_b=b;
        side_c=c;
        angleA=A;
        angleB=B;
        angleC=C;
    }
    public Triangle(){
        this(0,0,0,0,0,0);
    }
    public double getAngleA(){
        return angleA;
    }
    public double getAngleB(){
        return angleB;
    }
    public double getAngleC(){
        return angleC;
    }
    public double getSide_a(){
        return side_a;
    }
    public double getSide_b(){
        return side_b;
    }
    public double getSide_c(){
        return side_c;
    }
    public void setAngleA(double A){
        angleA=A;
    }
    public void setAngleB(double B){
        angleB=B;
    }
    public void setAngleC(double C){
        angleC=C;
    }
    public void setSide_a(double a){
        side_a=a;
    }
    public void setSide_b(double b){
        side_b=b;
    }
    public void setSide_c(double c){
        side_c=c;
    }
}
