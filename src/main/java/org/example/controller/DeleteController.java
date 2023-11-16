package org.example.controller;

import org.example.service.EmployeesService;
import org.example.view.DeleteView;

public class DeleteController {
    EmployeesService service;
    DeleteView view;
    public DeleteController(EmployeesService service, DeleteView view) {
        this.service = service;
        this.view = view;
    }
    public void deleteEmployeeById(){
        view.getOutput(service.deleteEmployeeById(view.deleteEmployee()));
    }

}
