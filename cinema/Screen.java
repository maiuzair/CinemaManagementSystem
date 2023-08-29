
package cinema;
import java.io.Serializable;
import java.io.*;
import java.io.File;
public class Screen implements Serializable  {
    int screenNo;
    int seatRows;
    int seatColumns;
    String screenType; // 2D, 3D;
    Seat[][] seats;

    Screen(){
        seats = new Seat[seatRows][seatColumns];
        for(int i = 0 ; i < seatRows ; i++){
            for(int j = 0 ; j < seatColumns ; j++){
                if(i == seatRows - 1){
                    seats[i][j] = new GoldSeat(false, 800);
                }
                else
                {
                    seats[i][j] = new SilverSeat(false, 500);
                }          
            }
        }
    }

    public Screen(int screenNo, int seatRows, int seatColumns, String screenType) {
        this.screenNo = screenNo;
        this.seatRows = seatRows;
        this.seatColumns = seatColumns;
        this.screenType = screenType;
        seats = new Seat[seatRows][seatColumns];
        for(int i = 0 ; i < seatRows ; i++){
            for(int j = 0 ; j < seatColumns ; j++){
                if(i == seatRows - 1){
                    seats[i][j] = new GoldSeat(false, 800);
                }
                else
                {
                    seats[i][j] = new SilverSeat(false, 500);
                }    
            }
        }
        
    }

    public int getScreenNo() {
        return screenNo;
    }

    public void setScreenNo(int screenNo) {
        this.screenNo = screenNo;
    }

    public int getSeatRows() {
        return seatRows;
    }

    public void setSeatRows(int seatRows) {
        this.seatRows = seatRows;
    }

    public int getSeatColumns() {
        return seatColumns;
    }

    public void setSeatColumns(int seatColumns) {
        this.seatColumns = seatColumns;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }


    public Seat[][] getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Screen{" + "screenNo=" + screenNo + ", seatRows=" + seatRows + ", seatColumns=" + seatColumns + '}';
    }

     
    
}
