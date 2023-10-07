package com.example.myapplication.Models;


public class Attendance_Model {
    public int img;
    public String name;
    public String roll_number;
    String selectedRadio;
    

    public Attendance_Model(int img, String name, String roll_number){

        this.img = img;
        this.name=name;
        this.roll_number=roll_number;
        this.selectedRadio = selectedRadio;// "P", "A", or "L"


    }


    public void setSelectedRadio(String selectedRadio) {
        this.selectedRadio = selectedRadio;
    }

    public String getSelectedRadio() {
        return selectedRadio;
    }
}
