package democalculator;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*********************************************************
Class:     CSCI 470-1
Program:   Assignment 5
Author:    Victor Amaro
Z-number:  z1747708
Date Due:  12/08/2017

Purpose: 
    Create 3 different calculator objects, and display them in a single frame and make a menu

Execution:
    -

Notes:     
    None
**********************************************************/
public class Hw5 {
    public static void main(String[] args) {
        JPanel calcP, calcP2, calcP3 = new JPanel();      //Panels for calculator objects
        
        JFrame top = new JFrame();                        //create grid layout frame to put panels
        top.setLayout(new GridLayout(0,3));
        top.setSize(1900,300);
        top.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        top.setJMenuBar(new Menu().getMenu());           //Get the menu
        top.add(calcP = new Calculator().getPanel());    //add each object to own panel in frame
        top.add(calcP2 = new Calculator2().getPanel());
        top.add(calcP3 = new Calculator3().getPanel());
        
        top.setVisible(true);   
    }
}