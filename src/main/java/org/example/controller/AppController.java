package org.example.controller;

import org.example.service.EmployeesService;
import org.example.service.container.AppService;
import org.example.view.AppView;

public class AppController {
    private final AppService service;
    private final AppView view;

    public AppController(AppService service, AppView view) {
        this.service = service;
        this.view = view;
    }

    public void startApp(){
        filter(view.options());
    }

    private void filter(int userChoose) {
        switch (userChoose) {
            case 1 -> service.createEmployees();
            case 2 -> service.snowAllEmployees();
            case 3 -> service.readByIdEmployee();
            case 4 -> service.deleteEmployee();

        }

    }
}
