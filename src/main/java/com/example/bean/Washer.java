package com.example.bean;

/**
 * Created by User on 6/21/2017.
 */

public class Washer {

    private int liquidAmount;
    private int dishAmount;
    private String workerWork;

    public Washer(){

    }

    public Washer(int liquidAmount, int dishes, String workerWork){
        this.liquidAmount = liquidAmount;
        this.dishAmount = dishes;
        this.workerWork = workerWork;
    }

    public int getLiquidAmount() {
        return liquidAmount;
    }

    public int getDishAmount() {
        return dishAmount;
    }

    public String getWorkerWork() {
        return workerWork;
    }
}

