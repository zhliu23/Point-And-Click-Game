/***************************************************************
* file: SudokuField.java
* author: Zhen Liu, Kaythari Phon, Nam Huynh, Dulce Nava
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project Version 1.2
* date last modified: 10/23/2016
*
* purpose: this class is the SudokuField class that extends
* the JTextField. It has the addition functions to store user
* input and check if the value is correct.
*
****************************************************************/ 

package cs245.project1.pkg0;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SudokuField extends JTextField
{
    private JFrame mainFrame;
    private boolean correct, pointTaken, inputReceived;
    private int userInput;
    
    //method: SudokuField
    //purpose: this class is the constructor for the SudokuField.
    public SudokuField(JFrame mf)
    {
        mainFrame = mf;
        correct = false;
        pointTaken = false;
        inputReceived = false;
        
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("", Font.BOLD, 20));
        
        addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e){}

            @Override
            public void focusLost(FocusEvent e) 
            {
                try
                {
                    if(Integer.parseInt(getText()) > 9 || Integer.parseInt(getText()) < 1)
                    {
                        JOptionPane.showMessageDialog(mainFrame,
                            "Please enter a number from 1 to 9",
                            "Invalid Number",
                            JOptionPane.ERROR_MESSAGE);
                        setText("");
                    }
                }
                catch(NumberFormatException ex)
                {
                    if(!getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(mainFrame,
                            "Please enter a number from 1 to 9",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                            setText("");
                    }
                }
            }

        });
    }
    
    public void setPointTaken(boolean b)
    {
        pointTaken = b;
    }
    
    public boolean isPointTaken()
    {
        return pointTaken;
    }
    
    public void setCorrect(boolean b)
    {
        correct = b;
    }
    
    public boolean isCorrect()
    {
        return correct;
    }
    
    public void setNum(int i)
    {
        userInput = i;
        inputReceived = true;
    }
    
    public int getNum()
    {
        return userInput;
    }
    
    public boolean hasSetNum()
    {
        return inputReceived;
    }
}
