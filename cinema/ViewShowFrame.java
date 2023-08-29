
package cinema;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class ViewShowFrame extends JFrame implements ActionListener {
    JLabel jLabel;
    JButton back;
    JTextArea ta;
    JScrollPane sp;
    
    JPanel p1,p3,p2;
    
    ArrayList<ShowMovie> list;
    ViewShowFrame(){

    super.setSize(600,600);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    super.setLayout(new GridLayout(3,1));
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();

    super.add(p1);
    super.add(p2);
    super.add(p3);

    p1.setLayout(new FlowLayout());
    p2.setLayout(new FlowLayout());
    p3.setLayout(new FlowLayout());


    jLabel = new JLabel("Shows");
    p1.add(jLabel);
    
    list = ShowMovie.readAllData();
    
    ta = new JTextArea();
   
    ta.setText(ta.getText()+" "+list.toString());
    ta.setEditable(false);
   
    sp = new JScrollPane(ta);
    sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    p2.add(sp);
    
    back = new JButton("Back");
    p3.add(back);
    
    back.addActionListener(this);
    super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Back")){
            dispose();
            UserFunctionFrame frame = new UserFunctionFrame();
        }
    }
}
