/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject7;

public class CircleOld {
    public int x,y;
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
    
    public CircleOld(){
        //this.x=this.y=0; bu satır olsa da olmasa da 0 atanır
        this.r=1;
    }
    public CircleOld(int r, int x, int y){
        this.x=x;
        this.y=y;
        setR(r);
    }
    
    public double distance(CircleOld c){
        return Math.sqrt(Math.pow((this.x-c.x),2)+ 
                           Math.pow((this.y-c.y), 2));
    }
    
    
    public double area(){
        return Math.PI*this.r*this.r;
    }
    public double perimeter(){
        return 2*Math.PI*this.r;
    }
    public String toString(){
        return "merkez koordinatları...("+this.x +"," + this.y +") \n"
                + "yarıçapı...:" +this.r +"\n"
                + "alanı....:" +this.area() + "\n"
                + "çevresi...:" + this.perimeter();
        
                
        
    }
    
    
    
    
    
    
}












