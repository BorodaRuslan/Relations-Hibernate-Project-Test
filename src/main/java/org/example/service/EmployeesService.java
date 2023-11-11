package org.example.service;

import org.example.entity.Employees;
import org.example.repositiry.impl.EmployeesRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class EmployeesService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeesService.class);
    private EmployeesRepositoryImpl repository;
    private StringBuilder stringBuilder;

    public String getAllEmployees(){
        stringBuilder = new StringBuilder();

        List<Employees> employeesList = repository.readAll();
        if (!employeesList.isEmpty()){
            int count = 1;
            for (Employees empl: employeesList){
                stringBuilder.append(count).append(" )").append(empl.getFirstName()).append(" ")
                        .append(empl.getLastName()).append(" ").append(empl.getPosition())
                        .append(" ").append(empl.getSalary()).append(" ")
                        .append(empl.getAddress().getCity()).append(" ")
                        .append(empl.getAddress().getZipCode()).append("\n");
            }
            return stringBuilder.toString();
        } else {
            return stringBuilder.append("Database is empty").toString();
        }
    }

    public String createEmployees(Employees employees){
        stringBuilder = new StringBuilder();
        Employees result = repository.create(employees);
        if (result != null)
            return stringBuilder
                    .append("Employees: " + result.getFirstName()).append(" ").append(result.getLastName())
                    .append(" ").append(result.getPosition()).append(" ").append(result.getSalary())
                    .append(" ").append(result.getAddress().getCity()).append(" ").append(result.getAddress().getZipCode())
                    .toString();
        else
            return stringBuilder.append("User save error!").toString();
    }

}
