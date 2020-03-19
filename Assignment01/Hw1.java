package Hw1;

/**********************************************************
Class:     CSCI 470-1
Program:   Assignment 1
Author:    Victor Amaro
Z-number:  z1747708
Date Due:  09/14/2017

Purpose: 
    Starts with the number 1000, then subtracts 1 from it until a number
        ending with 0 occurs, then go on to subtract 2 and continues the cycle until
        a subtraction would cause the number to become negative.

Execution:
    java hw1.java nnn
        If parm is omitted, 1000 is used.

Notes:     
    None
**********************************************************/
public class Hw1 {

    public static void main(String[] args) {
        int startingNumber;                                  //Starting number
        startingNumber = 0;
        
        int subtractionNumber;                               //Subraction number to 1 to begin with
        subtractionNumber = 1;                               
        
        int subtractionCount;                                //Used to keep track of how many subtractions have happend with current subtractionNumber
        subtractionCount = 0;
        
        int constStartingNumber;                             //An unchanged version of starting number
        constStartingNumber = 0;                  
        
        int numbersSpoken;                                   //Total count of subtractionCount
        numbersSpoken = 0;
        
        double answerResult;                                 //Used to store averages
        answerResult = 0.0;
        
        if(args.length == 0)                                 //User didn't enter any params, default is 1,000
            startingNumber = 1000;
        else                                                 //User set starting number
            startingNumber = Integer.parseInt(args[0]);
        
        constStartingNumber = startingNumber;                //Set the unchaged version og startingNumber
        
        System.out.println("Decrement    Current    Count"); //Print header
        System.out.printf("%20s%n", startingNumber);         //Print current starting number
        
        while(startingNumber > 0) {                          //While still positive
            startingNumber -= subtractionNumber;             //Subtract from the starting number
            subtractionCount++;                              //Add one to the subtractionCounter
            
            if((startingNumber % 10 == 0) || (startingNumber == 1)) {                                         //Does number end in 0 or is 1? 
                System.out.printf("%9s%11s%9s%s", subtractionNumber, startingNumber, subtractionCount, " ");  //Print current numbers formatted
                
                for(int starCount = 0; starCount < subtractionCount; starCount++)
                    System.out.print("*");                   //Print correct number of *'s for the subtraction count
                
                System.out.println();                        //New line
                
                numbersSpoken +=subtractionCount;            //Add subtractionCount to numbersSpoken running total
                subtractionCount = 0;                        //Reset the subtraction count
                subtractionNumber++;                         //Increase subtraction number by one
            }  
        }
      
        System.out.println();                                //New line
        System.out.println("There were " + numbersSpoken + " numbers spoken with " + (subtractionNumber - 1) + " different increments.");
        answerResult = (double)(numbersSpoken) / (double)(subtractionNumber - 1);              //Find average   
        System.out.printf("%s%.2f%2s%n", "There were an average of ", answerResult, " cycles per increment.");

        System.out.println();                                //New line
        
        System.out.println("There were " + constStartingNumber + " passed by with " + (subtractionNumber - 1) + " different increments.");
        answerResult = (double)(constStartingNumber) / (double)(subtractionNumber - 1) ;       //Find average
        System.out.printf("%s%.2f%2s%n", "There were an average of ", answerResult, " numbers per increment.");

        System.out.println();                                //New line
    }
}
