package cinema;
import java.io.*;
public abstract class Seat implements Serializable {
    protected boolean seatStatus;
    protected double seatCost;
   
    public Seat(boolean seatStatus) {
        this.seatStatus = seatStatus;
    }

    public boolean getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(boolean seatStatus) {
        this.seatStatus = seatStatus;
    }

    public abstract double getSeatCost(); 

    public abstract void setSeatCost(double seatCost); 

}
