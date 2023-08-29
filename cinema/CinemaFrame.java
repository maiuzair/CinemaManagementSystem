package cinema;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CinemaFrame extends JFrame implements ActionListener{
    
    Container c;
    JPanel p1,p2;
    JLabel l1, li;
    JButton b1,b2;
    ImageIcon im = new ImageIcon(getClass().getResource("p.jpg"));
    
    Font myFont;
    
    CinemaFrame(){
        c = this.getContentPane();
        c.setLayout(null);
        
        super.setSize(600,600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        p1 = new JPanel();
        p2 = new JPanel();
        

        li = new JLabel(im);
        li.setSize(600, 600);
       
        l1 = new JLabel("CINEMA");
        l1.setBounds(250,220, 150,50);
        
         myFont = new Font("Serif", Font.BOLD, 18);
        l1.setFont(myFont);
        
        c.add(l1);
        
        b1 = new JButton("Admin");
        b2 = new JButton("User");
        p1.setLayout(new BorderLayout());
        p2.setLayout(new GridLayout(1,2));
        

        
        //p1.add(l1, BorderLayout.CENTER);
        
        p2.add(b1);
        p2.add(b2);
      
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
        
        c.add(p1, BorderLayout.CENTER);
        c.add(p2, BorderLayout.SOUTH);
        
        c.add(li);
        
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Admin"))
            {
                AdminFrame f = new AdminFrame();
                dispose();

            }
            else if(e.getActionCommand().equalsIgnoreCase("User"))
            {
                UserLoginFrame f = new UserLoginFrame();
                dispose();
            }
    }
    
    
}
