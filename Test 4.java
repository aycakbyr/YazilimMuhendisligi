/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject7;

import java.util.ArrayList;

/**
 *
 * @author gurhan
 */

public class Test {

// Parametre olarak integer bir dizi alan ve dizideki tek sayıların 
//ortalamasını bulur,
    public static int [] tekSayiDizisi(int [] numbers){
        int sayac=0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]%2==1)
                sayac++;
        }
        int [] tekSayilar=new int[sayac];
        int index=0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]%2==1){
                tekSayilar[index++]=numbers[i];
            }
        }
        return tekSayilar;
    }
    public static double tekOrtalama(int [] numbers){
        int toplam=0;
        int sayac=0;
        double average;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]%2==1){
                toplam+=numbers[i];
                sayac++;
            }
        }
        average=(double)toplam/sayac;
        return average;
        //return (double)toplam/sayac;
        
    }
    
    public static int toplam(int [] numbers){
        int result=0;
        for (int i = 0; i < numbers.length; i++) {
            result=result+numbers[i];
        }
        numbers[0]=100;
        return result;
        
    }
    public static int [][] matrixToplam(int [][] m1, int[][]m2){
        int [][] result=new int[m1.length][m1[0].length];
        if(m1.length==m2.length&& m1[0].length==m2[0].length){
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[i].length; j++) {
                    result[i][j]=m1[i][j]+m2[i][j];
                }
            }
        }
        return result;
    }
    public static int findMin(ArrayList<Integer> list){
        int min=list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)<min)
                min=list.get(i);
        }
        return min;
    }
    public static int findMinIndex(ArrayList<Integer> list){
        
        int minIndex=0;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)<list.get(minIndex)){
                minIndex=i;
            }
        }
        return minIndex;
    }
    public static int toplam(int [][] matris){
        int sonuc=0;
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                sonuc+=matris[i][j];
            }
        }
        return sonuc;
    }
    public static int powerN(int number, int power){
        if(power==0){
            return 1;
        }else{
            return number*powerN(number, power-1);
        }
    }
    public static int karakterSayisi(String str, Character aranan){
        int count=0;
        //Character c=str.charAt(0);//0 ıncı indexteki karakteri verir
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==aranan)
                count++;
        }
        
        return count;
    }
    public static int karakterSayisiSubstring(String str, Character aranan){
        int count=0;
        //Character c=str.charAt(0);//0 ıncı indexteki karakteri verir
        for (int i = 0; i < str.length(); i++) {
            if(str.substring(i, i+1).equals(aranan.toString()))
                count++;
        }
        
        return count;
    }
    public void method(){
        System.out.println("hello");
        System.out.println(karakterSayisiSubstring("asdsdasd", 'o'));
        
    }
    public static void main(String[] args) {
        
        
        
//        String ss="";
//        String s="hello world";
//        System.out.println(s.substring(6,8));
//        System.out.println(karakterSayisiSubstring(s, 'o'));
//        String yeni=s.replace('l', 'L');
//        System.out.println(s);
//        System.out.println(yeni);
//        System.out.println(karakterSayisi("asdasdfasesaease", 'z'));
//        Circle c1=new Circle();
//        Circle c2=new Circle(2,3,4);
//        System.out.println(c2);
//        System.out.println(c1.distance(c2));
//        
//        CircleOld c1=new CircleOld(5,3,4);
//        CircleOld c2=new CircleOld(2,6,9);
//        System.out.println(c1.toString());
//        System.out.println(c1.distance(new CircleOld()));
//        System.out.println(c1.distance(c2));
//        System.out.println(c1.distance(null));//null pointer exception
//        ArrayList<Integer> numbers=new ArrayList<Integer>();
//        numbers.add(4);
//        numbers.add(6);
//        numbers.add(2);
//        numbers.add(3);
//        
//        //numbers.add(0,2);
//        //numbers.remove(2);
//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.println(numbers.get(i));
//        }
//        
//        
//        
//        int [][] matrix1=new int[2][3];
//        int [][] matrix2={{1,2,3},{4,5,6}};
//        int [][] multi=matrixToplam(matrix1, matrix2);
//        
////        int [][] multi={{1,2}, {0,1,2,3},{4,5,6}};
//        //System.out.println(multi[0][1]);
//        for (int i = 0; i < multi.length; i++) {
//            for (int j = 0; j < multi[i].length; j++) {
//                System.out.print(multi[i][j]);
//            }
//            System.out.println("");
////            
////            
//        }
        
//        RationalNumber r1=new RationalNumber();
//        RationalNumber r2=new RationalNumber(3,5);
//        
//        RationalNumber []numbers=new RationalNumber[4];
//        numbers[0]=r1;
//        numbers[1]=r2;
//        numbers[2]=new RationalNumber(1,2);
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
//        }
//        RationalNumber r3=numbers[1].add(numbers[2]);
//        System.out.println(r3);
        //numbers[3].nominator=5; null pointer exception verir.
        
        
//        System.out.println(r1);
//        System.out.println(r2);
//        RationalNumber r3=r2;
//        System.out.println(r3);
//        r3.nominator=1;
//        System.out.println(r3);
//        System.out.println(r2);
//        
//String s=r1.toString();
        //System.out.println(s);
//        System.out.println(r2);
//        System.out.println(r1.toString());
//        System.out.println(r1.multiply(r2));
//        RationalNumber r3=r1.multiply(r2);
//        System.out.println(r3);
//        RationalNumber r4=r1.add(r3);
//        System.out.println(r4);
//        RationalNumber r5=r2.add(new RationalNumber(4,6));
//        System.out.println(r5.toString());
//        System.out.println();
//        
//        Point p1=new Point();
//        //System.out.println(p1.x);
//        //System.out.println(p1.y);
//        p1.display();
//        System.out.println(p1.distanceToCenter());
//        Point p2=new Point(-3,4);
//        p2.display();
//        System.out.println(p2.distanceToCenter());
//        //System.out.println(p1.distanceToAnotherPoint(p2.x, p2.y));
//        System.out.println(p1.distanceToAnotherPoint(p2));
//        //p2.setX(-12);
//        System.out.println(p2.getX());
//        
//        int [] values={1,2,3,4};
//        int sonuc=toplam(values);
//        System.out.println(sonuc);
//        System.out.println(values[0]);
//        int [] values={1,3,5,2};
//        int x=values[1];
//        System.out.println(x);
//        values[1]=8;
//        System.out.println(x);
//        for (int i = 0; i < values.length; i++) {
//            System.out.println(values[i]);
//        }
//        int [] numbers= new int [3];
//        System.out.println(numbers.length);
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
//        }
//        
//        numbers=values;
//        System.out.println(numbers.length);
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
//        }
//        values[2]=9;
//        System.out.println(numbers[2]);
//        
    }
}























