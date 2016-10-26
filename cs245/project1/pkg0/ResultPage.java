/***************************************************************
* file: ResultPage.java
* author: Zhen Liu, Kaythari Phon, Nam Huynh, Dulce Nava
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project Version 1.2
* date last modified: 10/23/2016
*
* purpose: this class is the result page. It shows up after the
* user either won, lost or skip the game. It displays the word
* and score to the user. It also has an end game button.
*
****************************************************************/ 
package cs245.project1.pkg0;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class ResultPage extends JPanel
{
    private final JToggleButton back;
    private final JLabel textTitle;
    private final JLabel textScore;
    private final JLabel textWord;
    private JLabel submitText;
    private JTextField nameField;
    
    private JFrame mainFrame;
    private JPanel thisPanel;
    
    private final int score;
    private final String keyword;   
    private String[] names;
    private final int[] scores;
    private File scoreFile; 
    
    private final AudioClip audio;

    //method: ResultPage
    //purpose: constructor, takes in 3 arguments: a JFrame, an int and 
    //a string. It creates and add all the elements on the panel. Prints
    //out the word and score on the page. Also has an end game button.
    public ResultPage (JFrame mf, int s, String k, AudioClip c) throws IOException 
    {
        mainFrame = mf;
        thisPanel = this;
        score = s;
        keyword = k;
        audio = c;
        
        setLayout(null);

        //Read in scores
        names = new String[5];
        scores = new int[5];
        scoreFile = new File("src\\HighScores.txt");
        getScores(scoreFile);
    
        textTitle = new JLabel("Results");
        textTitle.setBounds(0, 20, 600, 125);
        textTitle.setFont(new Font("Chiller", Font.PLAIN, 75));
        textTitle.setHorizontalAlignment(SwingConstants.CENTER);
        textTitle.setForeground(Color.BLACK);
        add(textTitle);

        textWord = new JLabel("Word: "+keyword.toUpperCase());
        textWord.setBounds(0, 160, 600, 60);
        textWord.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        textWord.setHorizontalAlignment(SwingConstants.CENTER);
        textWord.setForeground(Color.BLACK);
        add(textWord);

        textScore = new JLabel("Score: " + score);
        textScore.setBounds(0, 210, 600, 60);
        textScore.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        textScore.setHorizontalAlignment(SwingConstants.CENTER);
        textScore.setForeground(Color.BLACK);
        add(textScore);
        
        if(score > scores[4])
        {
            textScore.setText("New High Score: " + score);
            submitText = new JLabel("Press Enter to Save");
            submitText.setBounds(250, 310, 100, 20);
            submitText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
            submitText.setHorizontalAlignment(SwingConstants.CENTER);
            submitText.setForeground(Color.BLACK);
            add(submitText);
            
            scores[4] = score;
            nameField = new JTextField("Name", 10);
            nameField.setBounds(250, 290, 100, 20);
            nameField.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    names[4] = nameField.getText();
                    nameField.setEnabled(false);
                    try 
                    {
                        saveScore(scoreFile);
                    } 
                    catch (IOException ex) {}
                }
            });
            add(nameField);
        }

        //Back Button
        back = new JToggleButton("End Game");
        back.setBackground(Color.WHITE);
        back.setBounds(12, 360, 250, 250);
        back.setSize(100, 30);
        back.setToolTipText("Click this button to end the game and return to menu.");        
        add(back);
        back.addActionListener(new ActionListener () 
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
    }
    
    //method: saveScore
    //purpose: this method will call sortScores() to first
    //sort the scores and then save the scores in HighScores.txt
    private void saveScore(File file) throws IOException
    {
        sortScores();
        PrintWriter pw = new PrintWriter(file);
        for (int i = 0; i < scores.length; i++)
        {
           pw.println(names[i] + " " + scores[i]);
        }
        pw.close();
    } 
    
    //method: sortScores
    //purpose: this method will sort the top five high scores in
    //descending order.
    private void sortScores()
    {
        int temp;
        String temp2;
        for(int i = 0; i < scores.length - 1; i++)
        {
            for(int j = 1; j < scores.length; j++)
            {
                if(scores[j] > scores[j-1])
                {
                    temp = scores[j];
                    scores[j] = scores[j-1];
                    scores[j-1] = temp;
                    
                    temp2 = names[j];
                    names[j] = names[j-1];
                    names[j-1] = temp2;
                }
            }
        }
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

