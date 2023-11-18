package org.example.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class AppView {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppView.class);

    public  int options(){
        Scanner scanner = new Scanner(System.in);
        int userChoose;
        do {
            menu();
            userChoose = scanner.nextInt();

        } while (userChoose < 0 || userChoose > 5);
        return userChoose;


    }


    private void menu(){
        System.out.println("""
                
                Hello brother! Make your choose a menu number
                
                1. Create new employee.
                2. See all employees.
                3. See employee by id.
                4. Delete employee.
                5. Sorting employees.
                0. Exit the application
                
                """);
    }
    public void showOutput(String result) {
        System.out.println(result);
    }
}
