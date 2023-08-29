
package cinema;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMovieFrame extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8, lTitle;
    JTextField t1,t2,t3,t4,t5,t6;
    JPanel p1,p2;
    JButton b1,b2;
    
    AddMovieFrame(){
        super.setSize(600,600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBackground(Color.DARK_GRAY);
        super.setLayout(new BorderLayout());
        
        p1 = new JPanel();
        p2 = new JPanel();
        
        lTitle = new JLabel("MOVIE");
        l1 = new JLabel("Name");
        l2 = new JLabel("Language");
        l3 = new JLabel("Minutes");
        l4 = new JLabel("Genre");
        l5 = new JLabel("Release Date: ");
        l6 = new JLabel("Rating");
        
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        
        
        b1 = new JButton("OK");
        b2 = new JButton("Back");

        super.add(p1, BorderLayout.CENTER);
        super.add(p2, BorderLayout.SOUTH);

    
        p1.setLayout(new GridLayout(6,2));
        p2.setLayout(new GridLayout(1,2));
        
        //p1.add(lTitle);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);

        p1.add(l3);
        p1.add(t3);
        p1.add(l4);
        p1.add(t4);
        
        p1.add(l5);
        p1.add(t5);
        
        p1.add(l6);
        p1.add(t6);

        p2.add(b1);
        p2.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);

        super.setVisible(true); 
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("OK"))
        {
            Date d = new Date(04,05,2022);
            
            Movie m = new Movie(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()), t4.getText(), d, t6.getText());
            Movie.writeToFile(m);
            System.out.println(Movie.readAllData());
            JOptionPane.showMessageDialog(new JFrame(), "Added Successfully");
            UserFunctionFrame f = new UserFunctionFrame();
            dispose();

        }
        else if(ae.getActionCommand().equalsIgnoreCase("Back"))
        {
            AdminFunctions frame = new AdminFunctions();;
            dispose();
        }

    }
    
    
}
