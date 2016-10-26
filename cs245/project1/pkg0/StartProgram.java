/***************************************************************
* file: StartProgram.java
* author: Zhen Liu, Kaythari Phon, Nam Huynh, Dulce Nava
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project Version 1.2
* date last modified: 10/23/2016
*
* purpose: this class is the driver class that starts the
* program. It creates the JFrame needed for the panels.
*
****************************************************************/ 
package cs245.project1.pkg0;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent; 

public class StartProgram 
{
    //method: main
    //purpose: starts the program and calls the method createGUI.
    public static void main(String[] args) 
    {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                createGUI();
            }
        });
    }
    
    //method: createGUI
    //purpose: creates the JFrame that will hold all panel.
    public static void createGUI()
    {
        final JFrame f = new JFrame("CS245 Quarter Project Version 1.2");
        f.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "F1"); 
        f.getRootPane().getActionMap().put("F1", new AbstractAction()
        { 
            @Override
            public void actionPerformed(ActionEvent e)
            {
               JOptionPane.showMessageDialog(f, "Kaythari Phon (Bronco ID: 009873812) "
                       + "\nZhen Liu (Bronco ID: 009858420) "
                       + "\nNam (Bronco ID: 011480898)"
                       + "\nDulce (Bronco ID: 010489570) "
                       + "\nCS 245 Quarter Project, Fall 2016");
            }
        });
      
        f.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "EXIT"); 
        f.getRootPane().getActionMap().put("EXIT", new AbstractAction()
        { 
            @Override
            public void actionPerformed(ActionEvent e)
            {
               System.exit(0); 
            }
        });
        
        f.setSize(600,400);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);   
        f.add(new WelcomePage(f));
        f.pack();        
    }

    
}
