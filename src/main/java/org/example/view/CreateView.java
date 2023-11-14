package org.example.view;

import org.example.entity.Employees;
import org.example.validation.Validation;
import org.postgresql.shaded.com.ongres.scram.common.ScramStringFormatting;

import java.util.Scanner;

public class CreateView {


    public Employees createNewEmployees(){

        String[] dataArray = dataNewEmployees();
        // Todo: Нужно сделать проверку данных!

        return new Employees();

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

        System.out.println("Enter your zip-code");
        String zipCode = scanner.next();

        return new String[]{firstName, lastName, position, salaty, city, zipCode};
    }
}
