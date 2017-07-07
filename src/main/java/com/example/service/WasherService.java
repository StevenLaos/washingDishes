package com.example.service;

import com.example.bean.Washer;

/**
 * Created by User on 6/26/2017.
 */
public class WasherService {

    WorkerService workerService = new WorkerService();

    public String readyToWash(Washer washer) {
        String[] washerNames = washer.getWorkerWork().split(" ");
        String firstName = washerNames[0];
        String lastName = washerNames[1];

        double efficiency = workerService.findWorkerEfficieny(firstName, lastName);
        double liquidAmount = washer.getLiquidAmount();
        double dishAmount = washer.getDishAmount();
        double maxDishAmount = efficiency * liquidAmount;
        if (dishAmount < maxDishAmount) {
            double dishesLeft = maxDishAmount - dishAmount;
            double liquidInBottle = dishesLeft / efficiency;
            return "Worker washed all dishes and didn't use " + String.format("%.2f",liquidInBottle) + " ml of washing liquid.";
        } else if (dishAmount > maxDishAmount) {
            double dishesLeftOver = dishAmount - maxDishAmount;
            return "Worker used all liquid and needs to wash " + dishesLeftOver + " more dishes.";
        } else if (dishAmount == maxDishAmount) {
            return "All used for washing and all dishes are clean.";
        }
        return "Something went wrong.";
    }
}
