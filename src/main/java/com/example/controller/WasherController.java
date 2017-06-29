package com.example.controller;

import com.example.bean.Washer;
import com.example.service.WasherService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by User on 6/26/2017.
 */
@Path("/washer")
public class WasherController {

    WasherService washerService = new WasherService();


//    Kuidas ma pean nimetama ja kuidas ma saan nii teha, et WasherService kasutab worker-it kui ka washer java-t.
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Washer rdyToWash(Washer washer) {
        return washerService.rdyToWash(washer);
    }
}
