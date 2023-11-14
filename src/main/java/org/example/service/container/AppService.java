package org.example.service.container;

import org.example.controller.CreateEmployeesController;
import org.example.controller.ReadEmployeesController;
import org.example.repositiry.impl.EmployeesRepositoryImpl;
import org.example.service.EmployeesService;
import org.example.view.CreateView;
import org.example.view.ReadView;

public class AppService {

    public void snowAllEmployees(){
        ReadView view = new ReadView();
        EmployeesRepositoryImpl repository = new EmployeesRepositoryImpl();
        EmployeesService service = new EmployeesService(repository);
        ReadEmployeesController controller = new ReadEmployeesController(service, view);

        controller.readAllEmployees();

    }
    public void createEmployees(){
        CreateView view = new CreateView();
        EmployeesRepositoryImpl repository = new EmployeesRepositoryImpl();
        EmployeesService service = new EmployeesService(repository);
        CreateEmployeesController controller = new CreateEmployeesController(view, service);

       controller.createEmployees();
    }


}
