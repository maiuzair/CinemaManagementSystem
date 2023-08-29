package cinema;
import java.io.Serializable;
import java.io.*;
import java.io.File;
import java.util.ArrayList;

public class ShowMovie implements Serializable  {
    //private int showno;
    private Date showDate;
    private Time showTime;
    private Screen screen;
    private Movie movie;
    
    public ShowMovie() {

    }

    public ShowMovie( Date showDate, Time showTime, Screen screen, Movie movie) {
       
        this.showDate = showDate;
        this.showTime = showTime;
        this.screen = screen;
        this.movie = movie;
    }

    
    
    public ShowMovie(ShowMovie s) {
        this.showDate = s.showDate;
        this.showTime = s.showTime;
        this.screen = s.screen;
        this.movie = s.movie;
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Time getShowTime() {
        return showTime;
    }

    public void setShowTime(Time showTime) {
        this.showTime = showTime;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    @Override
    public String toString() {
        return "ShowMovie{" + ", showDate=" + showDate + ", showTime=" + showTime + ", screen=" + screen + ", movie=" + movie + '}';
    }

    
    
           //--------------------------File Handling------------------
    
        public static void writeToFile(ShowMovie s) //throws Exception
    {
        try{
            File f = new File("ShowMovie.txt");
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
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ShowMovie.txt"));
            while(true)
            {
                ShowMovie s = (ShowMovie) ois.readObject();
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
    
    public static ArrayList<ShowMovie> readAllData(){
        
        ArrayList <ShowMovie> list = new ArrayList();
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ShowMovie.txt"));
            while(true)
            {
                ShowMovie m = (ShowMovie) ois.readObject();
                list.add(m);
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
        
        ArrayList <ShowMovie> list = new ArrayList();
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ShowMovie.txt"));
            while(true)
            {
                list.add((ShowMovie) ois.readObject());
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
    
    public static ShowMovie searchShowMovie(String no){
        ArrayList<ShowMovie> list = readAllData();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).getMovie().getMovieName().equalsIgnoreCase(no))
            {
                return list.get(i);
            }
        }
        return null;
      
    }
    
    public static void EmptyFile(){
       try{
            
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ShowMovie.txt"));
        oos.close();
        }
        catch(IOException e){
            System.out.println("Error File Writing");
        } 
    }
    
    public static void updateShowSeat(String movie, int u, int v){
        ArrayList<ShowMovie> list = readAllData();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).getMovie().getMovieName().equalsIgnoreCase(movie))
            {
                list.get(i).getScreen().seats[u][v].seatStatus = true;
            }
        }
        
        try{
            
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ShowMovie.txt"));
        
        for(ShowMovie i: list){              
                oos.writeObject(i);
            }
        oos.close();
        }
        catch(IOException e){
            System.out.println("Error File Writing");
        }
    }
    

}
