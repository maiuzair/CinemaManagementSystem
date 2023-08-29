package cinema;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatSelectionFrame extends JFrame implements ActionListener{
    
    JPanel p1, p2,p3;
    JLabel l1,l2,l3;
    JButton bBack,bOk;
    ButtonGroup bg;
    JButton b1,b2;
    JCheckBox [][] cbArray;
    Font myFont;
    
    static double earning;
    double cost;
   
    ShowMovie temp;
    String movieStr;
    SeatSelectionFrame(String s){
        movieStr = s;
        cost = 0;
        super.setSize(600,600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        
        
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(5,5));
        p3.setLayout(new FlowLayout());
        super.add(p1, BorderLayout.NORTH);
        super.add(p2, BorderLayout.CENTER);
        super.add(p3, BorderLayout.SOUTH);
        
        myFont = new Font("Serif", Font.BOLD, 50);

        l1 = new JLabel("Seat Selection");
        l1.setFont(myFont);

        l2 = new JLabel();
        
        ButtonGroup bg = new ButtonGroup();
        b1 = new JButton("Silver");
        b2 = new JButton("Gold");
        bg.add(b1);
        bg.add(b2);
        p1.add(l1);
        p1.add(l2);
        p1.add(b1);
        p1.add(b2);

        temp = ShowMovie.searchShowMovie(movieStr);
        
        cbArray = new JCheckBox[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cbArray[i][j] = new JCheckBox();
                p2.add(cbArray[i][j]);
                cbArray[i][j].setEnabled(false);
                if(temp.getScreen().seats[i][j].seatStatus == true)
                    cbArray[i][j].setForeground(Color.DARK_GRAY);
                }
        }
        
        
        

        bOk = new JButton("OK");
        bBack = new JButton("Back");
        p3.add(bOk);
        p3.add(bBack);
        
        bOk.addActionListener(this);
        bBack.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        super.setVisible(true);

    }
    

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equalsIgnoreCase("Silver"))
        {

            for(int j = 0; j<5;j++){
                cbArray[4][j].setEnabled(false);    
            }
            
            for(int i = 0; i<5-1; i++){
                for(int j = 0; j<5;j++){
                    cbArray[i][j].setEnabled(true);
                }
            }
            
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(temp.getScreen().seats[i][j].seatStatus == true){
                        cbArray[i][j].setEnabled(false);
                        //cbArray[i][j].setBackground(Color.GRAY);
                    }
                }
            }

        }
        else if(ae.getActionCommand().equalsIgnoreCase("Gold"))
        {
            for(int i = 0; i<5-1; i++){
                for(int j = 0; j<5;j++){
                    cbArray[i][j].setEnabled(false);
                }
            }
            
            for(int j = 0; j<5;j++){
                cbArray[4][j].setEnabled(true);
                
            }
            
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(temp.getScreen().seats[i][j].seatStatus == true){
                        cbArray[i][j].setEnabled(false);
                        //cbArray[i][j].setBackground(Color.GRAY);
                    }
                }
            }

        }
        else if(ae.getActionCommand().equalsIgnoreCase("Ok"))
        {
            for(int i = 0; i<5; i++){
                for(int j = 0; j<5;j++){
                    if(cbArray[i][j].isSelected()){
                        cost += ShowMovie.searchShowMovie(movieStr).getScreen().seats[i][j].getSeatCost();
                        
                        ShowMovie.updateShowSeat(movieStr, i, j);
                    }
                }
            }
            
            
            earning += cost;

            JOptionPane.showMessageDialog(new JFrame(), "Booked\nCost: " + cost);
            
            QuickTicketFrame q = new QuickTicketFrame(); 
            dispose();
            
        }

        else if(ae.getActionCommand().equalsIgnoreCase("Back"))
        {
            QuickTicketFrame q = new QuickTicketFrame(); 
            dispose();
        }
                    
    }
    
}
