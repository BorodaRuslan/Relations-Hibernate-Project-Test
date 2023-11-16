package org.example.view;

import org.example.entity.Address;
import org.example.entity.Employees;
import org.example.validation.Validation;
import org.postgresql.shaded.com.ongres.scram.common.ScramStringFormatting;

import java.util.Scanner;

public class CreateView {


    public Employees createNewEmployees() {

        Employees employees = null;
        String[] dataArray = dataNewEmployees();
        Address address = Address.builder()
                .city(dataArray[4])
                .zipCode(dataArray[5])
                .build();
        employees = Employees.builder()
                .firstName(dataArray[0])
                .lastName(dataArray[1])
                .position(dataArray[2])
                .salary(Double.parseDouble(dataArray[3]))
                .address(address)
                .build();
        return employees;

    }


    private String[] dataNewEmployees(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = scanner.next().trim();

        System.out.println("Enter your last name: ");
        String lastName = scanner.next().trim();

        System.out.println("Enter your position: ");
        String position = scanner.next();

        System.out.println("Enter your salary: ");
        String salaty = scanner.next();

        System.out.println("Enter your city: ");
        String city = scanner.next();

        System.out.println("Enter your zip-code: [Zip code has 6 numbers]");
        String zipCode = scanner.next();

        return new String[]{firstName, lastName, position, salaty, city, zipCode};
    }

    public void getOutput(String output){
        System.out.println("Staff member was successfully retained! \n");
        System.out.println(output);

    }
}
