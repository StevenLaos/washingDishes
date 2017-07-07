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

        int efficiency = workerService.findWorkerEfficieny(firstName, lastName);
        int liquidAmount = washer.getLiquidAmount();
        int dishAmount = washer.getDishAmount();
        int maxDishAmount = efficiency * liquidAmount;
        if (dishAmount < maxDishAmount) {
            int dishesLeft = maxDishAmount - dishAmount;
            double liquidInBottle = dishesLeft / efficiency;
            return "Worker washed all dishes and didn't use " + liquidInBottle + " ml of washing liquid.";
        } else if (dishAmount > maxDishAmount) {
            int dishesLeftOver = dishAmount - maxDishAmount;
            return "Worker used all liquid and needs to wash " + dishesLeftOver + " more dishes.";
        } else if (dishAmount == maxDishAmount) {
            return "All used for washing and all dishes are clean.";
        }
        return "Something went wrong.";
    }
}
