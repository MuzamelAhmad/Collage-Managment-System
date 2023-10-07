package com.example.myapplication;

public class ProfessorStorage {
    String name, father_name, cnic, Salary, Position, grade, Date_Of_barth, Date_Of_Joining, registration_Number, Military_Member, Username, phone, Email, password;

    public ProfessorStorage(String name, String father_name, String cnic, String salary, String position, String grade, String date_Of_barth, String date_Of_Joining, String registration_Number, String military_Member, String username, String phone, String email, String password) {
        this.name = name;
        this.father_name = father_name;
        this.cnic = cnic;
        Salary = salary;
        Position = position;
        this.grade = grade;
        Date_Of_barth = date_Of_barth;
        Date_Of_Joining = date_Of_Joining;
        this.registration_Number = registration_Number;
        Military_Member = military_Member;
        Username = username;
        this.phone = phone;
        Email = email;
        this.password = password;
    }

    public ProfessorStorage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDate_Of_barth() {
        return Date_Of_barth;
    }

    public void setDate_Of_barth(String date_Of_barth) {
        Date_Of_barth = date_Of_barth;
    }

    public String getDate_Of_Joining() {
        return Date_Of_Joining;
    }

    public void setDate_Of_Joining(String date_Of_Joining) {
        Date_Of_Joining = date_Of_Joining;
    }

    public String getRegistration_Number() {
        return registration_Number;
    }

    public void setRegistration_Number(String registration_Number) {
        this.registration_Number = registration_Number;
    }

    public String getMilitary_Member() {
        return Military_Member;
    }

    public void setMilitary_Member(String military_Member) {
        Military_Member = military_Member;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
