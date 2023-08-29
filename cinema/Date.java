package cinema;

import java.io.Serializable;

public class Date implements Serializable {
    
    private int day, month, year;
    
    Date(){
        
    }
            
    Date(int d, int m, int y){
        day = checkDays(d);
        month = checkMonth(m);
        year = y; 
    }
    
    Date(Date d){
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = checkDays(day);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = checkMonth(month);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public int checkMonth(int m){  
        if(m > 0 && m <= 12)
            return m;
        else return -1;
    }
    
    public int checkDays(int d){  
        int[] dpm = {0, 31, 28,31, 30, 31,30, 31, 31, 30, 31, 30,31};
        if(d > 0 && d <= dpm[month])
            return d;
        
        if(month == 2 && d == 29 && (year%400 == 0 || (year%4 == 0 && year%100 != 0))  )
            return d;
        
       return -1;
        
    }

    @Override
    public String toString() {
        return "Date{" + "day=" + day + ", month=" + month + ", year=" + year + '}';
    }         
}
