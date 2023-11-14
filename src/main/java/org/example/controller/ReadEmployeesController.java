package org.example.controller;

import org.example.service.EmployeesService;
import org.example.view.ReadView;

public class ReadEmployeesController {
     EmployeesService service;
     ReadView view;

    public ReadEmployeesController(EmployeesService service, ReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readAllEmployees(){
        view.getOutput(service.getAllEmployees());
    }
}
