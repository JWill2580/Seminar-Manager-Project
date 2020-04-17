/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


public class Staff {
    
    private String staffID;
    private String username;
    private String password;
    private String firstName;
    private String surname;
    private String bio;
    private String email;

    public Staff(String staffID, String username, String password, String firstName, String surname, String bio, String email) {
        this.staffID = staffID;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.bio = bio;
        this.email = email;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getBio() {
        return bio;
    }

    public String getEmail() {
        return email;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Staff{" + "staffID=" + staffID + ", username=" + username + '}';
    }
    
    
}
