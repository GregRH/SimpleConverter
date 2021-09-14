package com.example.simpleconverter;

public abstract class Shape {
    protected double sides[];
    protected double angles[];
    public double[] getSide(){
        return sides;
    }
    public double[] getAngle(){
        return angles;
    }
    public double getSide(int side){
        return sides[side];
    }
    public double getAngle(int angle){
        return angles[angle];
    }
    public void setAngle(int i, double a){
        angles[i]=a;
    }
    public void setSides(int i, double s){//todo change to side
        sides[i]=s;
    }
    public abstract String getShape();
    public abstract double getArea();
    public double getPerimiter(){
        double per = 0;
        for (double i:sides
             ) {
            per+=i;
        }
        return per;
    }
    public String toString(){//todo consider changing to letters for sides and angles side 1 -> side a angle 1 -> angle A
        int j = 1;
        String ret = this.getShape()+": Side "+j;
        for (double i:sides
             ) {
            j++;
            ret+=" Side "+j+" "+i;
        }
        j=1;
        ret+=" Angle "+j;
        for (double i:angles
             ) {
            j++;
            ret+=" Angle "+j+" "+i;
        }
        return ret;
    }
}
