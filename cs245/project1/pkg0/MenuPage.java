/***************************************************************
* file: HighScorePage.java
* author: Zhen Liu, Kaythari Phon, Nam Huynh, Dulce Nava
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project Version 1.2
* date last modified: 10/23/2016
*
* purpose: this class is the main menu of the game. It shows 
* the team logo and allow users to navigate between three 
* options: Play, Scores, Credits
*
****************************************************************/ 
package cs245.project1.pkg0;

import java.applet.AudioClip;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.*;
import java.awt.event.*;

public class MenuPage extends JPanel 
{
    private final JToggleButton playButton;
    private final JToggleButton scoreButton;
    private final JToggleButton creditButton;
    private JPanel thisPanel;
    private Image logo;
    private JFrame mainFrame; 
    private final AudioClip audio;
    
    //method: MenuPage
    //purpose: the constructor for the MenuPage class. Creates and
    //add all the elements for the menu panel. It contains 3 buttons,
    //Play, Scores and Credits. Each will navigate user to its
    //appropriate panel.
    public MenuPage(JFrame mf, AudioClip c)
    {
        mainFrame = mf;
        thisPanel = this;
        
        setLayout(null); 
        audio = c;
        
        playButton = new JToggleButton("Play");
        playButton.setToolTipText("Click this button to move to the first game.");
        playButton.setBackground(new Color(230,230,250));
        playButton.setBounds(435, 285, 250, 250);
        playButton.setSize(150, 30);
        playButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(playButton);
        
        playButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) { 
                mainFrame.add(new GamePage(mainFrame, audio));
                mainFrame.pack();
                try {
                    mainFrame.remove(thisPanel);
                }
                catch(Exception ex){};
               }
        });
       
        scoreButton = new JToggleButton("High Scores");
        scoreButton.setToolTipText("Click this button to view highscores.");
        scoreButton.setBackground(new Color(230,230,250));
        scoreButton.setBounds(435, 320, 250, 250);
        scoreButton.setSize(150, 30);
        scoreButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(scoreButton);
        
        scoreButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    mainFrame.add(new HighScorePage(mainFrame, audio));
                    mainFrame.pack();
                    try 
                    {
                        mainFrame.remove(thisPanel);
                    }
                    catch(Exception ex){};
                }
                catch(IOException ex){}
            }
        });
        
        creditButton = new JToggleButton("Credit");
        creditButton.setToolTipText("Click this button to view credits of this program.");
        creditButton.setBackground(new Color(230,230,250));
        creditButton.setBounds(435, 355, 250, 250);
        creditButton.setSize(150, 30);
        creditButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(creditButton);
        
        creditButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainFrame.add(new CreditPage(mainFrame, audio));
                mainFrame.pack();
                try 
                {
                    mainFrame.remove(thisPanel);
                }
                catch(Exception ex){};
            }
        });    
    }
    
    //method: getPreferredSize()
    //purpose: returns the preferred size for the panel.
    @Override
    public Dimension getPreferredSize() 
    {
        return new Dimension(600,400);
    }
    
    //method: paintComponent()
    //purpose: loads and print the image to the panel
    @Override
    public void paintComponent(Graphics g)
    {
        //paint a gradient background color
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        Color color1 = new Color(46,212,216);
        Color color2 = new Color(19,77,79);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        //add image
        try 
        {
            logo = ImageIO.read(new File("src\\grouplogo.png"));
            logo = logo.getScaledInstance(2400, 1905, java.awt.Image.SCALE_SMOOTH);
        } 
        catch(IOException e) {}
        g.drawImage(logo, 15, 5, 300, 230, this);     
    }
}
