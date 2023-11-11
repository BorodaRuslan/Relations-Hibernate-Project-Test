package org.example.view;

import org.example.repositiry.impl.EmployeesRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class View {

    private static final Logger LOGGER = LoggerFactory.getLogger(View.class);

    public int options(){
        Scanner scanner = new Scanner(System.in);
        int userChoose;
        menu();

        do {
            menu();
            userChoose = scanner.nextInt();
            if (userChoose <= 0 || userChoose > 2){
                LOGGER.warn("Incorrect data entry. Please enter a valid menu number");
            }
        } while (userChoose <= 0 || userChoose > 2);
        return userChoose;


    }


    private void menu(){
        System.out.println("""
                
                Hello brother! Make your choose a menu number
                
                1. Create new employee
                2. See all employees
                0. Exit the application
                
                """);
    }
    public void showOutput(String result) {
        System.out.println(result);
    }
}
