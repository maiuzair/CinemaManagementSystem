package cinema;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AdminFunctions extends JFrame implements ActionListener {
    JLabel jLabel;
    JButton bMovie,bShow, vm, vs,vc,e,ve,de,ue,se, bseat, logout;
    JPanel p1,p2,p3,p4,p5,p6,p7,p8;
    Booking b;
    AdminFunctions(){
        
    b = new Booking();
    
    super.setSize(600,600);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.setBackground(Color.DARK_GRAY);
    
    super.setLayout(new GridLayout(9,1));
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    p4 = new JPanel();
    p5 = new JPanel();
    p6 = new JPanel();
    p7 = new JPanel();
    p8 = new JPanel();
    
    super.add(p1);
    super.add(p2);
    super.add(p3);
    super.add(p4);
    super.add(p5);
    super.add(p6);
    super.add(p7);
    super.add(p8);
    p1.setLayout(new FlowLayout());
    p2.setLayout(new FlowLayout());
    p3.setLayout(new FlowLayout());
    p4.setLayout(new FlowLayout());
    p5.setLayout(new FlowLayout());
    p6.setLayout(new FlowLayout());
    p7.setLayout(new FlowLayout());
    p8.setLayout(new FlowLayout());
    
    
    jLabel = new JLabel("Admin Portal");
    p1.add(jLabel);
    
    bMovie = new JButton("Add Movies");
    bShow = new JButton("Add Shows");
    vm = new JButton("View Movies");
    vs = new JButton("View Shows");
    vc = new JButton("View Customer");
    e = new JButton("Add Employee");
    ve = new JButton("View Employee");
    de = new JButton("Delete Employee");
    ue = new JButton("Update Employee");
    se = new JButton("Search Employee");
    bseat = new JButton("Booked Seats");
    
    
    logout = new JButton("Log Out");
    
    p2.add(bMovie);
    p3.add(bShow);
    p3.add(vm);
    p3.add(vs);
    p3.add(vc);
    p3.add(e);
    p3.add(ve);
    p3.add(de);
    p3.add(ue);
    p3.add(se);
    p4.add(bseat);
//    p3.add(bShow);
    p4.add(logout);
    
    bMovie.addActionListener(this);
    bShow.addActionListener(this);
    vm.addActionListener(this);
    vs.addActionListener(this);
    vc.addActionListener(this);
    e.addActionListener(this);
    ve.addActionListener(this);
    de.addActionListener(this);
    ue.addActionListener(this);
    se.addActionListener(this);
    bseat.addActionListener(this);
    logout.addActionListener(this);
    super.setVisible(true);
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Movies")){
            dispose();
            AddMovieFrame vrf = new AddMovieFrame();
        }
        else if(e.getActionCommand().equals("Add Shows")){
            dispose();
            AddShowFrame vdf = new AddShowFrame();        
        }
        else if(e.getActionCommand().equals("View Movie ")){
            dispose();
            ViewMoviesFrame vdf = new ViewMoviesFrame();        
        }
        else if(e.getActionCommand().equals("View Shows")){
            dispose();
            ViewShowFrame vdf = new ViewShowFrame();        
        }
        else if(e.getActionCommand().equals("View Customer")){
            dispose();
            ViewCustomerFrame vdf = new ViewCustomerFrame();        
        }
        else if(e.getActionCommand().equals("Add Employee")){
            dispose();
            AddEmployeeFrame vdf = new AddEmployeeFrame();        
        }
        else if(e.getActionCommand().equals("View Employee")){
            dispose();
            ViewEmployeeFrame vdf = new ViewEmployeeFrame();        
        }
        else if(e.getActionCommand().equals("Delete Employee")){
            dispose();
            DeleteEmployeeFrame vdf = new DeleteEmployeeFrame();        
        }
        
        else if(e.getActionCommand().equals("Update Employee")){
            dispose();
            UpdateEmployeeLeaves vdf = new UpdateEmployeeLeaves();        
        }
        else if(e.getActionCommand().equals("Search Employee")){
            dispose();
            SearchEmployeeFrame vdf = new SearchEmployeeFrame();        
        }
        else if(e.getActionCommand().equalsIgnoreCase("Booked Seats")){
   
            int i = b.BookedSeat("DSA");;
            JOptionPane.showMessageDialog(new JFrame(),i+"");
            dispose();
            SearchEmployeeFrame vdf = new SearchEmployeeFrame();        
        }
        else if(e.getActionCommand().equals("Log Out")){
            dispose();
            CinemaFrame frame = new CinemaFrame();
        }
        else if(e.getActionCommand().equals("Log Out")){
            dispose();
            CinemaFrame frame = new CinemaFrame();
        }
        
    }
}
