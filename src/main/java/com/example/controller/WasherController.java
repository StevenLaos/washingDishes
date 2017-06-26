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


    //peaks minema localhost:9000/rest/washer. Kas suunan mujale ?
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Washer rdyToWash(Washer washer){return washerService.rdyToWash(washer);}
}
