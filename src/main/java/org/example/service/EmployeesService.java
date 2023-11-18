package org.example.service;

import org.example.entity.Employees;
import org.example.repositiry.impl.EmployeesRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class EmployeesService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeesService.class);
    private final EmployeesRepositoryImpl repository;
    private StringBuilder stringBuilder;

    public EmployeesService(EmployeesRepositoryImpl repository) {
        this.repository = repository;
    }

    public String getAllEmployees(){
        stringBuilder = new StringBuilder();

        List<Employees> employeesList = repository.readAll();
        if (!employeesList.isEmpty()){
            int count = 1;
            for (Employees empl: employeesList){

                stringBuilder.append(count).append(")").append(empl.getFirstName()).append(" ")
                        .append(empl.getLastName()).append(". Position: ").append(empl.getPosition())
                        .append(" Salary: ").append(empl.getSalary()).append("$ Home address: ")
                        .append(empl.getAddress().getCity()).append(" ")
                        .append(empl.getAddress().getZipCode()).append("\n");
                count++;
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


    public String readEmployeeById(Long id){
        stringBuilder = new StringBuilder();
        if (id >= 0){
            Employees employee = repository.readById(id);
            if (employee != null) {
                return stringBuilder.append("Employee: ").append(employee.getFirstName()).append(" ").append(employee.getLastName())
                        .append(" ").append("Employee position: ").append(employee.getPosition())
                        .append(" ").append(employee.getSalary()).append(" ").append("Address: ")
                        .append(employee.getAddress().getCity()).append(" ").append(employee.getAddress().getZipCode())
                        .append("\n").toString();
            }
        }
        return stringBuilder.append("Incorrect id").toString();
    }

    // Todo: This method doesn't work!


    public String deleteEmployeeById(Long id){
        stringBuilder = new StringBuilder();
        Employees employee = repository.delete(id);
        if (employee != null){
            return stringBuilder.append("The employee: ").append(employee.getFirstName()).append(" ")
                    .append(employee.getLastName()).append(" ").append("was removed!").toString();
        }
        return stringBuilder.append("There is no such employee in the database!").toString();
    }

    public String sortByName(){
        stringBuilder = new StringBuilder();
        List<Employees> employees = repository.sortByName();
        if (!employees.isEmpty()){
            for (Employees employ: employees){
                return stringBuilder.append(employ.getFirstName()).append(" ").append(employ.getLastName())
                        .append(" ").append(employ.getPosition()).append(" ").append(employ.getSalary())
                        .append(" ").append(employ.getAddress().getCity()).append(" ")
                        .append(employ.getAddress().getZipCode()).append("\n").toString();
            }
        }
        return stringBuilder.append("Empty database ").toString();
    }


}
