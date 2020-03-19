package democalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu implements ActionListener {
    JMenuBar menuBar;                          //Menu bar and items
    JMenuItem about, name, project;
    
    public Menu() {     
        menuBar = new JMenuBar();
    
        about = new JMenu("About");           //Add an about menu to the menu bar
        menuBar.add(about);
        
        name = new JMenuItem("Name");         //add a name item to the menu
        name.addActionListener(this);
        about.add(name);
        
        project = new JMenuItem("Project");  //add a project item to the menu
        project.addActionListener(this);
        about.add(project);
    }
    
    
    /****************
     * getMenu()
     * Returns the menu
     * 
     * @return menuBar
     ****************/
    public JMenuBar getMenu() {
        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         if(ae.getActionCommand() == "Name") {                                 //Was name selected? Display my name
             javax.swing.JOptionPane.showMessageDialog(null, "Victor Amaro");
         }
         else {                                                                //Project was selected, display info on this project
             javax.swing.JOptionPane.showMessageDialog(null, "This project creates 3 calculator objects with different"
                     + " operations and stick them all in a single frame. And has a boring menu as well.");
         }
    } 
}
