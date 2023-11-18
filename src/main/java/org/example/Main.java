package org.example;


import org.example.controller.AppController;
import org.example.entity.Address;
import org.example.entity.Employees;
import org.example.repositiry.impl.AddressRepositoryImpl;
import org.example.repositiry.impl.EmployeesRepositoryImpl;
import org.example.service.container.AppService;
import org.example.view.AppView;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {


        AppView view = new AppView();
        AppService service = new AppService();
        AppController controller = new AppController(service, view);

        controller.startApp();

    }

}