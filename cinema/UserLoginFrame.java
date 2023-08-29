
package cinema;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
// ------- Read all from file-------- when user log in to user functions -> quick tickets --> view movies
public class UserLoginFrame extends JFrame implements ActionListener {
    
JLabel homepage;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField pass;
    JButton b1,b2,b3;
    JPanel p1,p2,p3;
    
    UserLoginFrame(){
    super.setSize(600,600);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.setBackground(Color.DARK_GRAY);
    
    super.setLayout(new BorderLayout());
  
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    super.add(p1,BorderLayout.NORTH);
    super.add(p2,BorderLayout.CENTER);
    super.add(p3,BorderLayout.SOUTH);
    
    p1.setLayout(new FlowLayout());
    p2.setLayout(new GridLayout(2,2));
    p3.setLayout(new FlowLayout());
    
    homepage = new JLabel("CUSTOMER LOGIN");
    
    p1.add(homepage);
    
    l1 = new JLabel("USERNAME: ");
    l2 = new JLabel("PASSWORD: ");
    t1 = new JTextField();
    pass = new JPasswordField();
    
    p2.add(l1);p2.add(t1);
    p2.add(l2);p2.add(pass);

    b1 = new JButton("Sign Up");
    b2 = new JButton("Log In");
    b3 = new JButton("Back");
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    p3.add(b1);p3.add(b2);p3.add(b3);
    super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equalsIgnoreCase("Sign Up")){
       dispose();
       UserSignupFrame sud = new UserSignupFrame();
       }
       else if(e.getActionCommand().equalsIgnoreCase("Log In")){
        ArrayList<Customer> list = new ArrayList();
        list = Customer.readAllData();
        int flag=0;
        for(Customer i: list){
            if(i.getUserName().equals(t1.getText())&&i.getPassword().equals(pass.getText())){
                //JOptionPane.showMessageDialog(new JFrame(), "LOGGED IN");
                dispose();
                UserFunctionFrame frame = new UserFunctionFrame();
                flag++;
            }
        }
        if(flag==0)
        JOptionPane.showMessageDialog(new JFrame(), "Wrong Username or Password");
        }
        else if(e.getActionCommand().equalsIgnoreCase("Back")){ 
            CinemaFrame fr = new CinemaFrame();
            dispose();
       }
    }
}
