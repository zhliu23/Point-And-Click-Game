/***************************************************************
* file: GamePage.java
* author: Zhen Liu, Kaythari Phon, Nam Huynh, Dulce Nava
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project Version 1.2
* date last modified: 10/23/2016
*
* purpose: this class is the the game. It starts the hangman game
* by selecting a keyword and draws all the graphic for the game.
* It also includes a clock that displays current time.
*
****************************************************************/ 
package cs245.project1.pkg0;

import java.applet.AudioClip;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import javax.imageio.ImageIO;
import java.util.Random; 

public  class GamePage extends JPanel
{
    private final JToggleButton a, b, c, d, e1, f, g, h, i, j, k, l, m, n, o, p; 
    private final JToggleButton q, r, s, t, u, v, w, x, y, z, skip; 
    private JLabel a1Abstract, bAbstract, sAbstract,t1Abstract,rAbstract,a2Abstract,cAbstract,t2Abstract;
    private JLabel cClmb, lClmb, iClmb, mClmb, bClmb, i2Clmb, nClmb, gClmb;
    private JLabel cCemetery, e1Cemetery,mCemetery, e2Cemetery,tCemetery, e3Cemetery,rCemetery, yCemetery;
    private JLabel pFarm, hFarm, aFarm, rFarm, mFarm, a1Farm, cFarm,  yFarm; 
    private JLabel nNurse, uNurse, rNurse, sNurse, eNurse;
    private JLabel scoreLabel, clockLabel, dateLabel, hangmanlogo;
    private JPanel thisPanel;
    private BufferedImage emptyHangmanPic, dashed5, dashed8;
    private Image stage1, stage2, stage3, stage4, stage5, stage6;
    private int numLetters, numCorrect, randNumber, score, hour, minute, second, month, day, year;
    private String keyword;
    private JFrame mainFrame;
    boolean head, body, rightleg, leftleg, rightArm, leftArm;
    public int tries;
    private final String[] monthNames;
    private Calendar cal; 
    private final AudioClip audio;
    
    //method: GamePage 
    //purpose: starts the hangman game. Has buttons for A-Z and skip. 
    //Prints the graphics for hangman and a title. It also displays 
    //a clock that shows the current time in a 24 hour format.
    //The clock updates every second and it prints day, month, and year.
    //Also displays the score.  
    public GamePage (JFrame mf, AudioClip cl)
    {
        mainFrame = mf;
        thisPanel = this;
        tries = 6;
        numCorrect = 0;
        score = 100;
        audio = cl;
        
        setLayout(null);

        //get random word
        Random rand = new Random();
        randNumber = rand.nextInt(5);
        switch(randNumber)
        {
            case 0:
                keyword = "Climbing";
                numLetters = 8;

                cClmb = new JLabel("C");
                cClmb.setBounds(20, 180, 100, 19);
                cClmb.setForeground(Color.WHITE);
                cClmb.setFont(new Font("Times New Roman", Font.BOLD, 23));
                cClmb.setVisible(false);
                add(cClmb);

                lClmb = new JLabel("L");
                lClmb.setBounds(55, 180, 100, 19);
                lClmb.setForeground(Color.WHITE);
                lClmb.setFont(new Font("Times New Roman", Font.BOLD, 23));
                lClmb.setVisible(false);
                add(lClmb);

                iClmb = new JLabel("I");
                iClmb.setBounds(90, 180, 100, 19);
                iClmb.setForeground(Color.WHITE);
                iClmb.setFont(new Font("Times New Roman", Font.BOLD, 23));
                iClmb.setVisible(false);
                add(iClmb);

                mClmb = new JLabel("M");
                mClmb.setBounds(125, 180, 100, 19);
                mClmb.setForeground(Color.WHITE);
                mClmb.setFont(new Font("Times New Roman", Font.BOLD, 23));
                mClmb.setVisible(false);
                add(mClmb);

                bClmb = new JLabel("B");
                bClmb.setBounds(160, 180, 100, 19);
                bClmb.setForeground(Color.WHITE);
                bClmb.setFont(new Font("Times New Roman", Font.BOLD, 23));
                bClmb.setVisible(false);
                add(bClmb);

                i2Clmb = new JLabel("I");
                i2Clmb.setBounds(195, 180, 100, 19);
                i2Clmb.setForeground(Color.WHITE);
                i2Clmb.setFont(new Font("Times New Roman", Font.BOLD, 23));
                i2Clmb.setVisible(false);
                add(i2Clmb);

                nClmb = new JLabel("N");
                nClmb.setBounds(230, 180, 100, 19);
                nClmb.setForeground(Color.WHITE);
                nClmb.setFont(new Font("Times New Roman", Font.BOLD, 23));
                nClmb.setVisible(false);
                add(nClmb);

                gClmb = new JLabel("G");
                gClmb.setBounds(265, 180, 100, 19);
                gClmb.setForeground(Color.WHITE);
                gClmb.setFont(new Font("Times New Roman", Font.BOLD, 23));
                gClmb.setVisible(false);
                add(gClmb);
                break;
                
            case 1:
                keyword = "Abstract";
		numLetters = 8;
		
		a1Abstract = new JLabel("A");
		a1Abstract.setBounds(20, 180, 100, 19);
		a1Abstract.setForeground(Color.BLACK);
		a1Abstract.setFont(new Font("Times New Roman", Font.BOLD, 23));
		a1Abstract.setVisible(false);
		add(a1Abstract);
			
                bAbstract = new JLabel("B");
                bAbstract.setBounds(55, 180, 100, 19);
                bAbstract.setForeground(Color.BLACK);
                bAbstract.setFont(new Font("Times New Roman", Font.BOLD, 23));
                bAbstract.setVisible(false);
                add(bAbstract); 

                sAbstract = new JLabel("S");
                sAbstract.setBounds(90, 180, 100, 19);
                sAbstract.setForeground(Color.BLACK);
                sAbstract.setFont(new Font("Times New Roman", Font.BOLD, 23));
                sAbstract.setVisible(false);
                add(sAbstract); 

                t1Abstract = new JLabel("T");
                t1Abstract.setBounds(125, 180, 100, 19);
                t1Abstract.setForeground(Color.BLACK);
                t1Abstract.setFont(new Font("Times New Roman", Font.BOLD, 23));
                t1Abstract.setVisible(false);
                add(t1Abstract); 

                rAbstract = new JLabel("R");
                rAbstract.setBounds(160, 180, 100, 19);
                rAbstract.setForeground(Color.BLACK);
                rAbstract.setFont(new Font("Times New Roman", Font.BOLD, 23));
                rAbstract.setVisible(false);
                add(rAbstract); 

                a2Abstract = new JLabel("A");
                a2Abstract.setBounds(195, 180, 100, 19);
                a2Abstract.setForeground(Color.BLACK);
                a2Abstract.setFont(new Font("Times New Roman", Font.BOLD, 23));
                a2Abstract.setVisible(false);
                add(a2Abstract); 

                cAbstract = new JLabel("C");
                cAbstract.setBounds(230, 180, 100, 19);
                cAbstract.setForeground(Color.BLACK);
                cAbstract.setFont(new Font("Times New Roman", Font.BOLD, 23));
                cAbstract.setVisible(false);
                add(cAbstract); 

                t2Abstract = new JLabel("T");
                t2Abstract.setBounds(265, 180, 100, 19);
                t2Abstract.setForeground(Color.BLACK);
                t2Abstract.setFont(new Font("Times New Roman", Font.BOLD, 23));
                t2Abstract.setVisible(false);
                add(t2Abstract); 
                break;
                
            case 2:
                keyword = "Nurse";
                numLetters = 5;
			
		nNurse = new JLabel("N");
		nNurse.setBounds(33,135,100,100);
		nNurse.setForeground(Color.BLACK);
		nNurse.setFont(new Font("Times New Roman", Font.BOLD, 23));
		nNurse.setVisible(false);
		add(nNurse);
			
		uNurse = new JLabel("U");
                uNurse.setBounds(85, 135, 100, 100);
                uNurse.setForeground(Color.BLACK);
                uNurse.setFont(new Font("Times New Roman", Font.BOLD, 23));
                uNurse.setVisible(false);
                add(uNurse); 

                rNurse = new JLabel("R");
                rNurse.setBounds(142, 135, 100, 100);
                rNurse.setForeground(Color.BLACK);
                rNurse.setFont(new Font("Times New Roman", Font.BOLD, 23));
                rNurse.setVisible(false);
                add(rNurse); 

                sNurse = new JLabel("S");
                sNurse.setBounds(200, 135, 100, 100);
                sNurse.setForeground(Color.BLACK);
                sNurse.setFont(new Font("Times New Roman", Font.BOLD, 23)); 
                sNurse.setVisible(false);
                add(sNurse); 

                eNurse = new JLabel("E");
                eNurse.setBounds(252, 135, 100, 100);
                eNurse.setForeground(Color.BLACK);
                eNurse.setFont(new Font("Times New Roman", Font.BOLD, 23));
                eNurse.setVisible(false);
                add(eNurse);
                break;
                
            case 3:
                keyword = "Cemetery";
		numLetters = 8;
		
		cCemetery = new JLabel("C");
		cCemetery.setBounds(20, 180, 100, 19);
		cCemetery.setForeground(Color.BLACK);
		cCemetery.setFont(new Font("Times New Roman", Font.BOLD, 23));
		cCemetery.setVisible(false);
		add(cCemetery);
			
                e1Cemetery = new JLabel("E");
                e1Cemetery.setBounds(55, 180, 100, 19);
                e1Cemetery.setForeground(Color.BLACK);
                e1Cemetery.setFont(new Font("Times New Roman", Font.BOLD, 23));
                e1Cemetery.setVisible(false);
                add(e1Cemetery); 

                mCemetery = new JLabel("M");
                mCemetery.setBounds(90, 180, 100, 19);
                mCemetery.setForeground(Color.BLACK);
                mCemetery.setFont(new Font("Times New Roman", Font.BOLD, 23));
                mCemetery.setVisible(false);
                add(mCemetery); 

                e2Cemetery = new JLabel("E");
                e2Cemetery.setBounds(125, 180, 100, 19);
                e2Cemetery.setForeground(Color.BLACK);
                e2Cemetery.setFont(new Font("Times New Roman", Font.BOLD, 23));
                e2Cemetery.setVisible(false);
                add(e2Cemetery); 

                tCemetery = new JLabel("T");
                tCemetery.setBounds(160, 180, 100, 19);
                tCemetery.setForeground(Color.BLACK);
                tCemetery.setFont(new Font("Times New Roman", Font.BOLD, 23));
                tCemetery.setVisible(false);
                add(tCemetery); 

                e3Cemetery = new JLabel("E");
                e3Cemetery.setBounds(195, 180, 100, 19);
                e3Cemetery.setForeground(Color.BLACK);
                e3Cemetery.setFont(new Font("Times New Roman", Font.BOLD, 23));
                e3Cemetery.setVisible(false);
                add(e3Cemetery); 

                rCemetery = new JLabel("R");
                rCemetery.setBounds(230, 180, 100, 19);
                rCemetery.setForeground(Color.BLACK);
                rCemetery.setFont(new Font("Times New Roman", Font.BOLD, 23));
                rCemetery.setVisible(false);
                add(rCemetery); 

                yCemetery = new JLabel("Y");
                yCemetery.setBounds(265, 180, 100, 19);
                yCemetery.setForeground(Color.BLACK);
                yCemetery.setFont(new Font("Times New Roman", Font.BOLD, 23));
                yCemetery.setVisible(false);
                add(yCemetery); 
                break;
                
            case 4:
                keyword = "Pharmacy"; 
                numLetters = 8;

                pFarm = new JLabel("P");
                pFarm.setBounds(20, 180, 100, 19);
                pFarm.setForeground(Color.WHITE);
                pFarm.setFont(new Font("Times New Roman", Font.BOLD, 23));
                pFarm.setVisible(false);
                add(pFarm); 

                hFarm = new JLabel("H");
                hFarm.setBounds(55, 180, 100, 19);
                hFarm.setForeground(Color.WHITE);
                hFarm.setFont(new Font("Times New Roman", Font.BOLD, 23));
                hFarm.setVisible(false);
                add(hFarm); 

                aFarm = new JLabel("A");
                aFarm.setBounds(90, 180, 100, 19);
                aFarm.setForeground(Color.WHITE);
                aFarm.setFont(new Font("Times New Roman", Font.BOLD, 23));
                aFarm.setVisible(false);
                add(aFarm); 

                rFarm = new JLabel("R");
                rFarm.setBounds(125, 180, 100, 19);
                rFarm.setForeground(Color.WHITE);
                rFarm.setFont(new Font("Times New Roman", Font.BOLD, 23)); 
                rFarm.setVisible(false);
                add(rFarm); 

                mFarm = new JLabel("M");
                mFarm.setBounds(160, 180, 100, 19);
                mFarm.setForeground(Color.WHITE);
                mFarm.setFont(new Font("Times New Roman", Font.BOLD, 23));
                mFarm.setVisible(false);
                add(mFarm); 

                a1Farm = new JLabel("A");
                a1Farm.setBounds(195, 180, 100, 19);
                a1Farm.setForeground(Color.WHITE);
                a1Farm.setFont(new Font("Times New Roman", Font.BOLD, 23));
                a1Farm.setVisible(false);
                add(a1Farm); 

                cFarm = new JLabel("C");
                cFarm.setBounds(230, 180, 100, 19);
                cFarm.setForeground(Color.WHITE);
                cFarm.setFont(new Font("Times New Roman", Font.BOLD, 23));
                cFarm.setVisible(false);
                add(cFarm); 

                yFarm = new JLabel("Y");
                yFarm.setBounds(265, 180, 100, 19);
                yFarm.setForeground(Color.WHITE);
                yFarm.setFont(new Font("Times New Roman", Font.BOLD, 23));
                yFarm.setVisible(false);
                add(yFarm); 
                break;
        }   
        
        //Skip Button
        skip = new JToggleButton("Skip");
        skip.setBackground(Color.WHITE);
        skip.setBounds(12, 355, 250, 250);
        skip.setSize(80, 30);
        skip.setToolTipText("Click this button to skip to the next game.");
        add(skip);
        skip.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                mainFrame.add(new GamePage2(mainFrame, 0, keyword, audio));
                mainFrame.pack();
                try 
                {
                   mainFrame.remove(thisPanel);
                }
                catch(Exception ex){};
            }
        });
      
        //Score
        scoreLabel = new JLabel("Score: "+score);
        scoreLabel.setBackground(Color.WHITE);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds(10, 330, 100, 100);
        scoreLabel.setSize(80, 30);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
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
        new Timer(1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                updateTime();
                clockLabel.setText(String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second));
                dateLabel = new JLabel(monthNames[month] + " " + day + ", " + year);
                repaint();
            }
        }).start(); //Update every second
      
        //Hangman Logo
        hangmanlogo = new JLabel("Hangman");
        hangmanlogo .setBounds(0, 20, 600, 125);
        hangmanlogo .setFont(new Font("Chiller", Font.PLAIN, 100));
        hangmanlogo .setHorizontalAlignment(SwingConstants.LEFT);
        hangmanlogo .setForeground(Color.BLACK);
        add(hangmanlogo );

           

        //Buttons
        a = new JToggleButton("A");
        a.setMargin(new Insets(0, 0, 0, 0));
        a.setBackground(new Color(105,40,33));
        a.setForeground(Color.white);
        a.setBounds(100, 315, 30, 30);
        a.setSize(30, 30);
        add(a); 
        a.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                a.setEnabled(false);
                switch(keyword) 
                {
                    case "Abstract":
                        a1Abstract.setVisible(true);
                        a2Abstract.setVisible(true);
                        numCorrect++;
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Pharmacy":
                        aFarm.setVisible(true);
                        a1Farm.setVisible(true);
                        numCorrect++;
                        numCorrect++;
                        checkComplete();
                        break;
                    default:
                        addPart();
                        break;
                }
            }
        });

        b = new JToggleButton("B");
        b.setMargin(new Insets(0, 0, 0, 0));
        b.setBackground(new Color(105,40,33));
        b.setForeground(Color.white);
        b.setBounds(135, 315, 50, 50);
        b.setSize(30, 30);
        add(b);
        b.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                b.setEnabled(false);
                switch(keyword) 
                {
                    case "Abstract":
                        bAbstract.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Climbing":
                        bClmb.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    default:
                        addPart();
                        break;
                }
            }
        });

        c = new JToggleButton("C");
        c.setMargin(new Insets(0, 0, 0, 0));
        c.setBackground(new Color(105,40,33));
        c.setForeground(Color.white);
        c.setBounds(170, 315, 50, 50);
        c.setSize(30, 30);
        add(c);
        c.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                c.setEnabled(false);
                switch(keyword) 
                {
                    case "Abstract":
                        cAbstract.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Cemetery":
                        cCemetery.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Pharmacy":
                        cFarm.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Climbing":
                        cClmb.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    default:
                        addPart();
                        break;
                }
            }
        });

        d = new JToggleButton("D");
        d.setMargin(new Insets(0, 0, 0, 0));
        d.setBackground(new Color(105,40,33));
        d.setForeground(Color.white);
        d.setBounds(205, 315, 50, 50);
        d.setSize(30, 30);
        add(d);
        d.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                d.setEnabled(false);
                addPart();
            }
        });

        e1 = new JToggleButton("E");
        e1.setMargin(new Insets(0, 0, 0, 0));
        e1.setBackground(new Color(105,40,33));
        e1.setForeground(Color.white);
        e1.setBounds(240, 315, 50, 50);
        e1.setSize(30, 30);
        add(e1);
        e1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                e1.setEnabled(false);
                switch(keyword) 
                {
                    case "Cemetery":
                        e1Cemetery.setVisible(true);
                        e2Cemetery.setVisible(true);
                        e3Cemetery.setVisible(true);
                        numCorrect++;
                        numCorrect++;
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Nurse":
                        eNurse.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    default:   
                        addPart();
                        break;
                }   
            }
        });

        f = new JToggleButton("F");
        f.setMargin(new Insets(0, 0, 0, 0));
        f.setBackground(new Color(105,40,33));
        f.setForeground(Color.white);
        f.setBounds(275, 315, 50, 50);
        f.setSize(30, 30);
        add(f);
        f.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                f.setEnabled(false);
                addPart();
            }
        });
      
        g = new JToggleButton("G");
        g.setMargin(new Insets(0, 0, 0, 0));
        g.setBackground(new Color(105,40,33));
        g.setForeground(Color.white);
        g.setBounds(310, 315, 50, 50);
        g.setSize(30, 30);
        add(g);
        g.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                g.setEnabled(false);
                if(keyword == "Climbing") 
                {
                    gClmb.setVisible(true); 
                    numCorrect++;
                    checkComplete();
                }
                else
                    addPart();
            }
        });
      
        h = new JToggleButton("H");
        h.setMargin(new Insets(0, 0, 0, 0));
        h.setBackground(new Color(105,40,33));
        h.setForeground(Color.white);
        h.setBounds(345, 315, 50, 50);
        h.setSize(30, 30);
        add(h);
        h.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                h.setEnabled(false);
                if (keyword == "Pharmacy")
                {
                    hFarm.setVisible(true);
                    numCorrect++;
                    checkComplete();
                }
                else
                    addPart();
            }
        });
      
        i = new JToggleButton("I");
        i.setMargin(new Insets(0, 0, 0, 0));
        i.setBackground(new Color(105,40,33));
        i.setForeground(Color.white);
        i.setBounds(380, 315, 50, 50);
        i.setSize(30, 30);
        add(i);
        i.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                i.setEnabled(false);
                if (keyword == "Climbing")
                {
                    iClmb.setVisible(true);
                    i2Clmb.setVisible(true);
                    numCorrect++;
                    numCorrect++;
                    checkComplete();
                }   
                else
                     addPart();
            }
        });
      
        j = new JToggleButton("J");
        j.setMargin(new Insets(0, 0, 0, 0));
        j.setBackground(new Color(105,40,33));
        j.setForeground(Color.white);
        j.setBounds(415, 315, 50, 50);
        j.setSize(30, 30);
        add(j);
        j.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                j.setEnabled(false);
                addPart();
            }
        });

        k = new JToggleButton("K");
        k.setMargin(new Insets(0, 0, 0, 0));
        k.setBackground(new Color(105,40,33));
        k.setForeground(Color.white);
        k.setBounds(450, 315, 50, 50);
        k.setSize(30, 30);
        add(k);
        k.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            { 
                k.setEnabled(false);
                addPart();
            }
        });
      
        l = new JToggleButton("L");
        l.setMargin(new Insets(0, 0, 0, 0));
        l.setBackground(new Color(105,40,33));
        l.setForeground(Color.white);
        l.setBounds(485, 315, 50, 50);
        l.setSize(30, 30);
        add(l);
        l.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            { 
                l.setEnabled(false);
                if (keyword == "Climbing")
                {
                    lClmb.setVisible(true);
                    numCorrect++;
                    checkComplete();
                }
                else
                    addPart();
            }
        });

        m = new JToggleButton("M");
        m.setMargin(new Insets(0, 0, 0, 0));
        m.setBackground(new Color(105,40,33));
        m.setForeground(Color.white);
        m.setBounds(520, 315, 50, 50);
        m.setSize(30, 30);
        add(m);
        m.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                m.setEnabled(false);
                switch(keyword) 
                {
                    case "Cemetery":
                        mCemetery.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Pharmacy":
                        mFarm.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Climbing":
                        mClmb.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    default:
                        addPart();
                        break;
                }
            }
        });
      
        n = new JToggleButton("N");
        n.setMargin(new Insets(0, 0, 0, 0));
        n.setBackground(new Color(105,40,33));
        n.setForeground(Color.white);
        n.setBounds(100, 355, 50, 50);
        n.setSize(30, 30);
        add(n);
        n.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
               n.setEnabled(false);
               switch(keyword) 
               {
                    case "Nurse":
                        nNurse.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Climbing":
                        nClmb.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    default:
                        addPart();
                        break;
                }
            }
        });
      
        o = new JToggleButton("O");
        o.setMargin(new Insets(0, 0, 0, 0));
        o.setBackground(new Color(105,40,33));
        o.setForeground(Color.white);
        o.setBounds(135, 355, 50, 50);
        o.setSize(30, 30);
        add(o);
        o.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                o.setEnabled(false);
                addPart();
             }
        });

        p = new JToggleButton("P");
        p.setMargin(new Insets(0, 0, 0, 0));
        p.setBackground(new Color(105,40,33));
        p.setForeground(Color.white);
        p.setBounds(170, 355, 50, 50);
        p.setSize(30, 30);
        add(p);
        p.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                p.setEnabled(false);
                if (keyword == "Pharmacy")
                {
                    pFarm.setVisible(true);
                    numCorrect++;
                    checkComplete();
                }
                else
                     addPart();
            }
        });
      
        q = new JToggleButton("Q");
        q.setMargin(new Insets(0, 0, 0, 0));
        q.setBackground(new Color(105,40,33));
        q.setForeground(Color.white);
        q.setBounds(205, 355, 50, 50);
        q.setSize(30, 30);
        add(q);
        q.addActionListener(new ActionListener() 
        {
           @Override
           public void actionPerformed(ActionEvent e) 
           { 
                q.setEnabled(false);
                addPart();
           }
        });
      
        r = new JToggleButton("R");
        r.setMargin(new Insets(0, 0, 0, 0));
        r.setBackground(new Color(105,40,33));
        r.setForeground(Color.white);
        r.setBounds(240, 355, 50, 50);
        r.setSize(30, 30);
        add(r);
        r.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                r.setEnabled(false);
                switch(keyword) 
                {
                    case "Abstract":
                        rAbstract.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Cemetery":
                        rCemetery.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Pharmacy":
                        rFarm.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Nurse":
                        rNurse.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    default:
                        addPart();
                        break;
                }
            }
        });
      
        s = new JToggleButton("S");
        s.setMargin(new Insets(0, 0, 0, 0));
        s.setBackground(new Color(105,40,33));
        s.setForeground(Color.white);
        s.setBounds(275, 355, 50, 50);
        s.setSize(30, 30);
        add(s);
        s.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            { 
                s.setEnabled(false);
                switch(keyword)
                {
                    case "Abstract":
                        sAbstract.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Nurse":
                        sNurse.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    default:
                        addPart();
                        break;
                }
            }
        });

        t = new JToggleButton("T");
        t.setMargin(new Insets(0, 0, 0, 0));
        t.setBackground(new Color(105,40,33));
        t.setForeground(Color.white);
        t.setBounds(310, 355, 50, 50);
        t.setSize(30, 30);
        add(t);
        t.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                t.setEnabled(false);
                switch(keyword) 
                {
                    case "Abstract":
                        t1Abstract.setVisible(true);
                        t2Abstract.setVisible(true);
                        numCorrect++;
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Cemetery":
                        tCemetery.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    default:
                        addPart();
                        break;
                }
            }
        });
      
        u = new JToggleButton("U");
        u.setMargin(new Insets(0, 0, 0, 0));
        u.setBackground(new Color(105,40,33));
        u.setForeground(Color.white);
        u.setBounds(345, 355, 50, 50);
        u.setSize(30, 30);
        add(u);
        u.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                u.setEnabled(false);
                if (keyword == "Nurse") 
                {
                    uNurse.setVisible(true);
                    numCorrect++;
                    checkComplete();
                }
                else
                    addPart();
            }
        });
      
        v = new JToggleButton("V");
        v.setMargin(new Insets(0, 0, 0, 0));
        v.setBackground(new Color(105,40,33));
        v.setForeground(Color.white);
        v.setBounds(380, 355, 50, 50);
        v.setSize(30, 30);
        add(v);
        v.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            { 
               v.setEnabled(false);
               addPart();
            }
        });
      
        w = new JToggleButton("W");
        w.setMargin(new Insets(0, 0, 0, 0));
        w.setBackground(new Color(105,40,33));
        w.setForeground(Color.white);
        w.setBounds(415, 355, 50, 50);
        w.setSize(30, 30);
        add(w);
        w.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
               w.setEnabled(false);
               addPart();
            }
        });
      
        x = new JToggleButton("X");
        x.setMargin(new Insets(0, 0, 0, 0));
        x.setBackground(new Color(105,40,33));
        x.setForeground(Color.white);
        x.setBounds(450, 355, 50, 50);
        x.setSize(30, 30);
        add(x);
        x.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
               x.setEnabled(false);
               addPart();
            }
        });
      
        y = new JToggleButton("Y");
        y.setMargin(new Insets(0, 0, 0, 0));
        y.setBackground(new Color(105,40,33));
        y.setForeground(Color.white);
        y.setBounds(485, 355, 50, 50);
        y.setSize(30, 30);
        add(y);
        y.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                y.setEnabled(false);
                switch(keyword) 
                {
                    case "Cemetery":
                        yCemetery.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    case "Pharmacy":
                        yFarm.setVisible(true);
                        numCorrect++;
                        checkComplete();
                        break;
                    default:
                        addPart();
                        break;
                }
            }
        });
      
        z = new JToggleButton("Z");
        z.setMargin(new Insets(0, 0, 0, 0));
        z.setBackground(new Color(105,40,33));
        z.setForeground(Color.white);
        z.setBounds(520, 355, 50, 50);
        z.setSize(30, 30);
        add(z);
        z.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
               z.setEnabled(false);
               addPart();
            }
        });
    }
   
    //method: getPreferredSize
    //purpose: returns the preferred size for the window.
    @Override
    public Dimension getPreferredSize()
    {
       return new Dimension(600, 400);
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
   
    //method: checkComplete
    //purpose: check to see if the word is complete by
    //comparing the number of correct with number of letters
    //for the keyword. If word is complete, it will create and
    //jump to the next panel and also deleting this panel.
    public void checkComplete() 
    {
        if (numCorrect == numLetters)
        { 
           mainFrame.add(new GamePage2(mainFrame, score, keyword, audio));
           mainFrame.pack();
           try 
           {
              mainFrame.remove(thisPanel);
           }
           catch(Exception ex){};   
        }
    }
    
    //method: showHead
    //purpose: draws the head of the hangman
    public void showHead() 
    {
        head = true;
        repaint();
    }
    //method: show body
    //purpose: draws the body of the hangman
    public void showBody() 
    {
        body = true;
        repaint();
    }

    // method: showRightLeg
    // purpose: draws the right leg of the hangman
    public void showRightLeg() 
    {
        rightleg = true;
        repaint();
    }

    //method: showLeftLeg
    //purpose: draws the left leg of the hangman
    public void showLeftLeg() 
    {
        leftleg = true;
        repaint();
    }
   
   //method: showLeftArm
   //purpose: draws the left arm of the hangman
    public void showLeftArm() 
    {
        leftArm = true;
        repaint();
    }
   
    //method: showRightArm
    //purpose: draws the right arm of the hangman
    public void showRightArm() 
    {
        rightArm = true;
        repaint();
    }
    
    //method: addPart 
    //purpose: This method keep tracks of the player's score and
    //tries. It also prints out the appropriate hangman parts by calling 
    //other methods.
    public void addPart()
    {
        switch(tries) 
        {
            case 6:
                showHead();
                score = score - 10;
                scoreLabel.setText("Score: " + score);
                break;
            case 5:
                showBody();
                score = score - 10;
                scoreLabel.setText("Score: " + score);
                break;
            case 4:
                showLeftArm();
                score = score - 10;
                scoreLabel.setText("Score: " + score);
                break;
            case 3:
                showRightArm();
                score = score - 10;
                scoreLabel.setText("Score: " + score);
                break;
            case 2:
                showLeftLeg();
                score = score - 10;
                scoreLabel.setText("Score: " + score);
                break;
            case 1:
                showRightLeg();
                score = score - 10;
                scoreLabel.setText("Score: " + score);
                Timer delay = new Timer(1000, new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        mainFrame.add(new GamePage2(mainFrame, score, keyword, audio));
                        mainFrame.pack();
                        try 
                        {
                            mainFrame.remove(thisPanel);
                        }
                        catch(Exception ex){}
                    }
                });
                delay.setRepeats(false);
                delay.start();
                break;
        }
        tries--;
    }

    // method: paintComponent 
    // purpose: this method paints all the pictures graphics for the game. It has 
    // hidden images that are only set to visible when a boolean field is set to 
    // true. 
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //add gradient background
        Graphics2D g2d = (Graphics2D) g;
        int wid = getWidth();
        int hei = getHeight();
        Color color1 = new Color(46,212,216);
        Color color2 = new Color(19,77,79);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, hei, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, wid, hei);
        try 
        {
            emptyHangmanPic = ImageIO.read(new File("src\\HangmanRope.png"));
        } 
        catch (IOException e) {}
        g.drawImage(emptyHangmanPic, 412, 0, 30, 150, this);

        if (numLetters == 8) 
        {
            try 
            {
                dashed5 = ImageIO.read(new File("src\\dashedLine8.png"));
            } catch (IOException e) {}
            g.drawImage(dashed5, 0, 180, 350, 60, this);
        } 
        else 
        {
            try 
            {
                dashed8 = ImageIO.read(new File("src\\dashedLine5.png"));
            } 
            catch (IOException e) {}
            g.drawImage(dashed8, 0, 170, 300, 60, this);  
        }   

        //graphics
        if (head) 
        { 
            try 
            {
                stage1 = ImageIO.read(new File("src\\head.png"));
                stage1 = stage1.getScaledInstance(849, 849,  java.awt.Image.SCALE_SMOOTH);
            } 
            catch (IOException e) {}
            g.drawImage(stage1, 400, 100, 50, 25, this);
        }
        if (body) 
        { 
            try 
            {
                stage2 = ImageIO.read(new File("src\\body.png"));
                stage2 = stage2.getScaledInstance(600, 364,  java.awt.Image.SCALE_SMOOTH);
            } 
            catch (IOException e) {}
            g.drawImage(stage2, 400, 125, 50, 50, this);
        } 
        if (leftArm) 
        { 
            try 
            {
                stage3 = ImageIO.read(new File("src\\leftarm.png"));
                stage3 = stage3.getScaledInstance(590, 547,  java.awt.Image.SCALE_SMOOTH);
            } 
            catch (IOException e) {}
            g.drawImage(stage3, 350, 108, 50, 80, this);
        } 
        if (rightArm) 
        {  
            try 
            {
               stage4 = ImageIO.read(new File("src\\rightarm.png"));
               stage4 = stage4.getScaledInstance(590, 547,  java.awt.Image.SCALE_SMOOTH);
            } 
            catch (IOException e) {}
            g.drawImage(stage4, 450, 130, 60, 63, this);
        } 

        if (leftleg)
        { 
            try 
            {
               stage5 = ImageIO.read(new File("src\\leftleg.png"));
               stage5 = stage5.getScaledInstance(456, 427,  java.awt.Image.SCALE_SMOOTH);
            } 
            catch (IOException e) {}
            g.drawImage(stage5, 400, 175, 33, 90, this);
        }   
        if (rightleg) 
        { 
            try 
            {
               stage6 = ImageIO.read(new File("src\\rightleg.png"));
            } 
            catch (IOException e) {}
            g.drawImage(stage6, 433, 175, 72, 83, this);
        } 
    }   
}



