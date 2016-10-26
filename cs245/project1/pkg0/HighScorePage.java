/***************************************************************
* file: HighScorePage.java
* author: Zhen Liu, Kaythari Phon, Nam Huynh, Dulce Nava
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project Version 1.2
* date last modified: 10/23/2016
*
* purpose: this class adds placeholder for the high score
* of this game
*
****************************************************************/ 
package cs245.project1.pkg0;

import java.applet.AudioClip;
import javax.swing.JToggleButton;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HighScorePage extends JPanel 
{
    private JFrame mainFrame;
    private JPanel thisPanel;
    private final JToggleButton goback;
    private final JLabel title, score1, score2, score3, score4, score5;
    private final File scoreFile;
    private final int[] scores;
    private final String[] names;
    
    private final AudioClip audio;
    
    //method: HighScorePage
    //purpose: the constructor for the HighScorePage class. Creates and
    //add all the elements to the panel. It prints out placeholder names
    //and scores. It also has a back button to return to menu.
    HighScorePage(JFrame mf, AudioClip c) throws IOException
    {
        thisPanel = this;
        mainFrame = mf;
        audio = c;
        
        setLayout(null);

        //Back Button
        goback = new JToggleButton("Back");
        goback.setBackground(new Color(230,230,250));
        goback.setBounds(12, 360, 250, 250);
        goback.setSize(80, 30);
        goback.setToolTipText("Click this button to return to menu.");
        add(goback);
        goback.addActionListener(new ActionListener() 
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
        
        //Title Text
        title = new JLabel("High Scores");
        title.setBounds(0, 20, 600, 125);
        title.setFont(new Font("Chiller", Font.PLAIN, 75));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.BLACK);
        add(title);
        
        //Initialize File
        names = new String[5];
        scores = new int[5];
        scoreFile = new File("src\\HighScores.txt");
        getScores(scoreFile);
        
        //Score Text
        score1 = new JLabel(names[0] + "....." + scores[0]);
        score1.setBounds(0, 130, 600, 60);
        score1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        score1.setHorizontalAlignment(SwingConstants.CENTER);
        score1.setForeground(Color.BLACK);
        add(score1);
        
        score2 = new JLabel(names[1] + "....." + scores[1]);
        score2.setBounds(0, 160, 600, 60);
        score2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        score2.setHorizontalAlignment(SwingConstants.CENTER);
        score2.setForeground(Color.BLACK);
        add(score2);
        
        score3 = new JLabel(names[2] + "....." + scores[2]);
        score3.setBounds(0, 190, 600, 60);
        score3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        score3.setHorizontalAlignment(SwingConstants.CENTER);
        score3.setForeground(Color.BLACK);
        add(score3);
                
        score4 = new JLabel(names[3] + "....." + scores[3]);
        score4.setBounds(0, 220, 600, 60);
        score4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        score4.setHorizontalAlignment(SwingConstants.CENTER);
        score4.setForeground(Color.BLACK);
        add(score4);    
        
        score5 = new JLabel(names[4] + "....." + scores[4]);
        score5.setBounds(0, 250, 600, 60);
        score5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        score5.setHorizontalAlignment(SwingConstants.CENTER);
        score5.setForeground(Color.BLACK);
        add(score5);   
    }

    //method: getScores
    //purpose: this method will read in the high scores
    //saved in the HighScores.txt and save the scores
    //and names into arrays
    private void getScores(File file) throws IOException
    {
        if(file.exists()) 
        {
            Scanner sc = new Scanner(file);
            for(int i = 0; i < 5; i++)
            {
                names[i] = sc.next();
                scores[i] = sc.nextInt();
                sc.nextLine();
            }
            sc.close();
        }
        else
        {
            //file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            for(int i = 0; i < 5; i++)
            {
                names[i] = "ABC";
                scores[i] = 0;
                pw.println("ABC 0"); 
            }
            pw.close();
        }
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
        return new Dimension(600, 400);
    }

    
}
