package org.example.controller;

import org.example.repositiry.impl.EmployeesRepositoryImpl;
import org.example.service.EmployeesService;
import org.example.view.View;

public class Controller {
    EmployeesService service;
    private View view;

    public Controller(EmployeesService service, View view) {
        this.service = service;
        this.view = view;
    }

    public void startApp(){
        filter(view.options());
    }

    private void filter(int userChoose) {
        switch (userChoose) {
//        case 1 -> service.createEmployees("Тут должна быть передача данных с viewCreate");
            case 2 -> view.showOutput(service.getAllEmployees());

        }

    }
}
