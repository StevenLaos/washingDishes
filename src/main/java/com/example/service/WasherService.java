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
        double efficiency = workerService.findWorkerEfficieny(firstName, lastName);
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
        /*double maxDishAmount = efficiency * liquid;
        if (dishes < maxDishAmount) {
            double dishesLeft = maxDishAmount - dishAmount;
            double liquidInBottle = dishesLeft / efficiency;
            return "Worker washed all dishes and didn't use " + String.format("%.2f",liquidInBottle) + " ml of washing liquid.";
        } else if (dishes > maxDishAmount) {
            double dishesLeftOver = dishAmount - maxDishAmount;
            return "Worker used all liquid and needs to wash " + dishesLeftOver + " more dishes.";
        } else if (dishes == maxDishAmount) {
            return "All used for washing and all dishes are clean.";
        }
        return "Something went wrong."; */
       /*double maxLiquid = efficiency * dishes;
        if (liquid > maxLiquid) {
                double liquidLeft = liquid - maxLiquid;
                return "Worker washed all dishes and didn't use " + liquidLeft + " liquid.";
                }else if(liquid < maxLiquid){
        double dishesLeft = maxLiquid - liquid;
        double dishesLeftInRow = dishesLeft / efficiency;
        return "Worker used all liquid and didn't wash " + String.format("%.0f",dishesLeftInRow) + " dishes.";
        }else if (liquid == maxLiquid) {
        return "All used for washing and all dishes are clean.";
        }
        return "Something went Wrong";*/