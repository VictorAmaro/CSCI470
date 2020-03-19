package democalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/* Starter GUI program */

public class Calculator extends JPanel implements ActionListener {
    private JTextField xfield, yfield;
    private JLabel result;
    private JButton subtractButton;
    private JButton divideButton;
    private JButton addButton;
    private JButton timesButton;
    private JButton clearButton;
    private JPanel xpanel;
    private JPanel full = new JPanel();  //combo of all panels
    
    ButtonGroup group;
    
    public Calculator() {      
        xpanel = new JPanel();
        xpanel.setLayout(new GridLayout(3,2));

        xpanel.add(new JLabel("x:", SwingConstants.RIGHT));
        xfield = new JTextField("0", 5);
        xpanel.add(xfield);

        xpanel.add(new JLabel("y:", SwingConstants.RIGHT));
        yfield = new JTextField("0", 5);
        xpanel.add(yfield);

        xpanel.add(new JLabel("Result:"));
        result = new JLabel("0");
        xpanel.add(result);
        
        full.add(xpanel, BorderLayout.NORTH);   //Stick input/answer panel into one
        
        /***********************************************************************
         *********************************************************************** 
         **********************************************************************/
        
        JPanel southPanel = new JPanel();                      //New panel for the artimatic buttons
        southPanel.setBorder(BorderFactory.createEtchedBorder());
        
        timesButton = new JButton("Multiplication");           //create buttons and add them to the south panel
        southPanel.add(timesButton);
        timesButton.addActionListener(this);

        subtractButton = new JButton("Subtract");
        southPanel.add(subtractButton);
        subtractButton.addActionListener(this);

        divideButton = new JButton("Division");
        southPanel.add(divideButton);
        divideButton.addActionListener(this);
        
        addButton = new JButton("Addition");
        southPanel.add(addButton);
        addButton.addActionListener(this);
        
        clearButton = new JButton("Clear");
        southPanel.add(clearButton);
        clearButton.addActionListener(this);

        full.add(southPanel, BorderLayout.SOUTH);            //add south panel to the full panel
        
        Font thisFont = result.getFont();                                       //Get current font
        result.setFont(thisFont.deriveFont(thisFont.getStyle() ^ Font.BOLD));   //Make the result bold
        result.setForeground(Color.red);                                        //Male the result answer red in color
        result.setBackground(Color.yellow);                                     //Make result background yellow
        result.setOpaque(true);
  }
    
    /*****************************
     * getPanel()
     * returns the full panel
     * @return full
     ****************************/
    public JPanel getPanel() {
        return full;
    }

    /**
     * clear()
     * Resets the x and y field to 0 after invalid integers were input
     */
    public void clear() {
        xfield.setText("0");
        yfield.setText("0");
    }

    @Override
    public void actionPerformed(ActionEvent event) { 
        String xText = xfield.getText();                        //Get the JLabel fiels and set them to strings
        String yText = yfield.getText();
        
        int xVal;
        int yVal;
        
        if(event.getSource().equals(clearButton)) {
            clear();
            result.setText("0");
            return ; 
        }

        try {
            xVal = Integer.parseInt(xText);                     //Set global var xVal to incoming string
            yVal = Integer.parseInt(yText);                     //Set global var yVal to incoming string
        }
        catch (NumberFormatException e) {                       //xVal or yVal werent valid integers, print message and don't continue
            result.setText("ERROR");
            clear();
            return ;
        } 
        
        if(event.getSource().equals(timesButton)) {             //Button pressed was multiply
            result.setText(Integer.toString(xVal*yVal)); 
        }
        else if(event.getSource().equals(divideButton)) {       //Button pressed was division
            if(yVal == 0) {                                    //Is the yVal (bottom number) 0?
                result.setForeground(Color.red);               //Yes it is, print message
                result.setText("CAN'T DIVIDE BY ZERO!");
                clear();
            }
            else          
                result.setText(Integer.toString(xVal/yVal));  //No it's not, do the math
        }
        else if(event.getSource().equals(subtractButton)) {    //Button pressed was subtraction                                          
            result.setText(Integer.toString(xVal-yVal)); 
        }
        else if(event.getSource().equals(addButton)) {        //Button pressed was addition
            result.setText(Integer.toString(xVal+yVal)); 
        }
    }
}