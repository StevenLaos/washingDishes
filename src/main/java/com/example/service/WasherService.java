package com.example.service;

import com.example.bean.Washer;

/**
 * Created by User on 6/26/2017.
 */
public class WasherService {

    WorkerService workerService = new WorkerService();

    public String readyToWash(Washer washer) {
        String[] washerNames = washer.getWorkerName().split(" ");
        String firstName = washerNames[0];
        String lastName = washerNames[1];
        double efficiency = workerService.findWorkerEfficiency(firstName, lastName);
        double liquid = washer.getLiquidAmount();
        double dishes = washer.getDishAmount();
        double maxDishes = liquid / efficiency;
        if (dishes < maxDishes) {
            double dishesLeft = maxDishes - dishes;
            double liquidInBottle = dishesLeft * efficiency;
            return "Worker washed all dishes and didn't use " + String.format("%.2f", liquidInBottle) + " ml of washing liquid.";
        }else if(dishes > maxDishes){
            double dishesLeftInRow = dishes - maxDishes;
            return "Worker used all liquid and needs to wash " + String.format("%.2f", dishesLeftInRow) + " more dishes.";
        }else if (dishes == maxDishes) {
            return "All used for washing and all dishes are clean.";
        }
        return "Something went Wrong";
    }
}