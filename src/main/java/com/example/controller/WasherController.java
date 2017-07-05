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

    //Vaja on tekitada POST ja GET aga praegu nad on 1 funktsioonis ja ma ei saa aru kas see on õigesti tehtud.
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Washer rdyToWash(Washer washer) {return washerService.rdyToWash(washer);}
}
