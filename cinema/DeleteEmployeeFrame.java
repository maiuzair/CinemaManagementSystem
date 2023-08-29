
package cinema;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class DeleteEmployeeFrame extends JFrame implements ActionListener {
    JLabel ls;
    JTextField ts;
    JButton back,search;
    
    
    JPanel p1,p3,p2;
    
    Employee temp;
    DeleteEmployeeFrame(){

    super.setSize(600,600);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    super.setLayout(new FlowLayout());
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();

    search = new JButton("Search");
    super.add(p1);
    super.add(p2);
    super.add(p3);

    p1.setLayout(new GridLayout(1,2));
    p2.setLayout(new FlowLayout());
    p3.setLayout(new FlowLayout());

    ls = new JLabel("Enter Name: ");
    ts = new JTextField();

    p1.add(ls);
    p1.add(ts);

    
    p3.add(search);
    back = new JButton("Back");
    p3.add(back);

    back.addActionListener(this);
    search.addActionListener(this);
    ts.addActionListener(this);
    super.setVisible(true);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Delete")){
            Employee.deleteEmployee(ts.getText());
            dispose();
            AdminFunctions frame = new AdminFunctions();
        }
    
        else if(e.getActionCommand().equals("Back")){
            dispose();
            AdminFunctions frame = new AdminFunctions();
        }
    }
}
