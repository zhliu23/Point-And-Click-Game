/***************************************************************
* file: CreditPage.java
* author: Zhen Liu, Kaythari Phon, Nam Huynh, Dulce Nava
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project Version 1.2
* date last modified: 10/23/2016
*
* purpose: this class display the credits of the project
*
****************************************************************/ 
package cs245.project1.pkg0;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreditPage extends JPanel
{
    private final JToggleButton goback;
    private JFrame mainFrame;
    private JPanel thisPanel;
    private final JLabel title, member1, member2, member3, member4;
    
    private final AudioClip audio;
    
    //method: CreditPage
    //purpose: the constructor for CreditPage class. Creates and
    //add all the elements to the panel. It prints out all the team
    //member names and bronco ID. It also has a back button that goes
    //back to the main menu.
    public CreditPage(JFrame mf, AudioClip c) 
    {
        thisPanel = this;
        mainFrame = mf;
       
        setLayout(null);
        
        //Add music
        audio = c;
        
        goback = new JToggleButton("Back");
        goback.setBackground(new Color(230,230,250));
        goback.setBounds(12, 360, 250, 250);
        goback.setSize(80, 30);
        goback.setToolTipText("Click this button to return to menu.");
        add(goback);
        goback.addActionListener(new ActionListener () 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                mainFrame.add(new MenuPage(mainFrame, audio));
                mainFrame.pack();
                try
                {
                    mainFrame.remove(thisPanel);
                }
                catch(Exception ex){};
            }
         });
       
        title = new JLabel("Credits");
        title.setBounds(0, 20, 600, 125);
        title.setFont(new Font("Chiller", Font.PLAIN, 75));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.BLACK);
        add(title);
        
        member1 = new JLabel("Kaythari Phon: 009873812");
        member1.setBounds(0, 150, 600, 60);
        member1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        member1.setHorizontalAlignment(SwingConstants.CENTER);
        member1.setForeground(Color.BLACK);      
        add(member1);
        
        member2 = new JLabel("Zhen liu: 009858420");
        member2.setBounds(0, 180, 600, 60);
        member2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        member2.setHorizontalAlignment(SwingConstants.CENTER);
        member2.setForeground(Color.BLACK);       
        add(member2);
        
        member3 = new JLabel("Nam Huynh: 011480898");
        member3.setBounds(0, 210, 600, 60);
        member3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        member3.setHorizontalAlignment(SwingConstants.CENTER);
        member3.setForeground(Color.BLACK);       
        add(member3);
        
        member4 = new JLabel("Dulce Nava: 010489570");
        member4.setBounds(0, 240, 600, 60);
        member4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        member4.setHorizontalAlignment(SwingConstants.CENTER);
        member4.setForeground(Color.BLACK);       
        add(member4);
        
    }
    
    //method: paintCoponent
    //purpose: paint a gradient background color
    @Override
    protected void paintComponent(Graphics g) 
    {
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        Color color1 = new Color(46,212,216);
        Color color2 = new Color(19,77,79);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
     
    //method: getPreferredSize
    //purpose: returns the preferred size for the window.
    @Override
    public Dimension getPreferredSize() 
    {
        return new Dimension(600, 400);
    }
}
