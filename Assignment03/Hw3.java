//package hw3;

/*********************************************************
Class:     CSCI 470-1
Program:   Assignment 3
Author:    Victor Amaro
Z-number:  z1747708
Date Due:  10/18/2017

Purpose: Numerology - assigning a numerical value to a string based on values assigned to the 
  individual letters according to a variety of rules.
  
For each string, do a computation, which comes from Leo Tolstoy’s War and Peace (2/e, book III, part 1, ch. 19). 
    Give a value to each letter in the string.

Execution:
    java Hw3 "Some String" "another string" "some more strings"

Notes:     
    None
**********************************************************/

public class Hw3 {
    public static void main(String[] args) {
        DataTable table = new DataTable();
        int totalLetters = 0;
        
        System.out.println("Parm   Length   Total   String");  //Header Message
        System.out.println("----   ------   -----   ------");
        
        if(args.length == 0) {
            System.out.println("No arguments passed! Exiting....");
            System.exit(0);
        }
        
        for(int i = 0; i < args.length; i++) {                //Loop til no args left
            table.setString(args[i]);
            System.out.printf("%4s%9s%8s %20s%n", (i+1), (table.processLength()), (table.processTotal()), (table.getString()) );

            totalLetters += table.processLetters();            //Running total of all letters
        }
        System.out.printf("%n");
        table.printLetterTotals();                             //Print out alphabet with their frequency 
        
        System.out.printf("%n%s %d %n", "Total letters = ",  totalLetters);    //Print total letters in all args
    }
}
