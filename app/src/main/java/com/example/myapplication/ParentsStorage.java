package com.example.myapplication;

public class ParentsStorage {

    String Name ,Roll_Number,Subject,Semester, Username, Phone , Email  , password;

    public ParentsStorage() {
    }

    public ParentsStorage(String name, String roll_Number, String subject, String semester, String username, String phone, String email, String password) {
        Name = name;
        Roll_Number = roll_Number;
        Subject = subject;
        Semester = semester;
        Username = username;
        Phone = phone;
        Email = email;
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRoll_Number() {
        return Roll_Number;
    }

    public void setRoll_Number(String roll_Number) {
        Roll_Number = roll_Number;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
