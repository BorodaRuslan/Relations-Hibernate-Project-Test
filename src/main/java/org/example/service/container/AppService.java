package org.example.service.container;

import org.example.controller.ReadEmployeesController;
import org.example.repositiry.impl.EmployeesRepositoryImpl;
import org.example.service.EmployeesService;
import org.example.view.ReadView;

public class AppService {

    public void snowAllEmployees(){
        ReadView view = new ReadView();
        EmployeesRepositoryImpl repository = new EmployeesRepositoryImpl();
        EmployeesService service = new EmployeesService(repository);
        ReadEmployeesController controller = new ReadEmployeesController(service, view);

        controller.readAllEmployees();

    }


}
