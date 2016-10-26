/***************************************************************
* file: WelcomePage.java
* author: Zhen Liu, Kaythari Phon, Nam Huynh, Dulce Nava
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project Version 1.2
* date last modified: 10/23/2016
*
* purpose: this class creates the welcome panel that display
* the project name and team name. It will automatically go to
* the main menu after 3 seconds.
*
****************************************************************/ 
package cs245.project1.pkg0;

import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class WelcomePage extends JPanel implements ActionListener 
{
    private JFrame mainFrame;
    private final JLabel jlab1;
    private final JLabel jlab2;
    private final Timer timer;
    
    private URL url; 
    private final AudioClip audio;
    
    
    //method: WelcomePage
    //purpose: creates the welcome message that display project
    //name and team name. It has a timer that will automically
    //move to main menu after 3 seconds.
    public WelcomePage (JFrame mf)
    {
        mainFrame = mf;
        setLayout(null);
        timer = new Timer(3000, this);
        timer.start();
        
        //Create music
        try 
        {
            url = new File("src\\Arcade Funk.wav").toURI().toURL();
        } 
        catch (MalformedURLException ex) {}
        audio = Applet.newAudioClip(url);                   
        audio.play(); 
        audio.loop(); //Not looping

        jlab1 = new JLabel("CS 245 Quarter Project");
        jlab1.setBounds(0, 50, 600, 60);
        jlab1.setFont(new Font("Times New Roman", Font.BOLD, 50));
        jlab1.setForeground(Color.BLACK);
        jlab1.setHorizontalAlignment(SwingConstants.CENTER);
        add(jlab1);
        
        jlab2 = new JLabel("Team: DKNZ");
        jlab2.setBounds(0, 250, 600, 60);
        jlab2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        jlab2.setForeground(Color.BLACK);
        jlab2.setHorizontalAlignment(SwingConstants.CENTER);
        add(jlab2);        
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
    //purpose: returns the preferred size for the panel.
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(600,400);
    }

    //method: actionPerformed
    //purpose: this method adds the next panel to the JFrame and
    //deletes the current panel.
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        timer.stop();
        mainFrame.add(new MenuPage(mainFrame, audio));
        mainFrame.pack();
        try 
        {
            mainFrame.remove(this);
        }
        catch(Exception ex){};
    }   
}
   

