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

//        Address address1 = new Address();
//        address1.setCity("Житомир");
//        address1.setZipCode("110400");
//
//        Employees employees1 = new Employees();
//        employees1.setFirstName("Микола");
//        employees1.setLastName("Оселедець");
//        employees1.setPosition("dev");
//        employees1.setSalary(1400);
//        employees1.setAddress(address1);
//
//        EmployeesRepositoryImpl repository = new EmployeesRepositoryImpl();
//
//        Employees employees = repository.create(employees1);
//        System.out.println("Все прошло успешно: " + employees.toString());

        AppView view = new AppView();
        AppService service = new AppService();
        AppController controller = new AppController(service, view);

        controller.startApp();

    }

}