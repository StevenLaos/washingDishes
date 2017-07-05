package com.example.service;

import com.example.bean.Washer;

import java.sql.*;

/**
 * Created by User on 6/26/2017.
 */
public class WasherService {

    WorkerService workerService = new WorkerService();

    public String rdyToWash(Washer washer) {
        String[] washerNames = washer.getWorkerWork().split(" ");
        String washerFirstName = washerNames[0];
        String washerLastName = washerNames[1];

        int efficiency = workerService.findWorkerEfficieny(washerFirstName, washerLastName);
        int liquidAmount = washer.getLiquidAmount();
        int dishAmount = washer.getDishAmount();
        int maxDishAmount = efficiency * liquidAmount;
        if (dishAmount < maxDishAmount) {                      //dishesLeft on selleks, et arvutada pärast vedeliku,
            int dishesLeft = maxDishAmount - dishAmount;   //mis jääb purki
            double liquidInBottle = dishesLeft / efficiency;
            return "You washed all dishes and you didn't use" + liquidInBottle + " ml of washing liquid.";
        } else if (dishAmount > maxDishAmount) {
            int dishesLeftOver = dishAmount - maxDishAmount;
            return "You used all liquid and you need to wash " + dishesLeftOver + " more dishes";
        } else if (dishAmount == maxDishAmount) {
            return "all used for washing";
        }
        return "something went wrong";
    }
}
