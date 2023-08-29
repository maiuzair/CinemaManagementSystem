
package cinema;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class UpdateEmployeeLeaves extends JFrame implements ActionListener{
    JLabel ls;
    JTextField ts;
    JLabel ln;
    JTextField tn;
    JButton back,update;
    
    JPanel p1,p3,p2;
    
    Employee temp;
    UpdateEmployeeLeaves(){

    super.setSize(600,600);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    super.setLayout(new FlowLayout());
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();

    update = new JButton("Update");
    super.add(p1);
    super.add(p2);
    super.add(p3);

    p1.setLayout(new GridLayout(2,2));
    p2.setLayout(new FlowLayout());
    p3.setLayout(new FlowLayout());

    ls = new JLabel("Enter Name: ");
    ts = new JTextField();
    ln = new JLabel("Enter New Leaves: ");
    tn = new JTextField();

    p1.add(ls);
    p1.add(ts);
    p1.add(ln);
    p1.add(tn);

    
    p3.add(update);
    back = new JButton("Back");
    p3.add(back);

    back.addActionListener(this);
    update.addActionListener(this);
    ts.addActionListener(this);
    super.setVisible(true);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Update")){
            Employee.updateEmployeeLeaves(ts.getText(),Integer.parseInt(tn.getText()));
            dispose();
            AdminFunctions frame = new AdminFunctions();
        }
    
        else if(e.getActionCommand().equals("Back")){
            dispose();
            AdminFunctions frame = new AdminFunctions();
        }
    }
}
