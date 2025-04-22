/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject7;

/**
 *
 * @author gurha
 */
public class Point {
    private int x;
    public int y;
    //default constructor
    public Point(){
        this.x=0;
        this.y=0;
    }
    public int getX(){
        return this.x;
    }
    public void setX(int xCoord){
        if(xCoord>=0)
            this.x=xCoord;
    }
    
    //parametreli constructor
    public Point(int xCoord, int yCoord){
        //this.x=xCoord;
        setX(xCoord);
        this.y=yCoord;
    }
    
    public void display(){
        System.out.println("(" +this.x +","+this.y+")");    
    }
    public String toString(){
        return "(" +this.x +","+this.y+")";
    }
    public double distanceToCenter(){
        return Math.sqrt((this.x-0)*(this.x-0)+Math.pow((this.y-0),2) );
        
    }
    public double distanceToAnotherPoint(int xCoord, int yCoord){
        return Math.sqrt((this.x-xCoord)*(this.x-xCoord)+
                        Math.pow((this.y-yCoord),2) );
    }
    public double distanceToAnotherPoint(Point p){
        return Math.sqrt((this.x-p.x)*(this.x-p.x)+
                        Math.pow((this.y-p.y),2) );
    }
    
    
    
}













