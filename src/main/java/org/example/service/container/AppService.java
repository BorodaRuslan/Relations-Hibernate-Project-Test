package org.example.service.container;

import org.example.controller.CreateEmployeesController;
import org.example.controller.DeleteController;
import org.example.controller.ReadByIdController;
import org.example.controller.ReadEmployeesController;
import org.example.repositiry.impl.EmployeesRepositoryImpl;
import org.example.service.EmployeesService;
import org.example.view.CreateView;
import org.example.view.DeleteView;
import org.example.view.ReadByIdView;
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

    public void readByIdEmployee(){
        ReadByIdView view = new ReadByIdView();
        EmployeesRepositoryImpl repository = new EmployeesRepositoryImpl();
        EmployeesService service = new EmployeesService(repository);
        ReadByIdController controller = new ReadByIdController(service, view);

        controller.reedByIdEmployee();
    }

    public void deleteEmployee(){
        DeleteView view = new DeleteView();
        EmployeesRepositoryImpl repository = new EmployeesRepositoryImpl();
        EmployeesService service = new EmployeesService(repository);
        DeleteController controller = new DeleteController(service, view);

        controller.deleteEmployeeById();

    }


}
