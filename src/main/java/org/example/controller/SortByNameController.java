package org.example.controller;

import org.example.service.EmployeesService;
import org.example.view.SortByNameView;

public class SortByNameController {
    private SortByNameView view;
    private EmployeesService service;
    public SortByNameController(SortByNameView view, EmployeesService service) {
        this.view = view;
        this.service = service;
    }
    public void sortByName(){
        view.getOutput(service.sortBySalary());
    }
}
