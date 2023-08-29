package cinema;
import java.io.*;
import java.io.File;
import java.util.ArrayList;
public class Movie implements Serializable  {
    private String movieName;
    private String movieLanguage;
    private int movieMins;
    private String movieGenre;
    private Date movieReleaseDate;
    private String movieRating;
    
    public Movie() {
        this.movieName = "";
        this.movieLanguage = "";
        this.movieGenre = "";
        this.movieReleaseDate = new Date();
        this.movieRating = "";
    }

    public Movie(String movieName, String movieLanguage, int movieMins, String movieGenre, Date movieReleaseDate, String movieRating) {
        this.movieName = movieName;
        this.movieLanguage = movieLanguage;
        this.movieMins = movieMins;
        this.movieGenre = movieGenre;
        this.movieReleaseDate = movieReleaseDate;
        this.movieRating = movieRating;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public int getMovieMins() {
        return movieMins;
    }

    public void setMovieMins(int movieMins) {
        this.movieMins = movieMins;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public Date getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(Date movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" + "movieName=" + movieName + ", movieLanguage=" + movieLanguage + ",\n movieMins=" + movieMins + ", movieGenre=" + movieGenre + ",\n movieReleaseDate=" + movieReleaseDate + ", movieRating=" + movieRating + '}';
    }
    
        //--------------------------File Handling------------------
    
    public static void writeToFile(Movie s) //throws Exception
    {
        try{
            File f = new File("Movie.txt");
            ObjectOutputStream oos;
            if(f.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(f,true));
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(s);
            System.out.println("Added Successfully");
            oos.close();
            }
            catch(IOException e){
                System.out.println("Error File Writing");
            }
    }
    
    public static void readFromFile(){
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Movie.txt"));
            while(true)
            {
                Movie s = (Movie) ois.readObject();
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
    
    public static ArrayList<Movie> readAllData(){
        
        ArrayList <Movie> list = new ArrayList();
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Movie.txt"));
            while(true)
            {
                list.add((Movie) ois.readObject());
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
        
        ArrayList <Movie> list = new ArrayList();
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Movie.txt"));
            while(true)
            {
                Movie m = (Movie)ois.readObject();
                list.add(m);
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
    
    public static Movie searchMovie(String name){
        ArrayList<Movie> list = readAllData();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).getMovieName().equalsIgnoreCase(name))
            {
                return list.get(i);
            }
        }
        return null;
      
    }
    
    public static void EmptyFile(){
       try{
            
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Movie.txt"));
        oos.close();
        }
        catch(IOException e){
            System.out.println("Error File Writing");
        } 
    }
    
    public static void deleteStudent(String username){
        
        ArrayList<Movie> list = readAllData();
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).getMovieName().equalsIgnoreCase(username))
            {
                list.remove(list.get(i));
            }
        }

        try{
            
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Movie.txt"));

            for(Movie i: list){              
                oos.writeObject(i);
            }
            oos.close();
        }
        catch(IOException e){
            System.out.println("Error File Writing");
        }
        
        
    }
    
    
    
    
}
