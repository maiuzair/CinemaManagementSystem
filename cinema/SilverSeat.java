package cinema;
import java.io.Serializable;


public class SilverSeat extends Seat
{

    public SilverSeat(boolean seatStatus, double cost) {
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
