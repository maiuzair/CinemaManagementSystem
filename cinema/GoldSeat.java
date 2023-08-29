package cinema;
import java.io.*;
public class GoldSeat extends Seat implements Serializable{

    public GoldSeat(boolean seatStatus, double cost) {
        super(seatStatus);
        seatCost = cost;
    }

    @Override
    public double getSeatCost() {
        return seatCost;
    }

    @Override
    public void setSeatCost(double cost) {
        seatCost = cost;
    }
    
}
