package cinema;
import java.io.Serializable;
import java.io.*;
import java.io.File;
import java.util.ArrayList;
public class Employee implements Payable, Serializable   {
    private int employeeID;
    private String Name;
    private String CNIC;
    private String phone;
    private String email;
    private Date hireDate;
    private double salary;
    private int leaves;

    public Employee(int employeeID, String Name, String CNIC, String phone, String email, Date hireDate, double salary, int leaves) {
        this.employeeID = employeeID;
        this.Name = Name;
        this.CNIC = CNIC;
        this.phone = phone;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
        this.leaves = leaves;
    }

    
    
    
    //--------copy constructor
    public Employee(Employee e){
        
    }


    @Override
    public double getPaymentAmount() {
    if(leaves>5)
            salary -= salary*0.5;
        
        return salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getLeaves() {
        return leaves;
    }

    public void setLeaves(int leaves) {
        this.leaves = leaves;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ",Name=" + Name + ",\n CNIC=" + CNIC + ", phone=" + phone + ", email=" + email + ",\n hireDate=" + hireDate  + ",\n salary=" + salary + ", leaves=" + leaves + '}';
    }

    
    
    //--------------------------File Handling------------------
    
        public static void writeToFile(Employee s) //throws Exception
    {
        try{
            File f = new File("Employee.txt");
            ObjectOutputStream oos;
            if(f.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(f,true));
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(s);
            oos.close();
            }
            catch(IOException e){
                System.out.println("Error File Writing");
            }
    }
    
    public static void readFromFile(){
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Employee.txt"));
            while(true)
            {
                Employee s = (Employee) ois.readObject();
                System.out.println(s.toString());
            }
            //ois.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("Class Not Found");
        }
        catch(EOFException e){
            return;
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
        
    }
    
    public static ArrayList<Employee> readAllData(){
        
        ArrayList <Employee> studentList = new ArrayList();
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Employee.txt"));
            while(true)
            {
                studentList.add((Employee) ois.readObject());
                //System.out.println(s.toString());
            }                 
            //ois.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("Class Not Found");
        }
        catch(EOFException e){
            return studentList;
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
        
        return studentList;
    }
    
    public static void display(){
        
        ArrayList <Employee> studentList = new ArrayList();
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Employee.txt"));
            while(true)
            {
                studentList.add((Employee) ois.readObject());
            }   

        }
        catch(ClassNotFoundException e){
            System.out.println("Class Not Found");
        }
        catch(EOFException e){
            
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
        
        System.out.println(studentList);
       
    }
    
    public static boolean searchEmployee(String name){
        
        ArrayList<Employee> list = readAllData();
//        for(int i = 0; i<list.size();i++)
//        {
//            if(list.get(i).getName().equalsIgnoreCase(name))
//            {
//                return true;
//            }
//        }

        for(Employee i: list){
           if(i.getName().equals(name))
               return true;
        }
        return false;
      
    }
    
    public static void EmptyFile(){
       try{
            
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Employee.txt"));
        oos.close();
        }
        catch(IOException e){
            System.out.println("Error File Writing");
        } 
    }
    
    public static void deleteEmployee(String username){
        
        ArrayList<Employee> list = readAllData();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).getName().equalsIgnoreCase(username))
            {
                list.remove(list.get(i));
            }
        }

        try{
            
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Employee.txt"));

            for(Employee i: list){              
                oos.writeObject(i);
            }
            oos.close();
        }
        catch(IOException e){
            System.out.println("Error File Writing");
        }
    }
    
    public static void updateEmployeeLeaves(String name, int l){
        ArrayList<Employee> list = readAllData();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).getName().equalsIgnoreCase(name))
            {
                list.get(i).setLeaves(l);
            }
        }
        
        try{
            
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Employee.txt"));
        
        for(Employee i: list){              
                oos.writeObject(i);
            }
        oos.close();
        }
        catch(IOException e){
            System.out.println("Error File Writing");
        }
    }

    
    
    
    
}
