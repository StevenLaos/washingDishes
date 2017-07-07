package com.example.bean;

/**
 * Created by User on 6/15/2017.
 */
public class Worker {
    private String firstName;
    private String lastName;
    private int efficiency; //Shows how much dishes you can wash with 1 ml.
    private int id;

    public Worker(){

    }

    public Worker(String firstName, String lastName, int efficiency, int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.efficiency = efficiency;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public int getId() {
        return id;
    }

}
