
package cinema;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddEmployeeFrame extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JPanel p1,p2;
    JButton b1,b2;
    
    AddEmployeeFrame(){
        super.setSize(600,600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBackground(Color.DARK_GRAY);
        super.setLayout(new BorderLayout());
        
        p1 = new JPanel();
        p2 = new JPanel();
        
        //lTitle = new JLabel("Employee");
        l1 = new JLabel("ID");
        l2 = new JLabel("Name");
        l3 = new JLabel("CNIC");
        l4 = new JLabel("Phone");
        l5 = new JLabel("Email");
        l6 = new JLabel("Hire Date");
        l7 = new JLabel("Salary");
        l8 = new JLabel("Leave");
        
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();

        b1 = new JButton("OK");
        b2 = new JButton("Back");

        super.add(p1, BorderLayout.CENTER);
        super.add(p2, BorderLayout.SOUTH);

        p1.setLayout(new GridLayout(8,2));
        p2.setLayout(new FlowLayout());
        
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
        
        p1.add(l7);
        p1.add(t7);
        
        p1.add(l8);
        p1.add(t8);

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

            Employee m = new Employee(Integer.parseInt(t1.getText()), t2.getText(),  t3.getText(), t4.getText(), t5.getText(), d, Double.parseDouble(t7.getText()), Integer.parseInt(t8.getText()));
            Employee.writeToFile(m);
            System.out.println(Employee.readAllData());
            JOptionPane.showMessageDialog(new JFrame(), "Added Successfully");
            AdminFunctions f = new AdminFunctions();
            dispose();

        }
        else if(ae.getActionCommand().equalsIgnoreCase("Back"))
        {
            AdminFunctions frame = new AdminFunctions();;
            dispose();
        }

    }
}
