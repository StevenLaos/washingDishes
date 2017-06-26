package com.example.controller;

import com.example.bean.Worker;
import com.example.service.WorkerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by User on 6/15/2017.
 */
@Path("/worker")
public class WorkerController {

    WorkerService workerService = new WorkerService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Worker> getAllWorkers() {
        List<Worker> listOfWorkers = workerService.getAllWorkers();
        return listOfWorkers;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Worker addNewWorker(Worker worker) {
        return workerService.addNewWorker(worker);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteWorker(@PathParam("id") int id) {
        workerService.deleteWorker(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Worker editWorker(Worker worker) {
        return workerService.editWorker(worker);
    }
}
