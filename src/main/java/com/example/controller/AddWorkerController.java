package com.example.controller;

import com.example.bean.Worker;
import com.example.service.WorkerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by User on 7/10/2017.
 */
@Path("/newWorker")
public class AddWorkerController {

    WorkerService workerService = new WorkerService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Worker addNewWorker(Worker worker){return workerService.addNewWorker(worker);}
}
