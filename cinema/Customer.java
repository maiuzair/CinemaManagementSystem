package cinema;
import java.io.Serializable;
import java.io.*;
import java.io.File;
import java.util.ArrayList;
public class Customer extends User implements Serializable {
    //private boolean membership;
    
    Booking booking;
    
    public Customer() {
    }

    public Customer(String userName, String password, String email, String phone) {
        super(userName, password, email, phone);

           booking = new Booking(); 
    }


    @Override
    public String toString() {
        return "Customer{"  + super.toString() + '}';
    }
    
    
    //--------------------------File Handling------------------
    
    public static void writeToFile(Customer s) //throws Exception
    {
        try{
            File f = new File("Customer.txt");
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
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Customer.txt"));
            while(true)
            {
                Customer s = (Customer) ois.readObject();
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
    
    public static ArrayList<Customer> readAllData(){
        
        ArrayList <Customer> list = new ArrayList();
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Customer.txt"));
            while(true)
            {
                list.add((Customer) ois.readObject());
                //System.out.println(s.toString());
            }                 
            //ois.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("Class Not Found");
        }
        catch(EOFException e){
            return list;
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
        
        return list;
    }
    
    public static void display(){

        ArrayList <Customer> list = new ArrayList();
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Customer.txt"));
            while(true)
            {
                list.add((Customer) ois.readObject());
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
        
        System.out.println(list);
       
    }
    
    public static Booking searchCustomer(String name){
        ArrayList<Customer> list = readAllData();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).getUserName().equalsIgnoreCase(name))
            {
                return list.get(i).booking;
            }
        }
        return null; 
    }
    
    public static void EmptyFile(){
       try{
            
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customer.txt"));
        oos.close();
        }
        catch(IOException e){
            System.out.println("Error File Writing");
        } 
    }
    
    public static void deleteCustomer(String username){
        
        ArrayList<Customer> list = readAllData();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).getUserName().equalsIgnoreCase(username))
            {
                list.remove(list.get(i));
                break;
            }
        }

        try{
            
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customer.txt"));

            for(Customer i: list){              
                oos.writeObject(i);
            }
            oos.close();
        }
        catch(IOException e){
            System.out.println("Error File Writing");
        }
    }

}