package org.example.controller;

import org.example.service.EmployeesService;
import org.example.view.ReadByIdView;

public class ReadByIdController {
    EmployeesService service;

    ReadByIdView view;

    public ReadByIdController(EmployeesService service, ReadByIdView view) {
        this.service = service;
        this.view = view;
    }

    public void reedByIdEmployee(){
        view.getOutput(service.readEmployeeById(view.getData()));
    }
}
