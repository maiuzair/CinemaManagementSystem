package cinema;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UserFunctionFrame extends JFrame implements ActionListener {
    JLabel jLabel;
    JButton bMovie,bShow,vs,logout;
    
    JPanel p1,p2,p3,p4,p5;
    UserFunctionFrame(){
        
    super.setSize(600,600);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    super.setLayout(new GridLayout(5,1));
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    p4 = new JPanel();
    p5 = new JPanel();
    
    super.add(p1);
    super.add(p2);
    super.add(p3);
    super.add(p4);
    super.add(p5);
    p1.setLayout(new FlowLayout());
    p2.setLayout(new FlowLayout());
    p3.setLayout(new FlowLayout());
    p4.setLayout(new FlowLayout());
    p5.setLayout(new FlowLayout());
    
    jLabel = new JLabel("User Portal");
    p1.add(jLabel);
    
    bMovie = new JButton("View Movies");
    vs = new JButton("View Shows");
    bShow = new JButton("Quick Tickets");
    
    logout = new JButton("Log Out");
    
    p2.add(bMovie);
    p3.add(vs);
    p4.add(bShow);
    p5.add(logout);
    
    bMovie.addActionListener(this);
    bShow.addActionListener(this);
    vs.addActionListener(this);
    logout.addActionListener(this);
    super.setVisible(true);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("View Movies")){  
            ViewMoviesFrame m = new ViewMoviesFrame();
            dispose();
        }
        else if(e.getActionCommand().equals("View Shows")){
           
            ViewShowFrame q = new ViewShowFrame(); 
            dispose();
        }
        else if(e.getActionCommand().equals("Quick Tickets")){
           
            QuickTicketFrame q = new QuickTicketFrame(); 
            dispose();
        }
        else if(e.getActionCommand().equals("Log Out")){
            
            CinemaFrame frame = new CinemaFrame();
            dispose();
        }
    }
}
