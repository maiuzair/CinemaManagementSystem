package cinema;
import java.io.Serializable;
import java.io.*;
import java.io.File;
public class Admin implements Serializable{
    private String adminID;
    private String adminPassword;
    private Cinema cinema;
    
    
    public Admin() {
        this.adminID = "";
        this.adminPassword = "";
        cinema = new Cinema();
    }

    public Admin(String adminID, String adminPassword, Cinema cinema) {
        this.adminID = adminID;
        this.adminPassword = adminPassword;
        this.cinema = cinema;
    }
    
    public Admin(Admin a){
        this.adminID = a.adminID;
        this.adminPassword = a.adminPassword;
        this.cinema = a.cinema;
 
    }

    public String getAdminPassword() {
        return adminPassword;
        
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    
    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    @Override
    public String toString() {
        return "Admin{" + "adminID=" + adminID + ", adminPassword=" + adminPassword + ", cinema=" + cinema.toString() + '}';
    }
    
}
