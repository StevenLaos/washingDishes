package com.example.bean;

/**
 * Created by User on 6/21/2017.
 */

public class Washer {

    private int liquidAmount;
    private int dishAmount;
    private String workerName;

    public Washer(){

    }

    public Washer(int liquidAmount, int dishes, String workerName){
        this.liquidAmount = liquidAmount;
        this.dishAmount = dishes;
        this.workerName = workerName;
    }

    public int getLiquidAmount() {
        return liquidAmount;
    }

    public int getDishAmount() {
        return dishAmount;
    }

    public String getWorkerName() {
        return workerName;
    }
}

