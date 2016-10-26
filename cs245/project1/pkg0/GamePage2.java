/***************************************************************
* file: GamePage2.java
* author: Zhen Liu, Kaythari Phon, Nam Huynh, Dulce Nava
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project Version 1.2
* date last modified: 10/23/2016
*
* purpose: this class is the second game of this project.
* It will randomly generate the name of a color (note: the 
* color of the text can be different than the name of color).
* It will also generate five circles of different color onto
* the screen. The circles will become highlighted when the mouse
* is hover over the circle.
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class GamePage2 extends JPanel
{
    private JToggleButton circle1, circle2, circle3, circle4, circle5;
    private final JLabel scoreLabel;
    private JLabel clockLabel, dateLabel, colorLabel;
    private final JPanel thisPanel;
    private final JFrame mainFrame;
    private final String keyword; 
    private String textColor;
    private int score, rounds;
    private int hour, minute, second, month, day, year;
    private Calendar cal; 
    private int randNum, randNum2;
    private final String[] monthNames;
    private final ArrayList colorList = new ArrayList();
    private final AudioClip audio;
    
    //method: GamePage2
    //purpose: constructor, takes in 3 arguments: JFrame, 
    //int and String. The constructors also initialize number
    //of rounds, arraylist of colors,prints out score, clock 
    //and calendar. It calls generatePos() to start the game.
    public GamePage2(JFrame mf, int lastScore, String k, AudioClip c)
    {
        mainFrame = mf;
        thisPanel = this;
        
        score = lastScore;
        keyword = k;
        rounds = 5;
        audio = c;
        
        setLayout(null);
        
        //Score
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setBackground(Color.WHITE);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds(5, 0, 100, 100);
        scoreLabel.setSize(80, 30);
        add(scoreLabel);  
        
        //Date text
        monthNames = new String[] {"January", "Februrary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        cal = Calendar.getInstance();
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        year = cal.get(Calendar.YEAR);
      
        dateLabel = new JLabel(monthNames[month] + " " + day + ", " + year);
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setBounds(435, 0, 250, 250);
        dateLabel.setSize(100, 30);
        dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(dateLabel);
        
        //Clock
        cal = Calendar.getInstance();
        updateTime();
        clockLabel = new JLabel(hour + ":" + minute + ":" + second);
        clockLabel.setForeground(Color.WHITE);
        clockLabel.setBounds(530, 0, 250, 250);
        clockLabel.setSize(70, 30);
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(clockLabel);
        mainFrame.pack();
        new Timer(1000, new ActionListener () 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                updateTime();
                clockLabel.setText(String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second));
                dateLabel = new JLabel(monthNames[month] + " " + day + ", " + year);
                repaint();
            }
        }).start();
        
        
        
        //ArrayList
        colorList.add(Color.RED);
        colorList.add(Color.YELLOW);
        colorList.add(Color.GREEN);
        colorList.add(Color.BLUE);
        colorList.add(Color.MAGENTA);
        
        generatePos();
    }
    
    //method: generateColor
    //purpose: randomly generates the name of color and the color
    //of the text. Then adds the text to screen.
    private void generateColor()
    {
        //Color Text
        Random rand = new Random();
        randNum = rand.nextInt(5);
        randNum2 = rand.nextInt(5);
        
        switch(randNum)
        {
            case 0:
                colorLabel = new JLabel("Red");
                break;
            case 1:
                colorLabel = new JLabel("Yellow");
                break;
            case 2:
                colorLabel = new JLabel("Green");
                break;
            case 3:
                colorLabel = new JLabel("Blue");
                break;
            case 4:
                colorLabel = new JLabel("Purple");
                break;
        }
        colorLabel.setBounds(0, 10, 600, 60);
        colorLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        colorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        switch(randNum2)
        {
            case 0:
                colorLabel.setForeground(Color.RED);
                textColor = "red";
                break;
            case 1:
                colorLabel.setForeground(Color.YELLOW);
                textColor = "yellow";
                break;
            case 2:
                colorLabel.setForeground(Color.GREEN);
                textColor = "green";
                break;
            case 3:
                colorLabel.setForeground(Color.BLUE);
                textColor = "blue";
                break;
            case 4:
                colorLabel.setForeground(Color.MAGENTA);
                textColor = "purple";
                break;
        }
        add(colorLabel);
    }
    
    //method: generatePos()
    //purpose: this method will first call checkRound() to determine if
    //game is over. It will then shuffle the arraylist of colors to randomly
    //assign the colors to each circle. It will draw five circles to the screen
    //with randomly generated position. If the user clicks the right circle, it
    //will increment the score by 100 otherwise 0.
    private void generatePos()
    {
        checkRound();
        generateColor();
        Random rand = new Random();
        
        Collections.shuffle(colorList);
        
        //Circle 1
        circle1 = new JToggleButton();
        //circle1.setOpaque(true);
        circle1.setBackground(Color.WHITE.darker());
        circle1.setForeground((Color) colorList.get(0));
        circle1.setContentAreaFilled(false);
        circle1.setBounds(rand.nextInt(120), rand.nextInt(120), 80, 80);
        circle1.setBorder(new LineBorder((Color) colorList.get(0), 100, true));
        //circle1.setBorderPainted(false);
        circle1.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                //circle1.setContentAreaFilled(true);
                //circle1.setBorderPainted(true);
                circle1.setBorder(new LineBorder(((Color) colorList.get(0)).darker(), 100, true));
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                //circle1.setContentAreaFilled(false);
                circle1.setBorder(new LineBorder((Color) colorList.get(0), 100, true));
                //circle1.setBorderPainted(false);
            }
        });
        circle1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(circle1.getForeground() == colorLabel.getForeground())
                {
                    score += 100;
                    scoreLabel.setText("Score: " + score);
                }
                rounds--;
                colorLabel.setVisible(false);
                circle1.setVisible(false);
                circle2.setVisible(false);
                circle3.setVisible(false);
                circle4.setVisible(false);
                circle5.setVisible(false);
                generatePos();
            }
        });
        add(circle1);
        
        //Circle 2
        circle2 = new JToggleButton();
        circle2.setOpaque(true);
        circle2.setBackground(Color.WHITE.darker());
        circle2.setForeground((Color) colorList.get(1));
        circle2.setContentAreaFilled(false);
        circle2.setBounds(rand.nextInt(120) + 400, rand.nextInt(120), 80, 80);
        circle2.setBorder(new LineBorder((Color) colorList.get(1), 100, true));
        circle2.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                //circle2.setContentAreaFilled(true);
                circle2.setBorder(new LineBorder(((Color) colorList.get(1)).darker(), 100, true));
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                circle2.setContentAreaFilled(false);
                circle2.setBorder(new LineBorder((Color) colorList.get(1), 100, true));
            }
        });
        circle2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(circle2.getForeground() == colorLabel.getForeground())
                {
                    score += 100;
                    scoreLabel.setText("Score: " + score);
                }
                rounds--;
                colorLabel.setVisible(false);
                circle1.setVisible(false);
                circle2.setVisible(false);
                circle3.setVisible(false);
                circle4.setVisible(false);
                circle5.setVisible(false);
                generatePos();
            }
        });
        add(circle2);
        
        //Circle 3
        circle3 = new JToggleButton();
        circle3.setOpaque(true);
        circle3.setBackground(Color.WHITE.darker());
        circle3.setForeground((Color) colorList.get(2));
        circle3.setContentAreaFilled(false);
        circle3.setBounds(rand.nextInt(120), rand.nextInt(120) + 200, 80, 80);
        circle3.setBorder(new LineBorder((Color) colorList.get(2), 100, true));
        circle3.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                //circle3.setContentAreaFilled(true);
                circle3.setBorder(new LineBorder(((Color) colorList.get(2)).darker(), 100, true));
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                //circle3.setContentAreaFilled(false);
                circle3.setBorder(new LineBorder((Color) colorList.get(2), 100, true));
            }
        });
        circle3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(circle3.getForeground() == colorLabel.getForeground())
                {
                    score += 100;
                    scoreLabel.setText("Score: " + score);
                }
                rounds--;
                colorLabel.setVisible(false);
                circle1.setVisible(false);
                circle2.setVisible(false);
                circle3.setVisible(false);
                circle4.setVisible(false);
                circle5.setVisible(false);
                generatePos();
            }
        });
        add(circle3);
        
        //Circle 4
        circle4 = new JToggleButton();
        circle4.setOpaque(true);
        circle4.setBackground(Color.WHITE.darker());
        circle4.setForeground((Color) colorList.get(3));
        circle4.setContentAreaFilled(false);
        circle4.setBounds(rand.nextInt(120) + 200, rand.nextInt(120) + 120, 80, 80);
        circle4.setBorder(new LineBorder((Color) colorList.get(3), 100, true));
        circle4.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                //circle4.setContentAreaFilled(true);
                circle4.setBorder(new LineBorder(((Color) colorList.get(3)).darker(), 100, true));
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                //circle4.setContentAreaFilled(false);
                circle4.setBorder(new LineBorder((Color) colorList.get(3), 100, true));
            }
        });
        circle4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(circle4.getForeground() == colorLabel.getForeground())
                {
                    score += 100;
                    scoreLabel.setText("Score: " + score);
                }
                rounds--;
                colorLabel.setVisible(false);
                circle1.setVisible(false);
                circle2.setVisible(false);
                circle3.setVisible(false);
                circle4.setVisible(false);
                circle5.setVisible(false);
                generatePos();
            }
        });
        add(circle4);
        
        //Circle 5
        circle5 = new JToggleButton();
        circle5.setOpaque(true);
        circle5.setBackground(Color.WHITE.darker());
        circle5.setForeground((Color) colorList.get(4));
        circle5.setContentAreaFilled(false);
        circle5.setBounds(rand.nextInt(120) + 400, rand.nextInt(120) + 200, 80, 80);
        circle5.setBorder(new LineBorder((Color) colorList.get(4), 100, true));
        circle5.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                //circle5.setContentAreaFilled(true);
                circle5.setBorder(new LineBorder(((Color) colorList.get(4)).darker(), 100, true));
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                //circle5.setContentAreaFilled(false);
                circle5.setBorder(new LineBorder((Color) colorList.get(4), 100, true));

            }
        });
        circle5.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(circle5.getForeground() == colorLabel.getForeground())
                {
                    score += 100;
                    scoreLabel.setText("Score: " + score);
                }
                rounds--;
                colorLabel.setVisible(false);
                circle1.setVisible(false);
                circle2.setVisible(false);
                circle3.setVisible(false);
                circle4.setVisible(false);
                circle5.setVisible(false);
                generatePos();
            }
        });
        add(circle5);
    }
    
    //method: checkRound()
    //purpose: this method checks if it has been 5 rounds already. If
    //the user already played 5 rounds, it will then call the
    //result page and end the game.
    private void checkRound()
    {
        if(rounds == 0)
        {
            mainFrame.add(new GamePage3(mainFrame, score, keyword, audio)); 
            mainFrame.pack();
            try
            {
                mainFrame.remove(thisPanel);
            }
            catch(Exception ex){}
        }
    }
    
    //method: updateTime
    //purpose: this method increments the displayed clock.
    private void updateTime() 
    {
        cal.setTimeInMillis(System.currentTimeMillis());
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE); 
        second = cal.get(Calendar.SECOND); 
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        year = cal.get(Calendar.YEAR);
    }
    
    //method: paintComponent
    //purpose: paint a gradient background color
    @Override
    protected void paintComponent( Graphics g ) 
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
