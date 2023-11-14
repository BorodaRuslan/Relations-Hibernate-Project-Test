package org.example.controller;

import org.example.service.EmployeesService;
import org.example.view.CreateView;

public class CreateEmployeesController {

    private CreateView view;
    private EmployeesService service;


    public CreateEmployeesController(CreateView view, EmployeesService service) {
        this.view = view;
        this.service = service;
    }
    public void createEmployees(){
        view.getOutput(service.createEmployees(view.createNewEmployees()));
    }
}
