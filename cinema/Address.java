package cinema;
import java.io.*;
public class Address  implements Serializable{
    private String home;
    private int street;
    private String city;
    
    Address(){
    home = "hx";
    street= 8;
    city= "xyz";
    }
    Address(String h,int s,String c){
        home=h;
        street=s;
        city=c;
    }
    Address(Address a){
        this.home=a.home;
        this.street=a.street;
        this.city=a.city;
    }
    void setHome(String h){
        home=h;
    }
    void setStreet(int s){
        street =s;
    }
    void setCity(String c){
        city=c;
    }
    String getHome(){
        return home;
    }
    int getStreet(){
        return street;
    }
    String getCity(){
        return city;
    }
    void display(){
        System.out.println("H#"+home+", St#"+street+", "+city);
    }
}


