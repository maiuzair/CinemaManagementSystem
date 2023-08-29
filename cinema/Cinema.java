package cinema;

import java.util.ArrayList;
import java.io.Serializable;
import java.io.*;
import java.io.File;

public class Cinema implements Serializable {
    String cinemaName;
    Address address;
    ArrayList<Employee> employeeList;
    ArrayList<Customer> customerList;
    ArrayList<Movie> movieList;
    ArrayList<Screen> screenList;
    ArrayList<ShowMovie> showsList;
    
    public Cinema(){
        this.cinemaName = "";
        this.address = new Address();
        //this.employeeList = new ArrayList<>();
        this.customerList = new ArrayList<>();
        this.movieList = new ArrayList<>();
        this.screenList = new ArrayList<>();
        this.showsList = new ArrayList<>();
    }

    public Cinema(String cinemaName, Address address) {
        this.cinemaName = cinemaName;
        this.address = address;
        //this.employeeList = new ArrayList<>();
        this.customerList = new ArrayList<>();
        this.movieList = new ArrayList<>();
        this.screenList = new ArrayList<>();
        this.showsList = new ArrayList<>();
    }
    
    public String getName() {
        return cinemaName;
    }

    public void setName(String name) {
        this.cinemaName = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
       
        return "Cinema{" +  ", name=" + cinemaName + ", address=" + address.toString() + customerList + movieList + screenList + showsList + '}';
    }

//    void addEmployee(Employee e){
//        this.employeeList.add(e);
//    }
//    
//    void removeEmployee(String username){
//        for(Employee i: employeeList){
//            if(i.getUserName() == username)
//                employeeList.remove(i);
//        }      
//    }
    
    void addCustomer(Customer m){
        this.customerList.add(m);
    }
    
    void removeCustomer(String name){
        for(Customer i: customerList){
            if(i.getUserName().equals(name))
                customerList.remove(i);
        }      
    }
    
    void addMovie(Movie m){
        this.movieList.add(m);
    }
    
    void removeMovie(String name){
        for(Movie i: movieList){
            if(i.getMovieName().equalsIgnoreCase(name))
                movieList.remove(i);
        }      
    }
    
    void addScreen(Screen s){
        this.screenList.add(s);
    }
    
    void removeScreen(int n){
        for(Screen i: screenList){
            if(i.screenNo == n)
                screenList.remove(i);
        }
    }
    
    void addShows(ShowMovie s){
        showsList.add(s);
    }
    
    void removeShows(String movie){
        for(ShowMovie i: showsList){
            if(i.getMovie().getMovieName().equalsIgnoreCase(movie))
                screenList.remove(i);
        }
    }
    
    
        //--------------------------File Handling------------------
    
        public static void writeToFile(Cinema s) //throws Exception
    {
        try{
            File f = new File("Cinema.txt");
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
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Cinema.txt"));
            while(true)
            {
                Cinema s = (Cinema) ois.readObject();
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
    
    public static ArrayList<Cinema> readAllData(){
        
        ArrayList <Cinema> list = new ArrayList();
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Cinema.txt"));
            while(true)
            {
                list.add((Cinema) ois.readObject());
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
        
        ArrayList <Cinema> list = new ArrayList();
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Cinema.txt"));
            while(true)
            {
                list.add((Cinema) ois.readObject());
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
    
    public static Cinema searchCinema(String name){
        ArrayList<Cinema> list = readAllData();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).cinemaName.equalsIgnoreCase(name))
            {
                return list.get(i);
            }
        }
        return null;
      
    }
    
    public static ArrayList<ShowMovie> searchShows(String name){
        ArrayList<Cinema> list = readAllData();
        ArrayList<ShowMovie> showList = new ArrayList<>();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).cinemaName.equalsIgnoreCase(name))
            {
                showList = list.get(i).showsList;
            }
        }
        return showList;
      
    }   
    
    public static ArrayList<Movie> searchMovies(String name){
        ArrayList<Cinema> list = readAllData();
        ArrayList<Movie> currList = new ArrayList<>();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).cinemaName.equalsIgnoreCase(name))
            {
                currList = list.get(i).movieList;
            }
        }
        return currList;  
    }
    
    public static ArrayList<Customer> searchCustomers(String name){
        ArrayList<Cinema> list = readAllData();
        ArrayList<Customer> currList = new ArrayList<>();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).cinemaName.equalsIgnoreCase(name))
            {
                currList = list.get(i).customerList;
            }
        }
        return currList;
      
    }

    
    public static ArrayList<Screen> searchScreens(String name){
        ArrayList<Cinema> list = readAllData();
        ArrayList<Screen> currList = new ArrayList<>();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).cinemaName.equalsIgnoreCase(name))
            {
                currList = list.get(i).screenList;
            }
        }
        return currList;
      
    }
    
    
    public static void EmptyFile(){
       try{
            
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Cinema.txt"));
        oos.close();
        }
        catch(IOException e){
            System.out.println("Error File Writing");
        } 
    }
    
    public static void deleteStudent(String username){
        
        ArrayList<Cinema> list = readAllData();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).cinemaName.equalsIgnoreCase(username))
            {
                list.remove(list.get(i));
            }
        }

        try{
            
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Cinema.txt"));

            for(Cinema i: list){              
                oos.writeObject(i);
            }
            oos.close();
        }
        catch(IOException e){
            System.out.println("Error File Writing");
        }
    }
    

    
    
}
