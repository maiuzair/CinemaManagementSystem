package cinema;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class QuickTicketFrame extends JFrame implements ActionListener,ItemListener{
    JPanel p1,p2,p3;
    JLabel l1;
    JTextField f1,f2;
    JComboBox cb1;
    JButton b1,bBack;
    Font myFont;
    ArrayList<ShowMovie> temp;
    //ShowMovie[] shows;
    //Movie[] movies;
    String[] moviesStr;
    String[] timeStr;
    String[] dateStr;
    Time[] time;
    Date[] dates;
    
    QuickTicketFrame(){
        super.setSize(600,600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(5,1));
        p3.setLayout(new FlowLayout());
        myFont = new Font("Serif", Font.BOLD, 18);

        l1 = new JLabel("QUICK TICKETS");
        l1.setFont(myFont);
        
        
        temp = ShowMovie.readAllData();
        moviesStr = new String[temp.size()];
        timeStr = new String[temp.size()];
        dateStr = new String[temp.size()];
        
        
        for(int i = 0; i<temp.size();i++){
            moviesStr[i] = temp.get(i).getMovie().getMovieName();
            timeStr[i] = temp.get(i).getShowTime().toString();
            dateStr[i] = temp.get(i).getShowDate().toString();
        }

        cb1 = new JComboBox(moviesStr);
        
        f1 = new JTextField("Date");
        f1.setEditable(false);
        f2 = new JTextField("Time");
        f2.setEditable(false);
        
        
        b1 = new JButton("GetTickets");
        bBack = new JButton("Back");
        
        
        super.add(p1, BorderLayout.NORTH);
        super.add(p2, BorderLayout.CENTER);
        super.add(p3, BorderLayout.SOUTH);

        p1.add(l1);

        p2.add(cb1);
        p2.add(f1);
        p2.add(f2);

        p3.add(b1);
        p3.add(bBack);
        
        cb1.addItemListener(this);

        b1.addActionListener(this);
        cb1.addActionListener(this);
        bBack.addActionListener(this);
        
        super.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("GetTickets"))
        {
            SeatSelectionFrame s = new SeatSelectionFrame(cb1.getSelectedItem().toString());
            dispose();

        }
        else if(ae.getActionCommand().equalsIgnoreCase("Back"))
        {
            UserFunctionFrame f = new UserFunctionFrame();
            dispose();
        }
//        if(cb1.isCursorSet()){
//          f1.setText(dateStr[cb1.getSelectedIndex()]);
//          f2.setText(timeStr[cb1.getSelectedIndex()]);  
//        }

    }
    
    @Override
        public void itemStateChanged(ItemEvent ie) {
            if(ie.getStateChange() == ItemEvent.SELECTED){
                f1.setText(dateStr[cb1.getSelectedIndex()]);
                f2.setText(timeStr[cb1.getSelectedIndex()]);
            }
        }
        
        
 
}
