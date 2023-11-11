package org.example.service.container;

import org.example.controller.Controller;
import org.example.repositiry.impl.EmployeesRepositoryImpl;
import org.example.service.EmployeesService;
import org.example.view.View;

public class СontainerService {

    public void snowAllEmployees(){
        View view = new View();
        EmployeesRepositoryImpl repository = new EmployeesRepositoryImpl();
        EmployeesService service = new EmployeesService(repository);
        Controller controller = new Controller(service, view);

        controller.startApp();
    }


}
