/***************************************************************
* file: GamePage3.java
* author: Zhen Liu, Kaythari Phon, Nam Huynh, Dulce Nava
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project Version 1.2
* date last modified: 10/23/2016
*
* purpose: this class generates the Sudoku game.
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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class GamePage3 extends JPanel
{
    private final int GRID_SIZE = 9;
    private int score, sudokuScore;
    private final String keyword;
    private int hour, minute, second, month, day, year;
    
    private final JFrame mainFrame;
    private final JPanel thisPanel, sudoku;
    private final JToggleButton submit, quit;
    private final JLabel scoreLabel, scoreLabel2, gameLabel;
    private JLabel clockLabel, dateLabel;
    private Calendar cal; 
    private final SudokuField[][] boxes;
    
    private final AudioClip audio;
    
    private final String[] monthNames;
    private final int[][] soln = {{8, 3, 5, 4, 1, 6, 9, 2, 7},
                                  {2, 9, 6, 8, 5, 7, 4, 3, 1},
                                  {4, 1, 7, 2, 9, 3, 6, 5, 8},
                                  {5, 6, 9, 1, 3, 4, 7, 8, 2},
                                  {1, 2, 3, 6, 7, 8, 5, 4, 9},
                                  {7, 4, 8, 5, 2, 9, 1, 6, 3},
                                  {6, 5, 2, 7, 8, 1, 3, 9, 4},
                                  {9, 8, 1, 3, 4, 5, 2, 7, 6},
                                  {3, 7, 4, 9, 6, 2, 8, 1, 5}};
    
    private final boolean[][] given = {{true, false, false, true, false, true, false, false, true},
                                   {false, false, false, false, false, false, true, false, false},
                                   {false, true, false, false, false, false, true, true, false},
                                   {true, false, true, false, true, false, true, true, false},
                                   {false, false, false, false, true, false, false, false, false},
                                   {false, true, true, false, true, false, true, false, true},
                                   {false, true, true, false, false, false, false, true, false},
                                   {false, false, true, false, false, false, false, false, false},
                                   {true, false, false, true, false, true, false, false, true}};

    //method: GamePage3
    //purpose: this constructor initialize all the field variables and
    //call the drawSudoku function.
    public GamePage3(JFrame mf, int lastScore, String k, AudioClip c)
    {
        mainFrame = mf;
        thisPanel = this;
        
        score = lastScore;
        sudokuScore = 540;
        keyword = k;
        
        audio = c;
        
        setLayout(null);
        

        //Submit Button
        submit = new JToggleButton("Submit");
        submit.setBackground(Color.WHITE);
        submit.setBounds(500, 330, 250, 250);
        submit.setSize(80, 30);
        submit.setToolTipText("Click this button to submit solution");
        add(submit);
        submit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                submit.setSelected(false);
                checkInput();
            }
        });
        
        //Quit Button
        quit = new JToggleButton("Quit");
        quit.setBackground(Color.WHITE);
        quit.setBounds(500, 365, 250, 250);
        quit.setSize(80, 30);
        quit.setToolTipText("Click this button to quit game");
        add(quit);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    mainFrame.add(new ResultPage(mainFrame, score, keyword, audio));
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
        
        //Score Labels
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setBackground(Color.WHITE);
        scoreLabel.setForeground(Color.BLACK );
        scoreLabel.setBounds(450, 25, 100, 100);
        scoreLabel.setSize(80, 30);
        scoreLabel.setFont(new Font("", Font.BOLD, 12));
        add(scoreLabel);  
        
        scoreLabel2 = new JLabel("Sudoku Score: " + sudokuScore);
        scoreLabel2.setBackground(Color.WHITE);
        scoreLabel2.setForeground(Color.BLACK );
        scoreLabel2.setBounds(450, 50, 100, 100);
        scoreLabel2.setSize(150, 30);
        scoreLabel2.setFont(new Font("", Font.BOLD, 12));
        add(scoreLabel2);
        
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
            public void actionPerformed(ActionEvent e) 
            {
                updateTime();
                clockLabel.setText(String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second));
                dateLabel = new JLabel(monthNames[month] + " " + day + ", " + year);
                repaint();
            }
        }).start();
        
        
        
        //Game Name Label
        gameLabel = new JLabel("Sudoku");
        gameLabel.setFont(new Font("Chiller", Font.BOLD, 75));
        gameLabel.setBounds(415, 65, 250, 250);
        gameLabel.setForeground(Color.BLACK);
        add(gameLabel);
        
        //Initialize Sudoku Board
        sudoku = new JPanel();
        sudoku.setBounds(10, 10, 380, 380);       
        sudoku.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        add(sudoku);
        
        boxes = new SudokuField[GRID_SIZE][GRID_SIZE];
        for(int i = 0; i < GRID_SIZE; i++)
        {
            for(int j = 0; j < GRID_SIZE; j++)
            {
                boxes[i][j] = new SudokuField(mainFrame); 
            }
        }
        drawSudoku();
    }
    
    //method: checkComplete
    //purpose: this method checks if all the input values
    //are correct and return true or false base on completion.
    private boolean checkComplete()
    {
        for(int i = 0; i < GRID_SIZE; i++)
        {
            for(int j = 0; j < GRID_SIZE; j++)
            {
                if(!boxes[i][j].isCorrect())
                    return false;
            }
        }
        return true;
    }
    
    //method: checkInput
    //purpose: this method reads in all the input values and
    //save it in the SudokuField class. It also deduct point
    //off the points if input is incorrect.
    private void checkInput()
    {
        for(int i = 0; i < GRID_SIZE; i++)
        {
            for(int j = 0; j < GRID_SIZE; j++)
            {
                try
                {
                    boxes[i][j].setNum(Integer.parseInt(boxes[i][j].getText()));
                    if(boxes[i][j].getNum() == soln[i][j])
                        boxes[i][j].setCorrect(true);
                    else
                    {
                        boxes[i][j].setCorrect(false);
                        if(!boxes[i][j].isPointTaken())
                        {
                            sudokuScore -= 10;
                            boxes[i][j].setPointTaken(true);
                        }   
                    }  
                }
                catch(NumberFormatException ex)
                {
                        boxes[i][j].setCorrect(false);
                        if(!boxes[i][j].isPointTaken())
                        {
                            sudokuScore -= 10;
                            boxes[i][j].setPointTaken(true);
                        }
                }
            }
        }
        if(checkComplete())
        {
            try
            {
                JOptionPane.showMessageDialog(mainFrame,
                        "Good job!",
                        "Correct",
                        JOptionPane.INFORMATION_MESSAGE);
                
                mainFrame.add(new ResultPage(mainFrame, score + sudokuScore, keyword, audio));
                mainFrame.pack();
                mainFrame.remove(thisPanel);
            }
            catch(Exception ex){}

        }
        else
        {
            JOptionPane.showMessageDialog(mainFrame,
                "Your solution is wrong!",
                "Incorrect",
                JOptionPane.INFORMATION_MESSAGE);
            scoreLabel2.setText("Sudoku Score: " + sudokuScore);
            drawSudoku();
        }
    }
    
    //method: drawSudoku
    //purpose: this method prints the sudoku board to the
    //screen.
    private void drawSudoku()
    {
        for(int i = 0; i < GRID_SIZE; i++)
        {
            for(int j = 0; j < GRID_SIZE; j++)
            {
                if(given[i][j])
                {  
                    boxes[i][j].setText(Integer.toString(soln[i][j]));
                    boxes[i][j].setForeground(Color.RED);
                    boxes[i][j].setEditable(false);
                    boxes[i][j].setCorrect(true);
                    boxes[i][j].setNum(soln[i][j]);
                }
                else
                {
                    if(boxes[i][j].hasSetNum())
                        boxes[i][j].setText(Integer.toString(boxes[i][j].getNum()));
                    boxes[i][j].setForeground(Color.BLUE);
                    boxes[i][j].setEditable(true);
                }
               
                switch(i)
                {
                    case 2:
                        if(j == 2 || j == 5)
                            boxes[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, Color.GRAY.darker()));
                        else
                            boxes[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, Color.GRAY.darker()));
                        break;
                    case 5:
                        if(j == 2 || j == 5)
                            boxes[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, Color.GRAY.darker()));
                        else
                            boxes[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, Color.GRAY.darker()));
                        break;
                    default:
                        if(j == 2 || j == 5)
                            boxes[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 3, Color.GRAY.darker()));
                        else
                            boxes[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY.darker()));
                        break;
                }
                sudoku.add(boxes[i][j]);
            }  
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
    
    //method: getPreferredSize
    //purpose: returns the preferred size for the window.
    @Override
    public Dimension getPreferredSize()
    {
       return new Dimension(600, 400);
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
}
