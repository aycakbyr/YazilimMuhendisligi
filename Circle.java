/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject7;

public class Circle {
    public Point center;
    private int r;

    public int getR() {
        return r;
    }
    public void setR(int r) {
        if(r>0)
            this.r = r;
        else
            this.r=1;
    }
    
    public Circle(){
        //this.x=this.y=0; bu satır olsa da olmasa da 0 atanır
        this.r=1;
        center=new Point();
    }
    public Circle(int r, int x, int y){
        //this.x=x;
        //this.y=y;
        center=new Point(x,y);
        setR(r);
    }
    public Circle(int r, Point p){
        //this.x=x;
        //this.y=y;
        center=new Point(p.getX(), p.y);
        setR(r);
    }
    public double distance(Circle c){
        return this.center.distanceToAnotherPoint(c.center);
    }
    
    
    public double area(){
        return Math.PI*this.r*this.r;
    }
    public double perimeter(){
        return 2*Math.PI*this.r;
    }
    public String toString(){
        return "merkez koordinatları..."+this.center.toString()+ "\n"
                + "yarıçapı...:" +this.r +"\n"
                + "alanı....:" +this.area() + "\n"
                + "çevresi...:" + this.perimeter();
        
                
        
    }
    
    
    
}
