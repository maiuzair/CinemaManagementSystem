package cinema;

import java.io.*;
import java.util.ArrayList;

public class Booking implements Serializable {

    double cost;
    ShowMovie show;
    int bookedSeat;
    ShowMovie temp;
    public Booking(double cost, ShowMovie show) {
        
        this.cost = cost;
        this.show = show;
        bookedSeat = 0;
    }
    
    public int BookedSeat(String movie){
        temp = ShowMovie.searchShowMovie("DSA");

        for(int i = 0; i<5; i++){
            for(int j=0; j<5; j++){
                
                if(temp.getScreen().seats[i][j].seatStatus == true)
                    bookedSeat++;
            }
        }
        
        return bookedSeat;

        
    }
    
    public Booking(){
        show = new ShowMovie();
    }

    @Override
    public String toString() {
        return "Booking{" + "cost=" + cost + ", show=" + show + '}';
    }

}
