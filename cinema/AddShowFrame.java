
package cinema;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddShowFrame extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8, lTitle;
    JTextField t1,t2,t3,t4,t5,t6;
    JPanel p1,p2;
    JButton b1,b2;
    
    int[] day = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
    int[] month = {1,3,4,5,6,7,8,9,10,11,12};
    int[] year = {2020,2022,2023};
    
    JComboBox d,m,y;
    
    
    
    AddShowFrame(){
        super.setSize(600,600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBackground(Color.DARK_GRAY);
        super.setLayout(new BorderLayout());
        
        p1 = new JPanel();
        p2 = new JPanel();
        
       
        
//        lTitle = new JLabel("MOVIE");
        l1 = new JLabel("Screen no");
        l2 = new JLabel("Movie");
        l3 = new JLabel("Language");
        l4 = new JLabel("Genre");
        
        //d = new JComboBox(day);
        l5 = new JLabel("Show Date");
        l6 = new JLabel("Show Time");
        
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        
        
        b1 = new JButton("OK");
        b2 = new JButton("Home");

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
            Date d = new Date(01,01,2023);
            Time t = new Time(1,00,00);
            Screen s = new Screen(Integer.parseInt(t1.getText()),5,5,"2D");
            Movie m = new Movie(t2.getText(),t3.getText(),120,t4.getText(),d,"PG-13");
            ShowMovie sm = new ShowMovie(d, t, s, m);
            ShowMovie.writeToFile(sm);
            System.out.println(ShowMovie.readAllData());
            JOptionPane.showMessageDialog(new JFrame(), "Added Successfully");
            dispose();
            AdminFunctions f = new AdminFunctions();

        }
        else if(ae.getActionCommand().equalsIgnoreCase("Home"))
        {
            dispose();
        CinemaFrame frame = new CinemaFrame();       
        }

    }
}
