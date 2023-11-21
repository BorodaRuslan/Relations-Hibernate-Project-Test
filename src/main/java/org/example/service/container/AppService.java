package org.example.service.container;

import org.example.controller.*;
import org.example.repositiry.impl.EmployeesRepositoryImpl;
import org.example.service.EmployeesService;
import org.example.view.*;

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

    public void sortByName(){
        SortByNameView view = new SortByNameView();
        EmployeesRepositoryImpl repository = new EmployeesRepositoryImpl();
        EmployeesService service = new EmployeesService(repository);
        SortByNameController controller = new SortByNameController(view, service);

        controller.sortByName();

    }

    public void sortBySalary(){
        SortBySalaryView view = new SortBySalaryView();
        EmployeesRepositoryImpl repository = new EmployeesRepositoryImpl();
        EmployeesService service = new EmployeesService(repository);
        SortBySalaryController controller = new SortBySalaryController(view, service);

        controller.sortBySalary();
    }

    public static void startApp(){
        AppView view = new AppView();
        AppService service = new AppService();
        AppController controller = new AppController(service, view);
        controller.startApp();

    }


}
