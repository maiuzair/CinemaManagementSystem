package cinema;

import java.io.Serializable;

public class User implements Serializable{
    private String userName;
    private String password;
    private String email;
    private String phone;

    

    public User() {
        userName = "";
        password = "";
        email = "";
        phone = "";

    }

    public User(String userName, String password, String email, String phone) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;

    }
   
    
    //---------------copy constructor--------------
    public User(User u){
        
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", password=" + password + ", email=" + email + ", phone=" + phone +  '}';
    }

}
