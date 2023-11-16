package org.example.view;

import java.util.Scanner;

public class DeleteView {

    public long deleteEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee ID: ");
        long choice;
        do {
            choice = scanner.nextLong();
            if (choice >= 0)
                return choice;
            else
                System.out.println("Error: incorrect id");

        } while (true);
    }

    public void getOutput(String output){
        System.out.println("___The employee has been removed from the database___");
        System.out.println(output);
    }
}
