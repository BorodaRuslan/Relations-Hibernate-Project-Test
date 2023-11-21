package org.example.controller;

import org.example.service.EmployeesService;
import org.example.view.SortBySalaryView;

public class SortBySalaryController {
    private final SortBySalaryView view;
    private final EmployeesService service;

    public SortBySalaryController(SortBySalaryView view, EmployeesService service) {
        this.view = view;
        this.service = service;
    }
    public void sortBySalary(){
        view.getOutput(service.sortBySalary());
    }
}
