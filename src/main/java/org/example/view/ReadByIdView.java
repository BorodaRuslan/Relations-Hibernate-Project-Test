package org.example.view;

import java.util.Scanner;

public class ReadByIdView {

    public long getData(){
        Scanner scanner = new Scanner(System.in);
        long choice;
        do {
            System.out.println("Enter employee id: ");
            choice= scanner.nextLong();
            if (choice >= 0)
                return choice;
            else
                System.out.println("Error: incorrect id");
        } while (true);
    }

    public void getOutput(String output){
        System.out.println("___Search result by id___");
        System.out.println(output);
    }
}
