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
        address1.setCity("Малиновка");
        address1.setZipCode("100500");

        Employees employees1 = new Employees();
        employees1.setFirstName("Кристинка");
        employees1.setLastName("Бывалая");
        employees1.setPosition("dev");
        employees1.setSalary(1500);
        employees1.setAddress(address1);



    }

}