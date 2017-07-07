package com.example.controller;

import com.example.bean.Washer;
import com.example.service.WasherService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

/**
 * Created by User on 6/26/2017.
 */
@Path("/washer")
public class WasherController {

    private WasherService washerService = new WasherService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Object readyToWash(Washer washer) {
        final String answer = washerService.readyToWash(washer);
        return new HashMap<String, Object>() {{ put("answer", answer); }};
    }
}
