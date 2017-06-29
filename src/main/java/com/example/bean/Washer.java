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
    //Vaja ära deklareerida paar muutujat, et kasutaja antud arvudega saaks tegeleda õigesti
    /*public static void main(String[] args){
        int MaxDishWash = efficiency * liquidAmount;
        if(dishAmount < MaxDishWash){
            int liquidLeftOver = MaxDishWash - dishAmount;
            double liquidInBottle = liquidLeftOver / efficiency;
        }else if(dishAmount > MaxDishWash){
            double dishesLeftOver = dishAmount - MaxDishWash;
        }else if(dishAmount == MaxDishWash){
            "all used for washing";
        }else{
            "something went wrong";
        }

    }*/
    public int getLiquidAmount() {
        return liquidAmount;
    }

    public void setLiquidAmount(int liquidAmount) {
        this.liquidAmount = liquidAmount;
    }

    public int getDishAmount() {
        return dishAmount;
    }

    public void setDishAmount(int dishAmount) {
        this.dishAmount = dishAmount;
    }
    public String getWorkerWork() {
        return workerWork;
    }

    public void setWorkerWork(String workerWork) {
        this.workerWork = workerWork;
    }

}

