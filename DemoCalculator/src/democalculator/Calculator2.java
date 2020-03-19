package democalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/* Starter GUI program */

public class Calculator2 extends JPanel implements ActionListener {
    private JTextField xfield, yfield;
    private JLabel result;
    private JPanel xpanel;
    private JPanel full = new JPanel();  //combo of all panels
    
    String[] mathStrings = { "Multiply", "Subtraction", "Division", "Addition"};  //Options for drop down menu
    JComboBox mathList = new JComboBox(mathStrings);                              //Create drop down menu and fill it
    JCheckBox newCheckBox;
    
    public Calculator2() {      
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
        
        full.add(xpanel, BorderLayout.NORTH);              //add answer/input panel into one
        
        /***********************************************************************
         *********************************************************************** 
         **********************************************************************/
        
        JPanel southPanel = new JPanel();                      //New panel for the drop down menu
        southPanel.setBorder(BorderFactory.createEtchedBorder());

        newCheckBox = new JCheckBox("Show My Answer In Floating Point Format");  //Check box to allow user to view answer in floating point
        southPanel.add(newCheckBox);
        
        southPanel.add(mathList);
        mathList.addActionListener(this);

        full.add(southPanel, BorderLayout.SOUTH);           //add south panel to full panel
        
        Font thisFont = result.getFont();                                       //Get current font
        result.setFont(thisFont.deriveFont(thisFont.getStyle() ^ Font.BOLD));   //Make the result bold
        result.setForeground(Color.red);                                        //Male the result answer red in color
        result.setBackground(Color.yellow);                                     //Make result background yellow
        result.setOpaque(true);
    }
    
    /**
     * clear()
     * Resets the x and y field to 0 after invalid integers were input
     */
    public void clear() {
        xfield.setText("0");
        yfield.setText("0");
    }
    
    /*****************
     * getPanel()
     * returns the full panel
     * 
     * @return full
     ****************/
    public JPanel getPanel(){
        return full;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) { 
        String xText = xfield.getText();                        //Get the JLabel fiels and set them to strings
        String yText = yfield.getText();
        
        int xVal;
        int yVal;
        
        try {
            xVal = Integer.parseInt(xText);                     //Set global var xVal to incoming string
            yVal = Integer.parseInt(yText);                     //Set global var yVal to incoming string
        }
        catch (NumberFormatException e) {                       //xVal or yVal werent valid integers, print message and don't continue
            result.setText("ERROR");
            clear();
            return ;
        } 
        
        JComboBox comboSource = (JComboBox)event.getSource();   //Get the item picked from the drop down menu
        String selectedItem = (String)comboSource.getSelectedItem(); 

        if(newCheckBox.isSelected() == false) {                 //Float or int answer?
            if(selectedItem.equalsIgnoreCase("Multiply")) {                  //multiply selected
                result.setText(Integer.toString(xVal*yVal)); 
            }
            else if(selectedItem.equalsIgnoreCase("Division")) {            //division selected
                if(yVal == 0) {                                   //Is the yVal (bottom number) 0?
                    result.setForeground(Color.red);              //Yes it is, print message
                    result.setText("CAN'T DIVIDE BY ZERO!");
                    clear();
                }
                else          
                    result.setText(Integer.toString(xVal/yVal));  //No it's not, do the math
            }
            else if(selectedItem.equalsIgnoreCase("Subtraction")) {        //subtraction selected                                         
                result.setText(Integer.toString(xVal-yVal)); 
            }
            else if(selectedItem.equalsIgnoreCase("Addition")) {           //addition selected
                result.setText(Integer.toString(xVal+yVal)); 
            }
        }
        else {
            float xVal2 = xVal;                                            //Change to float
            float yVal2 = yVal;      
            
            if(selectedItem.equalsIgnoreCase("Multiply")) {                  //multiply selected
                result.setText(Float.toString(xVal*yVal)); 
            }
            else if(selectedItem.equalsIgnoreCase("Division")) {            //division selected
                if(yVal == 0) {                                   //Is the yVal (bottom number) 0?
                    result.setForeground(Color.red);              //Yes it is, print message
                    result.setText("CAN'T DIVIDE BY ZERO!");
                    clear();
                }
                else          
                    result.setText(Float.toString(xVal2/yVal2));  //No it's not, do the math
            }
            else if(selectedItem.equalsIgnoreCase("Subtraction")) {        //subtraction selected                                         
                result.setText(Float.toString(xVal-yVal)); 
            }
            else if(selectedItem.equalsIgnoreCase("Addition")) {           //addition selected
                result.setText(Float.toString(xVal+yVal));
            }
        }
    }
}