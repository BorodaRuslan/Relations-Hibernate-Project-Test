package org.example;


import org.example.entity.Address;
import org.example.entity.Employees;
import org.example.repositiry.impl.AddressRepositoryImpl;
import org.example.repositiry.impl.EmployeesRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Address address1 = new Address();
        address1.setCity("Харьков");
        address1.setZipCode("100500");

        Employees employees1 = new Employees();
        employees1.setFirstName("Кристинка");
        employees1.setLastName("Бывалая");
        employees1.setPosition("dev");
        employees1.setSalary(1500);
        employees1.setAddress(address1);

        EmployeesRepositoryImpl employeesRepository = new EmployeesRepositoryImpl();
        AddressRepositoryImpl addressRepository = new AddressRepositoryImpl();
//        Address address = addressRepository.create(address1);
//        Employees employees = employeesRepository.create(employees1);
//        System.out.println(employees);

//        List<Employees> employees = employeesRepository.readAll();
//
//        employees.forEach(a -> System.out.println(
//                "Entity: " + a.getFirstName() + " " + a.getLastName() + " " + a.getPosition() + " " + a.getSalary() + " "
//                + a.getAddress().getCity() + " " + a.getAddress().getZipCode() + "!"
//        ));
//
//
//
//        Employees employees = employeesRepository.readById(2);
//        System.out.println(employees.getFirstName() + " " + employees.getLastName() + " " + employees.getAddress().getCity());

//        Employees delete = employeesRepository.delete(2);
//        System.out.println(delete.getFirstName() + " " + delete.getLastName());
//

//        List<Address> addresses = addressRepository.readAll();
//        addresses.forEach(value -> System.out.println(
//                "Адрес: " + value.getCity() + " " + value.getZipCode()
//        ));


        Address delete = addressRepository.delete(1);
        System.out.println("Адрес быд удален: " + delete.getCity());

    }

}