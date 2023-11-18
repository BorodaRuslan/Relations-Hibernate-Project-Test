package org.example.view;

import org.example.repositiry.impl.EmployeesRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class SortingView {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortingView.class);
    public int chooseOptions(){
        Scanner scanner = new Scanner(System.in);
        int choose;

        do {
            sortingMenu();
           choose = scanner.nextInt();
           if (choose == 3){
               LOGGER.info("App is closed");
               break;
           }
           else if (choose < 0 || choose > 3) {
               LOGGER.error("Invalid choice. Please choose a valid option");
           }

        } while (true);
        return choose;
    }

    private void sortingMenu() {
        System.out.println("""
                 _____Choose a number from the menu____
                 
                 1.Sort by Name.
                 2.Sort by salary.
                 3.Close the application.
                
                """);
    }
}
