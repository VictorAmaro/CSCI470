/*********************************************************
Class:     CSCI 470-1
Program:   Assignment 2
Author:    Victor Amaro
Z-number:  z1747708
Date Due:  10/04/2017

Purpose: 
    implement a class Ratl that represents a rational number as two integers, 
        a numerator and a denominator

Execution:
    java Ratl

Notes:     
    None
**********************************************************/
//package Hw2;

public class Ratl {
    private int numerator;
    private int denominator; 
    
    /***********************
     Default constructor
     Sets the numerator to 0 and denominator to 1
    ***********************/
    public Ratl() {
        this.numerator = 0;
        this.denominator = 1;
    }
    
    /************************
     Alternate constructor
     Sets the numerator to the argument newNumerator and
      sets the denominator to the argument newDenominator 
      * 
      @param newNumerator
      @param newDenominator 
    ***********************/
    public Ratl(int newNumerator, int newDenominator) {
        this.numerator = newNumerator;
        this.denominator = newDenominator;
    }
    
    /************************
     Copy constructor
     Sets the numerator/denominator to the arguments numerator/denominator 
     * 
     @param newRatl 
    *************************/
    public Ratl(Ratl newRatl) {
        this.numerator = newRatl.numerator;
        this.denominator = newRatl.denominator;
    }
    
    /***********************
     toString
     * Converts the numerator/denominator to string and returns them
        in a 0/0 format
     * 
     * @return wholeFraction
    ************************/
    @Override
    public String toString() {
        if(getDenominator() == 1 )   //If denominator is 1, set the fraction to just the numerator
            return this.getNumerator() + "";
        else
            return this.getNumerator() + "/" + this.getDenominator();
    }
    
    /***********************
     getNumerator() 
     Returns the numerator
     * 
     @return numerator 
    ***********************/        
    public int getNumerator() {
        return this.numerator;
    }

    /***********************
     getDenominator() 
     Returns the denominator
     * 
     @return denominator
    ***********************/  
    public int getDenominator() {
        return this.denominator;
    }
    
    /***********************
     setNumerator()
     Sets the numerator to the argument newNumerator 
     * 
     @param newNumerator 
    ***********************/
    public void setNumerator(int newNumerator) {
        this.numerator = newNumerator;
    }
    
    /**********************
     setDenominator
     Sets the denominator to the argument newDenominator 
     * 
     * @param newDenominator 
    ***********************/
    public void setDenominator(int newDenominator) {
        this.denominator = newDenominator;
    }
    
    /************************
     reduce() 
     Reduces the numerator/denominator into their lowest forms 
    ************************/
    public void reduce(){
        int dividend = gcd(this.getNumerator(), this.getDenominator());  //Finds the dividend
        this.numerator /= dividend;
        this.denominator /= dividend; 
    }
    
    /**************************
     gcd() 
     Finds the gcd and returns it 
     * 
     * @param topNumber
     * @param bottomNumber
     * @return topNumber
    ****************************/
    public static int gcd(int topNumber, int bottomNumber){
        int remainder;
        
        while(bottomNumber != 0) {
            remainder = topNumber % bottomNumber;
            topNumber = bottomNumber;
            bottomNumber = remainder;
        }
        return topNumber;
    }
    
    /***********************
     add()
     Adds two objects of the Rational class and leaves in reduced form 
     * 
     * @param b 
    ************************/
    public void add(Ratl b) {
        int greatestDenominator = this.getDenominator() * b.getDenominator(); //Find greatest common denominator
        int x = greatestDenominator / b.getDenominator();
        int y = greatestDenominator / this.getDenominator();
        
        this.setDenominator(b.getDenominator() * this.getDenominator() );
        
        this.setNumerator((this.getNumerator() * y) + (b.getNumerator() * x) );
        
        this.reduce();    
    }

    /**********************
     sub()
     Subtracts two object of the Rational class and leaves in reduced form 
     * 
     * @param b 
    **********************/
    public void sub(Ratl b) {
        Ratl temp = new Ratl(negate(b));
        
        this.add(temp);
        
        this.reduce();
    }
    
    /***********************
     mutl()
     Multiplies two objects of the Rational class and leaves in reduced form 
     * 
     * @param b 
    ************************/
    public void mutl(Ratl b) {
        this.numerator *= b.getNumerator();
        this.denominator *= b.getDenominator();
        
        this.reduce();
    }
    
    /**********************
     div()
     Divides two objects of the Rational class and leaves in reduced form
     *
     * @param b 
    **********************/
    public void div(Ratl b) {
        Ratl temp = new Ratl(invert(b));
        
        this.mutl(temp);

        this.reduce();
    }
    
    /*************************
     negate()
     Negates the incoming Ratl object (5/4 -> -5/4)
     * 
     * @param a
     * @return Ratl
     *************************/
    public static Ratl negate(Ratl a) {
        int numerator = Math.abs(a.getNumerator()) * -1; //Find the abs val
        int denominator = a.getDenominator();
        
        return new Ratl(numerator, denominator); //New rational that is negated
    } 
    
    /********************
     invert()
     Inverts the incoming Ratl object (4/5 -> 5/4)
     * 
     * @param a
     * @return 
     *******************/
    public static Ratl invert(Ratl a) {
        Ratl temp = new Ratl(a.getDenominator(), a.getNumerator() ); //Invert
        
        return temp;
    }
    
    /*********************
     add()
     Adds to Ratl objects together 
     * 
     * @param a
     * @param b
     * @return temp
     ********************/
    public static Ratl add(Ratl a, Ratl b) {
        Ratl temp = new Ratl();
           
        int greatestDenominator = a.getDenominator() * b.getDenominator();
        int x = greatestDenominator / b.getDenominator();
        int y = greatestDenominator / a.getDenominator();
        
        temp.setDenominator(b.getDenominator() * a.getDenominator());
        
        temp.setNumerator((a.getNumerator() * y) + (b.getNumerator() * x));
        
        temp.reduce();
        
        return temp;
    }

    /***************
     sub()
     Subtracts two Ratl objects 
     * 
     * @param a
     * @param b
     * @return temp
     ****************/
    public static Ratl sub(Ratl a, Ratl b) {
        Ratl bNegate = new Ratl(negate(b));
        Ratl temp = new Ratl(add(a,bNegate));
        
        temp.reduce();
     
        return temp;
    }

    /***************
     mult()
     Multiplies two Ratl objects together 
     * 
     * @param a
     * @param b
     * @return temp 
     **************/
    public static Ratl mult(Ratl a, Ratl b) {
        Ratl temp = new Ratl();
        
        temp.setNumerator(a.getNumerator() * b.getNumerator());
        temp.setDenominator(a.getDenominator() * b.getDenominator());
        
        temp.reduce();
        
        return temp;
    }

    /*****************
     div()
     Divides two Ratl objects 
     * @param a
     * @param b
     * @return temp 
     *****************/
    public static Ratl div(Ratl a, Ratl b) {
        Ratl bNegate = new Ratl(invert(b));
        Ratl temp = new Ratl(mult(a, bNegate));
        
        temp.reduce();
        
        return temp;
    }

    /****************
     equiv()
     Tests for numerically equivalent values
     * 
     * @param a
     * @param b
     * @return true/false
     *****************/
    public static boolean equiv(Ratl a, Ratl b) {
        Ratl bTemp = new Ratl(b);
        Ratl aTemp = new Ratl(a);
        aTemp.reduce(); //reduce both fractions to lowest forms
        bTemp.reduce();
        
        return ( aTemp.getNumerator() == bTemp.getNumerator() && aTemp.getDenominator() == bTemp.getDenominator() ); //equal?
    }
    
     /****************
     equiv()
     Tests for numerically equivalent values
     * 
     * @param a
     * @return true/false
     *****************/
    public boolean equiv(Ratl a) {
        Ratl aTemp = new Ratl(a);
        Ratl thisTemp = new Ratl(this);
        
        aTemp.reduce(); //reduce both fractions to lowest form
        thisTemp.reduce();
        
        return ( thisTemp.getNumerator() == aTemp.getNumerator() && thisTemp.getDenominator() == aTemp.getDenominator() ); //equal?
    }
    
    /**********************
     ident()
     Tests if the fractions represented are identical
     * 
     * @param a
     * @return true/false 
     ********************/
    public boolean ident(Ratl a) {
        return ( getNumerator() == a.getNumerator() && getDenominator() == a.getDenominator() ); //are fractions the same?
    }

    /**********************
     ident()
     Tests if the fractions represented are identical
     * 
     * @param a
     * @param  b
     * @return true/false 
     ********************/    
    public static boolean ident(Ratl a, Ratl b) {
        return ( a.getNumerator() == b.getNumerator() && a.getDenominator() == b.getDenominator() );
    }
}
