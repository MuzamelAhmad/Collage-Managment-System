package com.example.myapplication;

public class UserHelperClass {
    String name;
    String Father_name;
    String CNIC;
    public String Roll_Number;
    String Program;
    String Semester;
    String Date_Of_barth;
    String Marks;
    String Registration_Number;
    String Military_Member;
    String Username;
    String phone;
    String Email;
    String password;

    public UserHelperClass() {
    }

    public UserHelperClass(String name, String father_name, String CNIC, String roll_Number, String program, String semester, String date_Of_barth, String marks, String registration_Number, String military_Member, String username, String phone, String email, String password) {
        this.name = name;
        Father_name = father_name;
        this.CNIC = CNIC;
        Roll_Number = roll_Number;
        Program = program;
        Semester = semester;
        Date_Of_barth = date_Of_barth;
        Marks = marks;
        Registration_Number = registration_Number;
        Military_Member = military_Member;
        Username = username;
        this.phone = phone;
        Email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_name() {
        return Father_name;
    }

    public void setFather_name(String father_name) {
        Father_name = father_name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getRoll_Number() {
        return Roll_Number;
    }

    public void setRoll_Number(String roll_Number) {
        Roll_Number = roll_Number;
    }

    public String getProgram() {
        return Program;
    }

    public void setProgram(String program) {
        Program = program;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getDate_Of_barth() {
        return Date_Of_barth;
    }

    public void setDate_Of_barth(String date_Of_barth) {
        Date_Of_barth = date_Of_barth;
    }

    public String getMarks() {
        return Marks;
    }

    public void setMarks(String marks) {
        Marks = marks;
    }

    public String getRegistration_Number() {
        return Registration_Number;
    }

    public void setRegistration_Number(String registration_Number) {
        Registration_Number = registration_Number;
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